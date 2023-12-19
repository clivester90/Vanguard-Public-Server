package io.runescape.content.combat.effects.special.impl;

import io.runescape.Server;
import io.runescape.content.combat.effects.special.SpecialEffect;
import io.runescape.model.Direction;
import io.runescape.model.Graphic;
import io.runescape.model.Items;
import io.runescape.model.StillGraphic;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.Position;

/**
 * @author Arthur Behesnilian 9:11 PM
 */
public class ScytheOfVitur implements SpecialEffect {

    public static ScytheOfVitur SCYTHE_EFFECT = new ScytheOfVitur();

    public static boolean usingScythe(Player player) {
        return player.getItems().isWearingItem(Items.SCYTHE_OF_VITUR, Player.playerWeapon) || player.getItems().isWearingItem(25736, Player.playerWeapon);
    }

    @Override
    public boolean activateSpecialEffect(Player player, Object... args) {
        boolean usingScythe = player.getItems().isWearingItem(Items.SCYTHE_OF_VITUR, Player.playerWeapon) || player.getItems().isWearingItem(25736, Player.playerWeapon);

        Entity defender = (Entity) args[0];

        if (usingScythe) {
            Position defenderAdjacentPosition = defender.getAdjacentBorderPosition(player.getPosition());
            Position directional = player.getPosition().toDirectional(defenderAdjacentPosition);
            Direction direction = Direction.fromDirectional(directional);
            Position position = player.getPosition().translate(direction);
            int gfx = direction == Direction.NORTH ? 506
                    : direction == Direction.EAST ? 1172
                    : direction == Direction.SOUTH ? 478
                    : 1231;

            Server.playerHandler.sendStillGfx(new StillGraphic(gfx, Graphic.GraphicHeight.HIGH, position), player.getInstance());
        }

        return usingScythe;
    }

}
