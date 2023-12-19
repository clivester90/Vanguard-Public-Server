package io.runescape.content.pkertab;


import io.runescape.model.cycleevent.CycleEvent;
import io.runescape.model.cycleevent.CycleEventContainer;
import io.runescape.model.cycleevent.CycleEventHandler;

/**
 *
 * Top list Execution
 *
 *
 * @author C.T for runerogue
 */

public class ToplistExecution {

    public static void execute() {
        Object object = new Object();
        CycleEventHandler.getSingleton().addEvent(object, new CycleEvent() {
            @Override
            public void execute(CycleEventContainer container) {
                System.out.println("Executed top list update...");
                Toplist.updateToplist();
            }

            @Override
            public void onStopped() {
            }
        }, 60);
    }
}
