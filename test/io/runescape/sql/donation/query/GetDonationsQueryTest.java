package io.runescape.sql.donation.query;

import io.runescape.*;
import io.runescape.model.entity.player.Player;
import io.runescape.sql.SqlQuery;
import io.runescape.sql.donation.model.DonationItem;
import io.runescape.sql.donation.model.DonationItemList;
import io.runescape.test.ServerTest;
import io.runescape.test.TestPlayer;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.Statement;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GetDonationsQueryTest {

    private static final ServerTest serverTest = new ServerTest(ServerState.PUBLIC);
    private static final Player player = TestPlayer.builder().username("Will").build().player();

    private static <T> T exec(SqlQuery<T> query) throws Exception {
        return Server.getDatabaseManager().executeImmediate(serverTest.getConfiguration().getStoreDatabase(), query);
    }

    @Test
    @Order(1)
    void test_get() throws Exception {
        DonationItemList donationItems = exec(new GetDonationsQuery(player.getLoginName()));
        assertTrue(donationItems.size() > 0);
        assertTrue(donationItems.stream().allMatch(DonationItem::isClaimed));
    }

    @Test
    @Order(2)
    void test_claim() throws Exception {
        try {
            DonationItemList donationItems = exec(new GetDonationsQuery(player.getLoginName()));
            assertThrows(IllegalStateException.class, () -> exec(new ClaimDonationsQuery(player, donationItems)));

            int updated = exec((context, connection) -> {
                Statement statement = connection.createStatement();
                return statement.executeUpdate("update orders set claimed_at = NULL where player_name = '" + player.getLoginName().toLowerCase() + "';");
            });
            assertTrue(updated > 0);

            DonationItemList unclaimed = exec(new GetDonationsQuery(player.getLoginName()));
            assertTrue(unclaimed.stream().allMatch(it -> !it.isClaimed()));

            int[] updates = exec(new ClaimDonationsQuery(player, unclaimed));
            assertTrue(Arrays.stream(updates).allMatch(it -> it > 0));

            DonationItemList claimed = exec(new GetDonationsQuery(player.getLoginName()));
            assertTrue(claimed.stream().allMatch(DonationItem::isClaimed));
        } finally {
            // Make sure we set all to claimed again
            exec((context, connection) -> {
                Statement statement = connection.createStatement();
                return statement.executeUpdate("update orders set claimed_at = NOW() where player_name = '" + player.getLoginName().toLowerCase() + "';");
            });
        }
    }
}