package io.runescape.model.definitions.editor;

import com.google.common.base.Preconditions;
import io.runescape.model.definitions.ItemDef;
import io.runescape.util.JsonUtil;
import io.runescape.util.Misc;

import java.util.*;
import java.util.stream.Collectors;

public class ItemDefEditor {
    public static void main(String[] args) throws Exception {
        ItemDef.load();
        Map<Integer, ItemDef> defs = ItemDef.getDefinitions();

        // Edits
        lowerPrices(defs);

        JsonUtil.toYaml(defs.values(), "./temp/item_definitions.yaml");
    }

    private static void lowerPrices(Map<Integer, ItemDef> defs) {
        Map<Integer, ItemDef> defsClone = new HashMap<>(defs);
        Preconditions.checkState(defsClone.equals(defs));

        defs.forEach((key, def) -> {
            int id = key;

            if (def.getRawShopValue() > 10_000_000) {
                int value = 10_000_000 + ((def.getRawShopValue() - 10_000_000) / 25);
                ItemDef newDef = ItemDef.builderOf(def).shopValue(value).build();
                defs.put(id, newDef);
            }
        });

        // Make sure items keep their value position relative to each other
        List<ItemDef> before = defsClone.values().stream().filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(i -> -i.getRawShopValue()))
                .collect(Collectors.toList());

        List<ItemDef> after = defs.values().stream().filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(i -> -i.getRawShopValue()))
                .collect(Collectors.toList());

        List<Integer> beforeIds = before.stream().map(ItemDef::getId).collect(Collectors.toList());
        List<Integer> afterIds = after.stream().map(ItemDef::getId).collect(Collectors.toList());
        Preconditions.checkState(beforeIds.equals(afterIds), "Item position by price has changed.");

        // Print and compare
        for (ItemDef itemList : after) {
            if (itemList.getRawShopValue() > 50_000) {
                System.out.println(itemList.getId() + " \t| " + itemList.getName() + " \t| " + Misc.insertCommas(String.valueOf(itemList.getRawShopValue())));
            }
        }
    }
}
