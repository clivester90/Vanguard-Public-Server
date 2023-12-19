package io.runescape.content.questing.MonkeyMadness;

import io.runescape.content.instances.InstanceConfiguration;
import io.runescape.content.instances.impl.LegacySoloPlayerInstance;
import io.runescape.model.cycleevent.CycleEvent;
import io.runescape.model.cycleevent.CycleEventContainer;
import io.runescape.model.cycleevent.CycleEventHandler;
import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.player.Boundary;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.Position;

public class MMDemonInstance extends LegacySoloPlayerInstance {

    private static final int PLAYER_START_X = 2664, PLAYER_START_Y = 4583;
    private static final int DEMON_SPAWN_X = 2662, DEMON_SPAWN_Y = 4577;
    private static final int HEIGHT_LEVEL = 1;

    private final Player player;

    private final boolean questInstance;

    public MMDemonInstance(Player player, boolean questInstance) {
        super(InstanceConfiguration.CLOSE_ON_EMPTY_RESPAWN, player, Boundary.MONKEY_MADNESS_DEMON);
        this.player = player;
        this.questInstance = questInstance;
    }

    public void init() {
        player.getPA().closeAllWindows();
        player.getPA().movePlayer(PLAYER_START_X, PLAYER_START_Y, resolveHeight(HEIGHT_LEVEL));
        add(player);
        spawnMMDemon();
    }

    public void spawnMMDemon() {
        CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
            @Override
            public void execute(CycleEventContainer container) {
                NPC mmDemon = new MMDemon(new Position(DEMON_SPAWN_X, DEMON_SPAWN_Y, resolveHeight(HEIGHT_LEVEL)));
                mmDemon.getBehaviour().setRespawn(!questInstance);
                mmDemon.getBehaviour().setRespawnWhenPlayerOwned(!questInstance);
                add(mmDemon);
                container.stop();
            }
        }, 6);
    }

}