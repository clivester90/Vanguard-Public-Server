package io.xeros.content.referral;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import io.xeros.Server;
import io.xeros.content.dialogue.DialogueBuilder;
import io.xeros.content.dialogue.DialogueOption;
import io.xeros.model.Npcs;
import io.xeros.model.entity.player.Player;
import io.xeros.model.items.GameItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnterReferralDialogue extends DialogueBuilder {
    public EnterReferralDialogue(Player c) {
        super(c);
        c.getPA().sendEnterString("Enter the referral code", ((player1, string) -> {
            Optional<ReferralCode> referralCodeOptional = ReferralCode.getReferralCodes().stream().filter(ref -> ref.getCode().equalsIgnoreCase(string)).findFirst();
            referralCodeOptional.ifPresentOrElse(referralCode -> {
                register(c, ReferralSource.YOUTUBE, string, referralCode.getRewards(), "Redeemed '" + string + "' referral!");
            }, () -> c.start(new DialogueBuilder(c).statement("No code found!").exit(this::enteredReferral)));
        }));
    }

    private static void register(Player player, ReferralSource source, String qualifier, List<GameItem> rewards, String message) {
            rewards.forEach(reward -> player.getItems().addItemUnderAnyCircumstance(reward.getId(), reward.getAmount()));
            ReferralRegister.register(player, source, qualifier);
            player.usedReferral = true;
        }


    private void enteredReferral(Player player) {
        player.getPA().sendEnterString("Enter the referral code", ((player1, string) -> {
            Optional<ReferralCode> referralCodeOptional = ReferralCode.getReferralCodes().stream().filter(ref -> ref.getCode().equalsIgnoreCase(string)).findFirst();
            referralCodeOptional.ifPresentOrElse(referralCode -> {
                register(player, ReferralSource.YOUTUBE, string, referralCode.getRewards(), "Redeemed '" + string + "' referral!");
            },() -> player.start(new DialogueBuilder(player).statement("No code found!").exit(this::enteredReferral)));
        }));
    }

}
