package io.runescape.new_quest_tab;


import io.runescape.Configuration;
import io.runescape.Server;
import io.runescape.model.entity.player.Boundary;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.PlayerHandler;
import io.runescape.util.Misc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * The general tab inside the quest tab.
 *
 * @author C.T for runerogue
 *
 */

public class GeneralTab {

    public static List<Integer> getLines() {
        return IntStream.range(55225, 55225 + 400).boxed().collect(Collectors.toList());//51901
    }

    public static void loadInformation(Player player) {


        List<Integer> lines = getLines();
        int index = 0;

        player.getPA().sendFrame126("<col=CC8400>General information", 46222);

        player.getPA().sendFrame126("@or1@<img=28> Server:", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>Players Online:@gre@" + PlayerHandler.getPlayerCount(), lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>Wilderness count:</col> @gre@" + (Boundary.entitiesInArea(Boundary.WILDERNESS) + Boundary.entitiesInArea(Boundary.WILDERNESS_UNDERGROUND)), lines.get(index++));
        player.getPA().sendFrame126("<col=CC8400>Pest Control count:</col> @gre@" + Boundary.entitiesInArea(Boundary.PEST_CONTROL_AREA), lines.get(index++));

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String date = sdf.format(new Date());
        player.getPA().sendFrame126("<col=CC8400>Server Time: @gre@"+ date +" GMT", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>Server Run Time: @gre@"+ Misc.cyclesToTime(Server.getTickCount()), lines.get(index++));

        player.getPA().sendFrame126("", lines.get(index++));

        player.getPA().sendFrame126("@or1@<img=23> Quick-Actions:", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>View NPC Drop tables", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>View Collection log", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>View achievements", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>View loot tables", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>View upgrade table", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>View kill log", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>View presets", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>View titles", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>Vote for "+ Configuration.SERVER_NAME, lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>Join the discord", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>Request help", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>Drop notifications", lines.get(index++));

        player.getPA().sendFrame126("<col=CC8400>Advanced perk system", lines.get(index++));

        player.getPA().sendFrame126("", lines.get(index++));

        while (index < lines.size()) {
            player.getPA().sendString("", lines.get(index++));
        }

    }



}
