package io.runescape.content.commands.owner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import io.runescape.Server;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.npc.NPCSpawning;
import io.runescape.model.entity.player.Player;

public class As extends Command {

	@Override
	public void execute(Player player, String commandName, String input) {
		addSpawn(player, input);
	}
	
	public void addSpawn(Player player, String animal) {
		String filePath = Server.getDataDirectory() + "/" + player.getLoginName() + " Lava Dragon.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            switch (animal.toUpperCase()) {

                case "B":
                    bw.write("spawn =	6593	" + player.absX + "	" + player.absY + "	" + player.heightLevel + "	1	23	240	150	Lava Dragon");
                    NPCSpawning.spawnNpc(player, 6593, player.absX, player.absY, 0, 1, 0, false, false);
                    break;

                case "W":
                    bw.write("spawn =	955	" + player.absX + "	" + player.absY + "	" + player.heightLevel + "	1	3	20	20	Kalphite Worker");
                    NPCSpawning.spawnNpc(player, 955, player.absX, player.absY, 0, 1, 0, false, false);
                    break;

                case "G":
                    bw.write("spawn =	959	" + player.absX + "	" + player.absY + "	" + player.heightLevel + "	1	12	110	110	Kalphite Guardian");
                    NPCSpawning.spawnNpc(player, 959, player.absX, player.absY, 0, 1, 0, false, false);
                    break;

            }
            player.sendMessage("@red@You set spawn at: X: " + player.absX + ", Y: " + player.absY);
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
	}

}
