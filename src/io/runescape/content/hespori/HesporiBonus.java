package io.runescape.content.hespori;

import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.Position;


public interface HesporiBonus {

    void activate(Player player);

    void deactivate();

    boolean canPlant(Player player);

    HesporiBonusPlant getPlant();

    Position OBJECT_POSITION = new Position(3121, 3481);

    default void updateObject(boolean adding) {
        //GlobalObject grass = new GlobalObject(HESPORI_PLANTER_OBJECT, OBJECT_POSITION, 0, 10);
       // GlobalObject object = new GlobalObject(getPlant().getObjectId(), OBJECT_POSITION, 0, 10);
        if (adding) {
            //Server.getGlobalObjects().remove(grass);
            //Server.getGlobalObjects().add(object);
        } else {
            //Server.getGlobalObjects().remove(object);
            //Server.getGlobalObjects().add(grass);
        }
    }

}