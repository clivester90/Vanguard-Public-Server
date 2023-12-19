package io.runescape.content.itemskeptondeath.modifiers;

import io.runescape.content.items.Degrade;
import io.runescape.content.itemskeptondeath.DeathItemModifier;
import io.runescape.model.Items;
import io.runescape.model.definitions.ItemDef;
import io.runescape.model.entity.player.Player;
import io.runescape.model.items.GameItem;

import java.util.*;

public class DegradableItemDeathItem implements DeathItemModifier {

    private static final Set<Integer> ALL;

    static {
        ALL = new HashSet<>();
        Arrays.stream(Degrade.DegradableItem.values()).forEach(it -> ALL.add(it.getItemId()));
    }

    @Override
    public Set<Integer> getItemIds() {
        return ALL;
    }

    @Override
    public void modify(Player player, GameItem gameItem, boolean kept, List<GameItem> keptItems, List<GameItem> lostItems) {
        if (kept)
            return;

        Degrade.DegradableItem degrade = Degrade.DegradableItem.forId(gameItem.getId()).orElse(null);
        if (degrade == null)
            return;

        lostItems.remove(gameItem);
        Degrade.reset(player, degrade);

        if (degrade.getBrokenId() > 0 && ItemDef.forId(degrade.getBrokenId()).isTradable()) {
            lostItems.add(new GameItem(degrade.getBrokenId()));
        } else if (degrade.getCost() > 0) {
            lostItems.add(new GameItem(Items.COINS, degrade.getCost()));
        }
    }
}
