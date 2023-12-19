package io.runescape.content.hespori;

import java.util.concurrent.TimeUnit;

import io.runescape.content.QuestTab;
import io.runescape.content.bonus.DoubleExperience;
import io.runescape.content.wogw.Wogw;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.PlayerHandler;

public class AttasBonus implements HesporiBonus {
    @Override
    public void activate(Player player) {
        Wogw.EXPERIENCE_TIMER += TimeUnit.HOURS.toMillis(1) / 600;
        //PlayerHandler.executeGlobalMessage("The Attas has sprouted and is granting 1 hours bonus xp!");
        PlayerHandler.executeGlobalMessage("@red@" + player.getDisplayNameFormatted() + " @bla@donated an attas seed which" +
                " granted @red@1 hour of 50% Bonus experience.");
        QuestTab.updateAllQuestTabs();
    }

    @Override
    public void deactivate() {
        Hespori.activeAttasSeed = false;
        Hespori.ATTAS_TIMER = 0;
        updateObject(false);
    }

    @Override
    public boolean canPlant(Player player) {
        if (DoubleExperience.isDoubleExperience()) {
            player.sendMessage("This seed can't be planted during bonus experience.");
            return false;
        }
        return true;
    }

    @Override
    public HesporiBonusPlant getPlant() {
        return HesporiBonusPlant.ATTAS;
    }
}
