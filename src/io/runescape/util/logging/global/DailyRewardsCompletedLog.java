package io.runescape.util.logging.global;

import java.util.Set;

import io.runescape.content.dailyrewards.DailyRewardContainer;
import io.runescape.util.logging.GlobalLog;

public class DailyRewardsCompletedLog extends GlobalLog {

    private final String username;

    public DailyRewardsCompletedLog(String username) {
        this.username = username;
    }

    @Override
    public String getLoggedMessage() {
        return username + " completed daily rewards for " + DailyRewardContainer.get().getStartDate();
    }

    @Override
    public Set<String> getFileNames() {
        return Set.of("completed_daily_rewards");
    }
}
