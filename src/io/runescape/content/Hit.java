package io.runescape.content;

import io.runescape.content.combat.Hitmark;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hit {

    private Hitmark type;
    private int damage, delay;
    private boolean ignoresPrayer;

    public Hit(Hitmark type, int damage, int delay) {
        this(type, damage, delay, false);
    }

    public Hit(Hitmark type, int damage, int delay, boolean ignoresPrayer) {
        this.type = type;
        this.damage = damage;
        this.delay = delay;
        this.ignoresPrayer = ignoresPrayer;
    }

}
