package io.runescape.content.combat.specials.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.specials.Special;
import io.runescape.model.Items;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;

public class GraniteHammerSpecialAttack extends Special {

    public GraniteHammerSpecialAttack() {
        super(6.0, 1.5, 1.0, new int[] {Items.GRANITE_HAMMER});
    }

    @Override
    public void activate(Player player, Entity target, Damage damage) {
        player.gfx0(1450);
        player.startAnimation(1378);
    }

    @Override
    public void hit(Player player, Entity target, Damage damage) {
        damage.setAmount(damage.getAmount() + 5);
    }

}
