package io.runescape.content.commands.owner;

import io.runescape.Server;
import io.runescape.content.commands.Command;
import io.runescape.model.cycleevent.CycleEventContainer;
import io.runescape.model.cycleevent.CycleEventHandler;
import io.runescape.model.entity.player.Player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EventLog extends Command {
    @Override
    public void execute(Player player, String commandName, String input) {
        player.sendMessage("Writing event log..");
        Server.getIoExecutorService().submit(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("./logs/event-log.txt"))) {
                List<CycleEventContainer> events = CycleEventHandler.getSingleton().getEvents();
                writer.write("Events: " + events.size());
                writer.newLine();

                for (CycleEventContainer event : events) {
                    writer.write(event.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
