package io.xeros.content.referral;

import java.util.List;
import java.util.Optional;

import io.xeros.content.dialogue.DialogueBuilder;
import io.xeros.content.dialogue.DialogueExpression;
import io.xeros.model.entity.player.Player;
import io.xeros.model.items.GameItem;

public class EnterReferralDialogue extends DialogueBuilder {
    public EnterReferralDialogue(Player c) {
        super(c);
        setNpcId(13)
                .npc(DialogueExpression.CALM_TALK, "Please enter a referral code you wish to use.")
                .continueAction(it -> it.getPA().sendEnterString("Enter the referral code", ((player1, string) -> {
                    Optional<ReferralCode> referralCodeOptional = ReferralCode.getReferralCodes().stream().filter(ref -> ref.getCode().equalsIgnoreCase(string)).findFirst();
                    referralCodeOptional.ifPresentOrElse(referralCode ->
                            register(c, string, referralCode.getRewards()), () -> c.start(new DialogueBuilder(c).statement("No code found!").exit(this::enteredReferral)));
                })));
    }

    private static void register(Player player, String qualifier, List<GameItem> rewards) {
        rewards.forEach(reward -> player.getItems().addItemUnderAnyCircumstance(reward.getId(), reward.getAmount()));
        ReferralRegister.register(player, ReferralSource.YOUTUBE, qualifier);
        player.usedReferral = true;
    }


    private void enteredReferral(Player player) {
        player.getPA().sendEnterString("Enter the referral code", ((player1, string) -> {
            Optional<ReferralCode> referralCodeOptional = ReferralCode.getReferralCodes().stream().filter(ref -> ref.getCode().equalsIgnoreCase(string)).findFirst();
            referralCodeOptional.ifPresentOrElse(referralCode ->
                    register(player, string, referralCode.getRewards()), () -> player.start(new DialogueBuilder(player).statement("No code found!").exit(this::enteredReferral)));
        }));
    }

}
