package io.runescape.content.minigames.raids;

import com.google.common.collect.Lists;
import io.runescape.ServerState;
import io.runescape.test.ServerTest;
import io.runescape.test.TestPlayer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.runescape.content.minigames.raids.Raids.*;
import static org.junit.jupiter.api.Assertions.*;

class RaidsTest {

    private static final ServerTest serverTest = new ServerTest(ServerState.PUBLIC);

    @Test
    public void testScaling() {
        for (int i = 0; i < 100; i++) {
            int[] stats = getScaledStats(OLM_HP, OLM_ATTACK, OLM_DEFENCE, i);
            System.out.printf("Olm stats, groupSize=%d, HP=%d, attack=%d, defence=%d%n", i, stats[2], stats[0], stats[1]);
        }
    }

    @Test
    public void testRanking() {
        List<RaidsRank> players = Lists.newArrayList();
        for (int i = 1; i <= 100; i++) {
            players.add(new RaidsRank(TestPlayer.named(String.valueOf(i)), 100 - i));
        }

        List<RaidsRank> ranks = buildRankList(players);
        ranks.forEach(it -> assertEquals(Integer.parseInt(it.getPlayer().getLoginName()), it.getRank()));
        System.out.println(ranks);
    }

}