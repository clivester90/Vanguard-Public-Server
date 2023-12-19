package io.runescape.content.instances.impl;

import io.runescape.content.instances.InstanceConfiguration;
import io.runescape.content.instances.InstancedArea;
import io.runescape.model.entity.player.Boundary;
import io.runescape.model.entity.player.Player;

/**
 * Exists because the old instances have a Player object and cba to rewrite all that shit.
 * Don't use this!
 */
public class LegacySoloPlayerInstance extends InstancedArea {

    protected Player player;

    public LegacySoloPlayerInstance(Player player, Boundary... boundaries) {
        super(InstanceConfiguration.CLOSE_ON_EMPTY, boundaries);
        this.player = player;
    }

    public LegacySoloPlayerInstance(InstanceConfiguration configuration, Player player, Boundary... boundaries) {
        super(configuration, boundaries);
        this.player = player;
    }

    @Override
    public void onDispose() { }
}
