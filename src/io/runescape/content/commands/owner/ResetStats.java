package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * @author Arthur Behesnilian 1:11 PM
 */
public class ResetStats extends Command {

    @Override
    public void execute(Player player, String commandName, String input) {
        for (int i = 0; i < 22; i++) {
            player.playerLevel[i] = 1;
            player.playerXP[i] = player.getPA().getXPForLevel(1) + 1;
            player.getPA().refreshSkill(i);
            player.getPA().setSkillLevel(i, player.playerLevel[i], player.playerXP[i]);
            player.getPA().levelUp(i);
        }
    }


}
