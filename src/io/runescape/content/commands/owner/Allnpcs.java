package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.npc.NPCSpawning;
import io.runescape.model.entity.player.Player;


public class Allnpcs extends Command {

    @Override
    public void execute(Player c, String commandName, String input) {
        int newNPC = Integer.parseInt(input);
        for (int x = c.absX; x < c.absX + 25; x++) {
            for (int y = c.absY; y < c.absY + 10; y++) {
                NPCSpawning.spawnNpc(c, newNPC++, x, y, c.heightLevel, 0, 7, false, false);
            }
        }
    }
}
