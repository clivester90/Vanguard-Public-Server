package io.runescape.content;

import io.runescape.content.item.lootable.LootRarity;
import io.runescape.content.item.lootable.Lootable;
import io.runescape.model.entity.player.Player;
import io.runescape.model.items.GameItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeaSnakeItems implements Lootable {

        private static final Map<LootRarity, List<GameItem>> items = new HashMap<>();

    static {

        items.put(LootRarity.COMMON, Arrays.asList(
                new GameItem(560, 1),
                new GameItem(565, 1),
                new GameItem(566, 1),
                new GameItem(892, 1),
                new GameItem(208, 1),
                new GameItem(3052, 1),
                new GameItem(5300, 1),
                new GameItem(220, 1),
                new GameItem(11937, 1),
                new GameItem(3050, 1),
                new GameItem(5296, 1),
                new GameItem(13442, 1),
                new GameItem(11935, 1)));

        items.put(LootRarity.UNCOMMON, Arrays.asList(
                new GameItem(13440, 1),
                new GameItem(1616, 1),
                new GameItem(824, 1),
                new GameItem(11232, 1),
                new GameItem(1516, 1),
                new GameItem(1514, 1),
                new GameItem(2362, 1),
                new GameItem(3025, 1),
                new GameItem(19484, 1),
                new GameItem(2364, 1),
                new GameItem(20849, 1),
                new GameItem(11212, 1),
                new GameItem(452, 1),
                new GameItem(2722, 1),
                new GameItem(11230, 1)));


        items.put(LootRarity.RARE, Arrays.asList(
                new GameItem(2425, 1)));
    }



        @Override
        public Map<LootRarity, List<GameItem>> getLoot() {
            return items;
        }

        @Override
        public void roll(Player c) {

        }

}
