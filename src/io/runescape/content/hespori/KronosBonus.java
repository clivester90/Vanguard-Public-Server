package io.runescape.content.hespori;

import java.util.concurrent.TimeUnit;

import io.runescape.content.QuestTab;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.PlayerHandler;

public class KronosBonus implements HesporiBonus {
    @Override
    public void activate(Player player) {
        Hespori.activeKronosSeed = true;
        Hespori.KRONOS_TIMER += TimeUnit.HOURS.toMillis(1) / 600;
        PlayerHandler.executeGlobalMessage("@red@" + player.getDisplayNameFormatted() + " @bla@donated a Kronos seed which" +
                " granted @red@1 hour of double Raids 1 keys");
        PlayerHandler.executeGlobalMessage("@red@and doubled chances at ToB!");
        QuestTab.updateAllQuestTabs();
    }


    @Override
    public void deactivate() {
        updateObject(false);
        Hespori.activeKronosSeed = false;
        Hespori.KRONOS_TIMER = 0;

    }

    @Override
    public boolean canPlant(Player player) {

        return true;
    }

    @Override
    public HesporiBonusPlant getPlant() {
        return HesporiBonusPlant.KRONOS;
    }
}
