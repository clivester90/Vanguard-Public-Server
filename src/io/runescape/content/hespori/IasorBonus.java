package io.runescape.content.hespori;

import java.util.concurrent.TimeUnit;

import io.runescape.content.QuestTab;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.PlayerHandler;

public class IasorBonus implements HesporiBonus {
    @Override
    public void activate(Player player) {
        Hespori.IASOR_TIMER += TimeUnit.HOURS.toMillis(1) / 600;

        PlayerHandler.executeGlobalMessage("@blu@" + player.getDisplayNameFormatted() + " @bla@donated an Iasor seed and it is granting @red@1 hr of +10 drop rate boost!");
        QuestTab.updateAllQuestTabs();
    }

    @Override
    public void deactivate() {
        updateObject(false);
        Hespori.activeIasorSeed = false;
        Hespori.IASOR_TIMER = 0;
    }

    @Override
    public boolean canPlant(Player player) {
        return true;
    }

    @Override
    public HesporiBonusPlant getPlant() {
        return HesporiBonusPlant.IASOR;
    }
}
