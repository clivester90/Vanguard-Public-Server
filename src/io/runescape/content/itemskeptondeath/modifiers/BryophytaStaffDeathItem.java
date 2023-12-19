package io.runescape.content.itemskeptondeath.modifiers;

import io.runescape.content.itemskeptondeath.DeathItemModifier;
import io.runescape.content.skills.crafting.BryophytaStaff;
import io.runescape.model.entity.player.Player;
import io.runescape.model.items.GameItem;

import java.util.List;
import java.util.Set;

public class BryophytaStaffDeathItem implements DeathItemModifier {
    @Override
    public Set<Integer> getItemIds() {
        return Set.of(BryophytaStaff.CHARGED_STAFF);
    }

    @Override
    public void modify(Player player, GameItem gameItem, boolean kept, List<GameItem> keptItems, List<GameItem> lostItems) {
        if (kept)
            return;
        lostItems.remove(gameItem);
        lostItems.add(new GameItem(BryophytaStaff.UNCHARGED_STAFF));
        player.bryophytaStaffCharges = 0;
    }
}
