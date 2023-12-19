package io.runescape.content.item.lootable;

import java.util.List;
import java.util.Map;

import io.runescape.model.entity.player.Player;
import io.runescape.model.items.GameItem;

public interface Lootable {

    Map<LootRarity, List<GameItem>> getLoot();

    void roll(Player player);

}
