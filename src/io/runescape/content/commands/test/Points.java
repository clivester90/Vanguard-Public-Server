package io.runescape.content.commands.test;

import java.util.Optional;

import io.runescape.content.commands.Command;
import io.runescape.content.vote_panel.VotePanelManager;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class Points extends Command {
    @Override
    public void execute(Player player, String commandName, String input) {
        int points = 100_000_000;
        player.bossPoints = points;
        player.getSlayer().setPoints(points);
        player.donatorPoints = points;
        player.pcPoints = points;
        player.votePoints = points;
        player.achievementPoints = points;
        VotePanelManager.addVote(player.getLoginName());
        VotePanelManager.getUser(player).setBluePoints(points);
        VotePanelManager.getUser(player).setRedPoints(points);
        player.exchangePoints = points;
        player.pkp = points;
        player.amDonated = points;
        player.sendMessage("You have received " + Misc.insertCommas(points) + " of each point type.");
        player.getQuestTab().updateInformationTab();
    }

    public Optional<String> getDescription() {
        return Optional.of("Adds 100k of each point to your account.");
    }
}
