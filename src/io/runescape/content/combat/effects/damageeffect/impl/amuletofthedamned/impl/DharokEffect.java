package io.runescape.content.combat.effects.damageeffect.impl.amuletofthedamned.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.Hitmark;
import io.runescape.content.combat.effects.damageeffect.impl.amuletofthedamned.AmuletOfTheDamnedEffect;
import io.runescape.content.items.Degrade;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;
import io.runescape.model.items.EquipmentSet;
import io.runescape.util.Misc;

/**
 * @author Arthur Behesnilian 12:42 PM
 */
public class DharokEffect implements AmuletOfTheDamnedEffect {

    /**
     * The singleton instance of the Amulet of the damned effect for Dharok
     */
    public static final AmuletOfTheDamnedEffect INSTANCE = new DharokEffect();

    @Override
    public boolean hasExtraRequirement(Player player) {
        return EquipmentSet.DHAROK.isWearingBarrows(player)
                && Misc.isLucky(25);
    }

    @Override
    public void useEffect(Player player, Entity other, Damage damage) {
        double damageAmount = (double) damage.getAmount();
        int damageToDeal = (int) Math.floor(damageAmount * 0.15);
        if (damageToDeal < 1) {
            return;
        }

        other.appendDamage(player, damageToDeal, Hitmark.HIT);
        Degrade.degrade(player, Degrade.DegradableItem.AMULETS_OF_THE_DAMNED);
    }
}
