package io.runescape.content.achievement;

import io.runescape.ServerState;
import io.runescape.model.entity.player.Player;
import io.runescape.test.ServerTest;
import io.runescape.test.TestPlayer;
import io.runescape.util.Misc;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AchievementsTest {

    private final ServerTest serverTest = new ServerTest(ServerState.PUBLIC);

    @Test
    void increase_completes_achievements() {
        List<Player> players = TestPlayer.gen("Test%d", 5_000);
        players.forEach(plr -> Arrays.stream(Achievements.Achievement.values()).forEach(it -> {
            int amount = it.getAmount();
            if (amount < 5_000) {
                while (plr.getAchievements().getAmountRemaining(it) < amount)
                    Achievements.increase(plr, it.getType(), Misc.random(1, 5));
            } else
                Achievements.increase(plr, it.getType(), amount);
            assertTrue(plr.getAchievements().isComplete(it), plr.getDisplayName() + " didn't complete achievement " + it);
        }));

    }

}