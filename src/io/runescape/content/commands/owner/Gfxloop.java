package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.cycleevent.CycleEvent;
import io.runescape.model.cycleevent.CycleEventContainer;
import io.runescape.model.cycleevent.CycleEventHandler;
import io.runescape.model.entity.player.Player;

public class Gfxloop extends Command {

    @Override
    public void execute(Player c, String commandName, String input) {
        String[] args = input.split(" ");

        if (Integer.parseInt(args[0]) > 3000) {
            c.sendMessage("Max graphic id is: 3000");
            return;
        }

        if (args.length >= 2) {
            final int id = Integer.parseInt(args[0]);
            boolean plus = args[1].equals("+");
            CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
                int idLoop = id;
                @Override
                public void execute(CycleEventContainer container) {
                    c.gfx0(idLoop);
                    c.sendMessage("Performing graphic: " + idLoop);
                    c.gfxCommandId = idLoop;
                    if (plus) {
                        idLoop++;
                    } else {
                        idLoop--;
                    }
                }
            }, 6);

        } else {
            c.sendMessage("Incorrect.");
        }
    }
}