package io.runescape.sql.eventcalendar.queries;

import java.sql.Connection;
import java.sql.SQLException;

import io.runescape.content.event.eventcalendar.ChallengeParticipant;
import io.runescape.sql.DatabaseManager;
import io.runescape.sql.DatabaseTable;
import io.runescape.sql.SqlQuery;
import io.runescape.sql.eventcalendar.tables.EventCalendarBlacklistTable;

public class RemoveFromBlacklistQuery implements SqlQuery<Boolean> {

    private static final DatabaseTable TABLE = new EventCalendarBlacklistTable();

    private final ChallengeParticipant participant;

    public RemoveFromBlacklistQuery(ChallengeParticipant participant) {
        this.participant = participant;
    }

    @Override
    public Boolean execute(DatabaseManager context, Connection connection) throws SQLException {
        connection.createStatement().execute("delete from " + TABLE.getName() + " where "
                + EventCalendarBlacklistTable.MAC_ADDRESS + "='" + participant.getMacAddress() + "' and " +
                EventCalendarBlacklistTable.IP_ADDRESS + "='" + participant.getIpAddress() + "'");
        return true;
    }

}
