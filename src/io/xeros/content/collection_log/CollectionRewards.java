package io.xeros.content.collection_log;

import io.xeros.Server;
import io.xeros.content.bosses.Vorkath;
import io.xeros.content.item.lootable.impl.RaidsChestRare;
import io.xeros.content.item.lootable.impl.TheatreOfBloodChest;
import io.xeros.content.trails.TreasureTrailsRewardItem;
import io.xeros.content.trails.TreasureTrailsRewards;
import io.xeros.model.Npcs;
import io.xeros.model.entity.npc.pets.PetHandler;
import io.xeros.model.entity.player.Player;
import io.xeros.model.items.GameItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CollectionRewards {


    /* Bosses */

    BARREL_CHEST(6342, new GameItem[]{new GameItem(6199,2),
            new GameItem(2699,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    DAG_SUPREME(2265,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,1), new GameItem(2699,1),
            new GameItem(-1,1)}),

    DAG_PRIME(2266,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,1), new GameItem(2699,1),
            new GameItem(-1,1)}),

    DAG_REX(2267,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,1), new GameItem(2699,1),
            new GameItem(-1,1)}),

    KBD(239,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,2), new GameItem(2699,2),
            new GameItem(-1,1)}),

    KALPHITE_QUEEN(965,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,2), new GameItem(2699,2),
            new GameItem(-1,1)}),

    GENERAL_GRAARDOR(2215,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,2), new GameItem(995,20000000),
            new GameItem(-1,1)}),

    KRIL_TSUTSAROTH(3129,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,2), new GameItem(995,20000000),
            new GameItem(-1,1)}),

    KREE_ARRA(3162,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,2), new GameItem(995,20000000),
            new GameItem(-1,1)}),

    COMMANDER_ZILYANA(2205,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,2), new GameItem(995,20000000),
            new GameItem(-1,1)}),

    CORPOREAL_BEAST(319,new GameItem[]{new GameItem(786,1),
            new GameItem(6828,2), new GameItem(995,100000000),
            new GameItem(-1,1)}),

    KRAKEN(494,new GameItem[]{new GameItem(23071,10),
            new GameItem(6828,2), new GameItem(2697,1),
            new GameItem(-1,1)}),

    CERBERUS(5862,new GameItem[]{new GameItem(23071,10),
            new GameItem(6828,2), new GameItem(2697,1),
            new GameItem(-1,1)}),

    ABYSSAL_SIRE(5890,new GameItem[]{new GameItem(23071,10),
            new GameItem(6828,2), new GameItem(2697,1),
            new GameItem(-1,1)}),

    DEMONIC_GORILLA(7144,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,2), new GameItem(2697,1),
            new GameItem(-1,1)}),

    LIZARDMAN_SHAMAN(6766,new GameItem[]{new GameItem(23071,5),
            new GameItem(6199,2), new GameItem(2698,1),
            new GameItem(-1,1)}),

    VORKATH(8026,new GameItem[]{new GameItem(23071,5),
            new GameItem(6199,2), new GameItem(2697,1),
            new GameItem(-1,1)}),

    ZULRAH(2042,new GameItem[]{new GameItem(23071,25),
            new GameItem(6199,5), new GameItem(2698,1),
            new GameItem(-1,1)}),

    HYDRA(8026,new GameItem[]{new GameItem(786,1),
            new GameItem(-1,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    NIGHTMARE(9425,new GameItem[]{new GameItem(786,2),
            new GameItem(-1,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    SARACHNIS(8713,new GameItem[]{new GameItem(23071,10),
            new GameItem(6199,2), new GameItem(-1,1),
            new GameItem(-1,1)}),

    GROTESQUE_GUARDIANS(7851,new GameItem[]{new GameItem(23071,15),
            new GameItem(6199,2), new GameItem(-1,1),
            new GameItem(-1,1)}),

    BRYOPHYTA(8195,new GameItem[]{new GameItem(23071,25),
            new GameItem(6199,2), new GameItem(-1,1),
            new GameItem(-1,1)}),

    OBOR(7416,new GameItem[]{new GameItem(23071,25),
            new GameItem(6199,2), new GameItem(-1,1),
            new GameItem(-1,1)}),

    NEX(11278,new GameItem[]{new GameItem(6829,1),
            new GameItem(786,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    VETION(6611,new GameItem[]{new GameItem(23071,10),
            new GameItem(2697,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    CALLISTO(6503,new GameItem[]{new GameItem(23071,10),
            new GameItem(2697,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    VENENATIS(6504,new GameItem[]{new GameItem(23071,10),
            new GameItem(2697,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    SCORPIA(6615,new GameItem[]{new GameItem(23071,10),
            new GameItem(2697,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    CHAOS_ELEMENTAL(2054,new GameItem[]{new GameItem(23071,10),
            new GameItem(2697,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    CHAOS_FANATIC(6619,new GameItem[]{new GameItem(23071,10),
            new GameItem(2697,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    CRAZY_ARCHAEOLOGIST(6618,new GameItem[]{new GameItem(23071,10),
            new GameItem(2697,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    GREAT_OLM(7554,new GameItem[]{new GameItem(6829,2),
            new GameItem(761,2), new GameItem(-1,1),
            new GameItem(-1,1)}),

    THEATRE_OF_BLOOD(Npcs.THE_MAIDEN_OF_SUGADINTI, new GameItem[]{new GameItem(6829,1),
            new GameItem(786,2), new GameItem(-1,1),
            new GameItem(-1,1)}),

    BARROWS(555,new GameItem[]{new GameItem(995,25000000),
            new GameItem(2699,1), new GameItem(-1,1),
            new GameItem(-1,1)}),

    ;


    public int NpcID;
    public GameItem[] Rewards;

    CollectionRewards(int NpcID, GameItem[] Rewards) {
        this.NpcID = NpcID;
        this.Rewards = Rewards;
    }

    public static ArrayList<GameItem> getForNpcID(int npcID) {
        ArrayList<GameItem> collectionRewards = new ArrayList<>();
        for (CollectionRewards value : CollectionRewards.values()) {
            if (value.NpcID == npcID) {
                collectionRewards.addAll(Arrays.asList(value.Rewards));
            }
        }
        return collectionRewards;
    }

    public static boolean handleButton(Player player, int ID) {
        if (ID == 23236) {
            if (player.getCollectionLog().getCollections().containsKey(player.getCollectionLogNPC()+ "")) {
                ArrayList<GameItem> itemsObtained = player.getCollectionLog().getCollections().get(player.getCollectionLogNPC()+ "");
                if (itemsObtained != null) {
                    List<GameItem> drops = Server.getDropManager().getNPCdrops(player.getCollectionLogNPC());
                    if (player.getCollectionLogNPC() == 8028) {
                        drops = Vorkath.getVeryRareDrops();
                    }
                    if (player.getCollectionLogNPC() == 7554) {
                        drops = RaidsChestRare.getRareDrops();
                    } else if (player.getCollectionLogNPC() >= 1 && player.getCollectionLogNPC() <= 4) {
                        drops = TreasureTrailsRewardItem.toGameItems(TreasureTrailsRewards.getRewardsForType(player.getCollectionLogNPC()));
                    } else if (player.getCollectionLogNPC() == 5) {
                        drops = PetHandler.getPetIds(true);
                    } else if (player.getCollectionLogNPC() == Npcs.THE_MAIDEN_OF_SUGADINTI) {
                        drops = TheatreOfBloodChest.getRareDrops();
                    }
                    if (drops != null &&
                            drops.size() == itemsObtained.size()
                            && !player.getClaimedLog().contains(player.getCollectionLogNPC())) {
                        player.getClaimedLog().add(player.getCollectionLogNPC());

                        for (GameItem gameItem : CollectionRewards.getForNpcID(player.getCollectionLogNPC())) {
                            player.getItems().addItemUnderAnyCircumstance(gameItem.getId(), gameItem.getAmount());
                        }
                        player.sendMessage("@gre@Your rewards have now been claimed!");

                    } else if (drops != null && drops.size() == itemsObtained.size()
                            && player.getClaimedLog().contains(player.getCollectionLogNPC())) {
                        player.sendMessage("@red@You've already claimed the reward from this log!");
                    } else if (drops != null &&
                            drops.size() != itemsObtained.size()) {
                        player.sendMessage("@red@You have not completed the log yet!");
                    }
                }
            }
            return true;
        }


        return false;
    }
}

