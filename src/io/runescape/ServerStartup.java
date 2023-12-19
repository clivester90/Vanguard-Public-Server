package io.runescape;

import io.runescape.annotate.Init;
import io.runescape.annotate.PostInit;
import io.runescape.benchmark.GameBenchmark;
import io.runescape.content.FountainOfRune;
import io.runescape.content.bonus_skill.BonusSkill;
import io.runescape.content.boosts.Boosts;
import io.runescape.content.bosses.Nex;
import io.runescape.content.bosses.SeaSnake;
import io.runescape.content.bosses.godwars.GodwarsEquipment;
import io.runescape.content.bosses.godwars.GodwarsNPCs;
import io.runescape.content.bosses.nightmare.NightmareStatusNPC;
import io.runescape.content.bosses.sarachnis.SarachnisNpc;
import io.runescape.content.collection_log.CollectionLog;
import io.runescape.content.combat.stats.TrackedMonster;
import io.runescape.content.commands.CommandManager;
import io.runescape.content.dailyrewards.DailyRewardContainer;
import io.runescape.content.dailyrewards.DailyRewardsRecords;
import io.runescape.content.event.eventcalendar.EventCalendar;
import io.runescape.content.event.eventcalendar.EventCalendarWinnerSelect;
import io.runescape.content.evil_tree.EvilTree;
import io.runescape.content.shatteredshards.ShatteredShardPrice;
import io.runescape.content.koranian_event.KoranianEventBossHandler;
import io.runescape.content.lottery.Lottery;
import io.runescape.content.pkertab.ToplistExecution;
import io.runescape.content.polls.PollTab;
import io.runescape.content.preset.PresetManager;
import io.runescape.content.referral.ReferralCode;
import io.runescape.content.revenant_event.RevenantEventBossHandler;
import io.runescape.content.shooting_star.ShootingStar;
import io.runescape.content.skills.runecrafting.ouriana.ZamorakGuardian;
import io.runescape.content.tradingpost.Listing;
import io.runescape.content.trails.TreasureTrailsRewards;
import io.runescape.content.vote_panel.VotePanelManager;
import io.runescape.content.wogw.Wogw;
import io.runescape.content.world_boss_events.EventBossHandler;
import io.runescape.content.world_event.WorldEvent;
import io.runescape.content.world_event_galvek.GalvekEventBossHandler;
import io.runescape.content.world_event_solak.SolakEventBossHandler;
import io.runescape.model.Npcs;
import io.runescape.model.collisionmap.ObjectDef;
import io.runescape.model.collisionmap.Region;
import io.runescape.model.collisionmap.doors.DoorDefinition;
import io.runescape.model.cycleevent.impl.*;
import io.runescape.model.definitions.AnimationLength;
import io.runescape.model.definitions.ItemDef;
import io.runescape.model.definitions.ItemStats;
import io.runescape.model.definitions.NpcDef;
import io.runescape.model.definitions.NpcStats;
import io.runescape.model.definitions.ShopDef;
import io.runescape.model.entity.npc.NPCRelationship;
import io.runescape.model.entity.npc.NpcSpawnLoader;
import io.runescape.model.entity.npc.stats.NpcCombatDefinition;
import io.runescape.model.entity.player.save.PlayerSave;
import io.runescape.model.lobby.LobbyManager;
import io.runescape.model.world.ShopHandler;
import io.runescape.punishments.PunishmentCycleEvent;
import io.runescape.task.TaskManager;
import io.runescape.util.Reflection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Stuff to do on startup.
 * @author Michael Sasse (https://github.com/mikeysasse/)
 */
public class ServerStartup {

    private static final Logger logger = LoggerFactory.getLogger(ServerStartup.class);

    static void load() throws Exception {
        Reflection.getMethodsAnnotatedWith(Init.class).forEach(method -> {
            try {
                method.invoke(null);
            } catch (Exception e) {
                logger.error("Error loading @Init annotated method[{}] inside class[{}]", method, method.getClass(), e);
                e.printStackTrace();
                System.exit(1);
            }
        });

        FountainOfRune.declare();//fountain of rune
        //DonationReward.load();
        PlayerSave.loadPlayerSaveEntries();
        EventCalendarWinnerSelect.getInstance().init();
        TrackedMonster.init();
        Boosts.init();
        ItemDef.load();
        ShopDef.load();
        ShopHandler.load();
        NpcStats.load();
        ItemStats.load();
        NpcDef.load();
        // Npc Combat Definition must be above npc load
        NpcCombatDefinition.load();
        Server.npcHandler.init();
        NPCRelationship.setup();
        EventCalendar.verifyCalendar();
        Server.getPunishments().initialize();
        Server.getEventHandler().submit(new DidYouKnowEvent());
        Server.getEventHandler().submit(new BonusApplianceEvent());
        Server.getEventHandler().submit(new PunishmentCycleEvent(Server.getPunishments(), 50));
        Server.getEventHandler().submit(new UpdateQuestTab());
        Server.getEventHandler().submit(new EventTimersEvent());

        new GameBenchmark("pker-tab-event", ToplistExecution::execute, 100, TimeUnit.MILLISECONDS, Configuration.BENCHMARK).execute();
        new GameBenchmark("lottery", Lottery::readLotteryFiles, 100, TimeUnit.MILLISECONDS, Configuration.BENCHMARK).execute();
        Lottery.startLottery();
      //  Tournament.startTourny();  closed untill some issues fixed



        Listing.init();
        Wogw.init();
        PollTab.init();
        DoorDefinition.load();
        GodwarsEquipment.load();
        GodwarsNPCs.load();
        LobbyManager.initializeLobbies();
        VotePanelManager.init();
        Server.getDropManager().read();
        TreasureTrailsRewards.load();
        AnimationLength.startup();
        PresetManager.getSingleton().init();
        ObjectDef.loadConfig();
        CollectionLog.init();
        Region.load();
       // new GameBenchmark("region", Region::load, 100, TimeUnit.MILLISECONDS, Configuration.BENCHMARK).execute();
        Server.getGlobalObjects().loadGlobalObjectFile();


        // Keep this below region load and object loading
        NpcSpawnLoader.load();
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
        CommandManager.initializeCommands();
        NightmareStatusNPC.init();


        BonusSkill.setBonusSkill();
        ShootingStar.spawnShootingStar();
        EvilTree.spawnEvilTreeGlobal();          //events
        EventBossHandler.spawnNPC();
        SolakEventBossHandler.spawnNPC();
        GalvekEventBossHandler.spawnNPC();
        KoranianEventBossHandler.spawnNPC();
        RevenantEventBossHandler.spawnNPC();
        TaskManager.sequence();

        ReferralCode.load();
        DailyRewardContainer.load();
        DailyRewardsRecords.load();
        ShatteredShardPrice.init();
        Server.getLogging().schedule();

        ZamorakGuardian.spawn();
        new SarachnisNpc(Npcs.SARACHNIS, SarachnisNpc.SPAWN_POSITION);
        WorldEvent.startEvent();

        Nex.spawn();
        SeaSnake.spawnSnake();

        //if (Server.isPublic()) {
           // PlayerSaveBackup.start(Configuration.PLAYER_SAVE_TIMER_MILLIS, Configuration.PLAYER_SAVE_BACKUP_EVERY_X_SAVE_TICKS);
       // }

        Reflection.getMethodsAnnotatedWith(PostInit.class).forEach(method -> {
            try {
                method.invoke(null);
            } catch (Exception e) {
                logger.error("Error loading @PostInit annotated method[{}] inside class[{}]", method, method.getClass(), e);
                e.printStackTrace();
                System.exit(1);
            }
        });
    }

}
