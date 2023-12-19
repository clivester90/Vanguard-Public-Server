package io.runescape.content;

import com.google.common.collect.Lists;
import io.runescape.content.bosses.kratos.KratosNpc;
import io.runescape.model.entity.player.Boundary;
import io.runescape.model.entity.player.PlayerHandler;

import java.util.List;


/**
 * Kratos.
 *
 * @author C.T for RuneRogue
 *
 */

public class Kratos {

    private static int KRATOS_KEY = 7302;


    public static void rewardPlayers() {
        KratosNpc.spawned = false;
        List<String> givenToIP = Lists.newArrayList();
        PlayerHandler.nonNullStream().filter(p -> Boundary.isIn(p, Boundary.KRATOS_AREA))
                .forEach(p -> {
                    if (!givenToIP.contains(p.connectedFrom)) {
                            p.sendMessage("@blu@You receive an @red@Kratos Key@blu@ for defeating @red@Kratos.");
                            Announcement.announce("@red@"+p.getLoginName()+"@blu@ has just received the @red@Kratos Key @blu@for defeating @red@Kratos.");
                            p.getItems().addItemUnderAnyCircumstance(KRATOS_KEY, 1);
                            givenToIP.add(p.connectedFrom);
                            p.getPA().movePlayer(3074, 3515, 0);//Sends the player back to home so can only fight the boss once.

                        } else {
                            p.sendMessage("You can only receive 1 drop per @red@ IP ADDRESS!");
                        }
                });
       }






}
