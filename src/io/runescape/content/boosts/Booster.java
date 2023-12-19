package io.runescape.content.boosts;

public interface Booster<T> {

    String getDescription();

    boolean applied(T t);

    BoostType getType();

}
