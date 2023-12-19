package io.runescape.content.skills.slayer;

import io.runescape.Server;
import io.runescape.content.Announcement;
import io.runescape.content.LarranChestNew;
import io.runescape.content.event.eventcalendar.EventChallenge;
import io.runescape.content.hespori.Hespori;
import io.runescape.model.Items;
import io.runescape.model.collisionmap.WorldObject;
import io.runescape.model.definitions.ItemDef;
import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class LarrensKey {

    private static final int LARGE_CHEST_OBJECT = 34_832;
    private static final int SMALL_CHEST_OBJECT = 34_831;

//if (amount >=  0 && amount <= 0) {
    public static void roll(Player player, NPC npc) {
        int rewardAmount = 1;
        if (Hespori.activeKeldaSeed) {
            rewardAmount = 2;
        }
         if (Misc.hasOneOutOf(100) && npc.getDefinition().getCombatLevel() >= 10 && npc.getDefinition().getCombatLevel() <= 50) {
            player.getEventCalendar().progress(EventChallenge.OBTAIN_X_LARRENS_KEYS, 1);
            Server.itemHandler.createGroundItem(player, Items.LARRANS_KEY, npc.getX(), npc.getY(), npc.getHeight(), rewardAmount);
            player.sendMessage("@pur@You notice an" + ItemDef.forId(Items.LARRANS_KEY).getName() + " on the ground.");
            Announcement.announce("@cr21@ @pur@" + player.getLoginName() + " received a drop: Larren's key from wilderness slayer.");
            return;
        }

        if (Misc.hasOneOutOf(60) && npc.getDefinition().getCombatLevel() >= 50 && npc.getDefinition().getCombatLevel() <= 85) {
            player.getEventCalendar().progress(EventChallenge.OBTAIN_X_LARRENS_KEYS, 1);
            Server.itemHandler.createGroundItem(player, Items.LARRANS_KEY, npc.getX(), npc.getY(), npc.getHeight(), rewardAmount);
            player.sendMessage("@pur@You notice an" + ItemDef.forId(Items.LARRANS_KEY).getName() + " on the ground.");
            Announcement.announce("@cr21@ @pur@" + player.getLoginName() + " received a drop: Larren's key from wilderness slayer.");
            return;
        }

        if (Misc.hasOneOutOf(25) && npc.getDefinition().getCombatLevel() >= 85 && npc.getDefinition().getCombatLevel() <= 800) {
            player.getEventCalendar().progress(EventChallenge.OBTAIN_X_LARRENS_KEYS, 1);
            Server.itemHandler.createGroundItem(player, Items.LARRANS_KEY, npc.getX(), npc.getY(), npc.getHeight(), rewardAmount);
            player.sendMessage("@pur@You notice an" + ItemDef.forId(Items.LARRANS_KEY).getName() + " on the ground.");
            Announcement.announce("@cr21@ @pur@" + player.getLoginName() + " received a drop: Larren's key from wilderness slayer.");
            return;
        }
    }

    public static boolean clickObject(Player player, WorldObject object) {
        if (object.getId() == LARGE_CHEST_OBJECT) {
           // new LarransChest().roll(player);
            LarranChestNew.searchChest(player);
            return true;
        } else if (object.getId() == SMALL_CHEST_OBJECT) {
            player.sendMessage("Larran's small chest wasn't added, if you feel it should be suggest it on ::discord!");
            return true;
        }

        return false;
    }
}
