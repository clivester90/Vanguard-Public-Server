package io.xeros.content.hs;

import io.xeros.model.entity.player.Player;
import io.xeros.model.entity.player.PlayerHandler;
import io.xeros.util.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * Created by C.T for runerogue
 *
 */
public class WogwHighscore implements Highscore {

    private String type = "";
    private ArrayList<Player> playerList = new ArrayList<>(10);

    @Override
    public void process() {
        playerList = (ArrayList<Player>) Arrays.stream(PlayerHandler.players).filter(p -> p != null).collect(Collectors.toList());
        playerList.sort((player1, player2) -> Integer.compare(player2.donationWell, player1.donationWell));
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void generateList(Player client) {
        resetList(client);
        if (playerList.size() > 10) {
            for (int i = 0; i < 10; i++) {
        	Player rankedClient = (Player) playerList.get(i);
        	client.getPA().sendFrame126("10m X:", 56509);
        	client.getPA().sendFrame126("Seeds:", 56510);
        	client.getPA().sendFrame126("N/A:", 56511);
        	client.getPA().sendFrame126("Cmb level:", 56512);
        	client.getPA().sendFrame126((i + 1) + "): @gre@" + Misc.optimizeText(rankedClient.getLoginName()), 56513 + i);
        	client.getPA().sendFrame126(String.valueOf(rankedClient.donationWell), 56523 + i);
        	client.getPA().sendFrame126(String.valueOf(rankedClient.donationSeed), 56533 + i);
        	//client.getPA().sendFrame126(String.valueOf(rankedClient.lotteryMbox), 56543 + i);
        	client.getPA().sendFrame126(String.valueOf(rankedClient.combatLevel), 56553 + i);
            }
        } else {
        	 for (int i = 0; i < playerList.size(); i++) {
                 Player rankedClient = (Player) playerList.get(i);
                 client.getPA().sendFrame126("10m X:", 56509);
                 client.getPA().sendFrame126("Seeds:", 56510);
                 client.getPA().sendFrame126("N/A:", 56511);
                 client.getPA().sendFrame126("Cmb level:", 56512);
                 client.getPA().sendFrame126((i + 1) + "): @gre@" + Misc.optimizeText(rankedClient.getLoginName()), 56513 + i);
                 client.getPA().sendFrame126(String.valueOf(rankedClient.donationWell), 56523 + i);
                 client.getPA().sendFrame126(String.valueOf(rankedClient.donationSeed), 56533 + i);
             //    client.getPA().sendFrame126(String.valueOf(rankedClient.lotteryMbox), 56543 + i);
                 client.getPA().sendFrame126(String.valueOf(rankedClient.combatLevel), 56553 + i);
        	 }
        }
        client.getPA().showInterface(56500);
        client.flushOutStream();
        playerList.clear();
    }

    @Override
    public void resetList(Player client) {
        client.getPA().sendFrame126("Live Wogw Hiscores" + getType(), 56502);
        for (int i = 56513; i < 56563; i++) {
            client.getPA().sendFrame126("", i);
            client.flushOutStream();
        }
    }
}
