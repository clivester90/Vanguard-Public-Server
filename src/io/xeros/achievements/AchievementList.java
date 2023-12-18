package io.xeros.achievements;

import io.xeros.Configuration;
import io.xeros.content.achievement.AchievementTier;
import io.xeros.content.achievement.AchievementType;
import io.xeros.model.entity.player.Player;
import io.xeros.model.items.GameItem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.xeros.model.Items.*;

/**
 * List of all achievements.
 * 
 * @author C.T for runerogue
 *
 */
public enum AchievementList {

	/* Easy Achievements */
	ANSWER_15_TRIVIABOTS_CORRECTLY("Trivia I", "Correctly answer 15 Trivia Questions",15, AchievementHandler.AchievementDifficulty.EASY, new GameItem(995, 1000000)),//1M GP
	CLAIM_5_VOTES("Supporter", "Vote 5 times for Vanguard",5, AchievementHandler.AchievementDifficulty.EASY, new GameItem(1464, 10)),//10 VOTE TICKETS
	COMPLETE_25_EASY_CLUES("Clue Hunter I", "Complete 25 Easy Clue Scrolls", 25, AchievementHandler.AchievementDifficulty.EASY, new GameItem(995, 3000000)),//3M GP
	COMPLETE_25_NORMAL_CLUES("Clue Hunter II", "Complete 25 Medium Clue Scrolls", 25, AchievementHandler.AchievementDifficulty.EASY, new GameItem(995, 5000000)),//5M GP
	ADVANCED_OPTIONS("Configurator", "Open the Advanced Settings menu", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem(21046 , 1)),//CHEST RATE BONUS
	SKILLING_ISLAND("Island Visitor", "Visit the Skilling Island", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem(30000, 1)),//RESOURCE BOX SMALL X1
	PARTICIPATE_IN_1_TOURNAMENT("Ready2Rumble I", "Join an Automated Tournament", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem(2528, 2)),//XP LAMPS x2
	MONEY_POUCH("Bag Boy", "Add some coins to your Money Pouch", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem(21046 , 1)),//CHEST RATE BONUS
	CREATE_A_RAID_PARTY("Chambers Leader", "Create or Join a Chambers of Xeric party", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem(21046 , 1)),//CHEST RATE BONUS
	CHANGING_PRAYERS("Swapper", "Swap your spell book", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem(2528, 1)),//XP LAMPS x1
	MONKEY_MADNESS("Monkey Nut", "Complete the Monkey Madness mini-quest", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem(2528, 1)),//EXP lamp
	UPGRADE_1("Forger", "Successfully upgrade an item at the Upgrade Table", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem(989, 3)),//CRYSTAL KEY X3
	FLOWER_POKER_1("Gambler", "Challenge a player to a game of Flower Poker", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem(10833, 2)),//COIN BAG X2
	DONATE_WELL("Well Wishes", "Donate coins or a seed to the Well", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem(2528, 2)),//XP LAMPS x2
	ENTER_THE_LOTTERY_5_TIMES("Scratch Off", "Enter the lottery 55 times", 5, AchievementHandler.AchievementDifficulty.EASY, new GameItem(21046 , 5)),//CHEST RATE BONUS
    REVENANT_HUNTER_I("Rev Hunter I", "Kill 100 Revenants.", 100, AchievementHandler.AchievementDifficulty.EASY, new GameItem(ANCIENT_EMBLEM,2)),//ANCIENT EMBLEM X1
    DRAGON_SLAYER_I("Dragon slayer I", "Kill 100 Green Dragons.", 100, AchievementHandler.AchievementDifficulty.EASY, new GameItem(DRAGON_BONES,150)),//DRAGON BONES X150
    VETION_I("Vet'ion I", "Kill 25 Vet'ion 25 times", 25, AchievementHandler.AchievementDifficulty.EASY, new GameItem(2996, 100)),//PK POINTS X100
	NEX_I("Nex I", "Kill Nex 25 times", 25, AchievementHandler.AchievementDifficulty.EASY, new GameItem (11942, 3)),//ECU KEY X3
	REV_MALEDICTUS_I("Revenant Maledictus I", "Kill 1 Enranged revenant maledictus.", 1, AchievementHandler.AchievementDifficulty.EASY, new GameItem (21807, 1)),//ancient emblem X1
	RECHARGE_GLORYI("Glorified I", "Recharge 50 Amulets of Glory", 50, AchievementHandler.AchievementDifficulty.EASY, new GameItem (995, 2000000)),//2m gold coins


	/* Medium Achievements */
	BURN_200_LOGS("Pyromaniac", "Burn 200 logs", 200, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem(995 , 5000000)),//CASH 5M
	KILL_GALVEK("Fire Breath", "Kill Galvek 1 time", 1, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem(2996 , 200)),//PK POINTS X200
	COMPLETE_25_HARD_CLUES("Clue Hunter III", "Complete 25 Hard Clue Scrolls", 25, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem(995 , 7500000)),//7.5M GP
	CRAFT_FEROCIOUS_GLOVES("Ferocious Fister", "Craft Ferocious Gloves from Hydra Leather", 1, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem(691 , 1)),//10k FOE POINTS
	WIN_A_TOURNAMENT("Ready2Rumble II", "Win an Automated Tournament", 1, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem(2996 , 75)),//PK POINTS X50
	DRAGON_DEFENDER("Defender Man", "Obtain a Dragon Defender from Warriors Guild", 1, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem(691 , 1)),//10k FOE POINTS
	DAILY_TASK("Daily Doer", "Complete 10 Daily Tasks", 10, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem(995 , 25000000)),//25M GP
    REVENANT_HUNTER_II("Revenant Hunter II", "Kill 500 Revenants", 500, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem(AMULET_OF_AVARICE, 1)),//AMULET OF AVARICE X1
    DRAGON_SLAYER_II("Dragon slayer II", "Kill King Black Dragon 50 times", 50, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem(KBD_HEADS, 1)),//KBD HEADS
    VETION_II("Vet'ion II", "Kill Vet'ion 75 times", 75, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem(2996, 500)),//PK POINTS X500
	NEX_II("Nex II", "Kill Nex 50 times", 50, AchievementHandler.AchievementDifficulty.MEDIUM , new GameItem (23951, 5)),//Crystalline key x5
	REV_MALEDICTUS_II("Revenant Maledictus II", "Kill 10 Enranged revenant maledictus.", 10, AchievementHandler.AchievementDifficulty.MEDIUM , new GameItem (12756, 1)),//arhiach emblem tier 10 x1
	RECHARGE_GLORYII("Glorified II", "Recharge 250 Amulets of Glory", 250, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem (995, 10000000)),//10M GP

	/* Hard Achievements */
	COMPLETE_5_INFERNO("Zuk Me", "Complete the Inferno mini-game 5 times", 5, AchievementHandler.AchievementDifficulty.HARD, new GameItem(6529 , 200000)),//TOKKUL 200K
	COMPLETE_25_MASTER_CLUES("Clue Master", "Complete 25 Master Clue Scrolls", 25, AchievementHandler.AchievementDifficulty.HARD, new GameItem(3464 , 2)),//RARE RAIDS KEY X2
	WIN_10_TOURNAMENTS("Ready2Rumble III", "Win 10 Automated Tournaments", 10, AchievementHandler.AchievementDifficulty.HARD, new GameItem(13346 , 3)),//ULTRA MYSTERY BOX X3
	KILL_25_KRATOS("God of War", "Defeat Kratos 25 times", 25, AchievementHandler.AchievementDifficulty.HARD, new GameItem(7302 , 10)),//KRATOS KEY X10
	KILL_50_VOTE_BOSS("Boss Voter", "Defeat the Vote Boss 50 times", 50, AchievementHandler.AchievementDifficulty.HARD, new GameItem(1464 , 75)),//VOTE TICKET X75
	ANSWER_80_TRIVIABOTS_CORRECTLY("Trivia II", "Correctly answer 50 Trivia Questions", 50, AchievementHandler.AchievementDifficulty.HARD, new GameItem(995 , 5000000)),//5M GP
    REVENANT_HUNTER_III("Revenant hunter III", "Kill 2,500 revenants", 2500,  AchievementHandler.AchievementDifficulty.HARD, new GameItem(ANCIENT_STATUETTE,2)),//ANCIENT STATUETTE X2
    REVENANT_HUNTER_IV("Revenant hunter IV", "Kill 10,000 revenants", 10000,  AchievementHandler.AchievementDifficulty.HARD, new GameItem(CRAWS_BOW, 1)),//CRAWS BOWS X1
    DRAGON_SLAYER_III("Dragon slayer III", "Defeat King Black Dragon 500 times", 500, AchievementHandler.AchievementDifficulty.HARD, new GameItem(ANCIENT_WYVERN_SHIELD, 1)),//ANCIENT WYVEN SHIELD X1
    DRAGON_SLAYER_IV("Dragon slayer IV", "Kill 200 rune dragons", 200, AchievementHandler.AchievementDifficulty.HARD, new GameItem(DRAGONFIRE_WARD, 1)),//DRAGON FIRE WARD X1
    VETION_III("Vet'ion III", "Kill 150 Vet'ions", 150, AchievementHandler.AchievementDifficulty.HARD, new GameItem (RING_OF_THE_GODS_I, 1)),//RING OF THE GODS I
	NEX_III("Nex III", "Kill 100 Nex", 100, AchievementHandler.AchievementDifficulty.HARD , new GameItem (21307, 3)),//ROGUE CRATE x3
	REV_MALEDICTUS_III("Revenant maledictus III", "Kill 25 Enranged revenant maledictus", 25, AchievementHandler.AchievementDifficulty.HARD , new GameItem (22542, 1)),//Vig chain mace x1
	ETERNAL_GLORY("Eternally Glorified", "Receive the amulet of eternal glory from the fountain of rune", 1, AchievementHandler.AchievementDifficulty.HARD , new GameItem (2841, 3)),//bonus xp scroll
	RECHARGE_GLORYIII("Glorified III", "Recharge 500 amulet of glory's", 500, AchievementHandler.AchievementDifficulty.HARD, new GameItem (995, 20000000)),//20M GP
	PET_SHARK("Pet shark", "Obtain the pet shark from the fishing caskets", 1, AchievementHandler.AchievementDifficulty.HARD, new GameItem (6199, 1)),//Mbox x1

	MAX("Maxed", "Achieve level 99 in all skills on "+ Configuration.SERVER_NAME+"", 1, AchievementHandler.AchievementDifficulty.HARD, new GameItem(13346, 1)),

    //Pvp
    PVP_I("PVP I", "Kill 100 players in the wilderness.",100, AchievementHandler.AchievementDifficulty.EASY, new GameItem (BANDOS_GODSWORD, 1)),//BANDOS GODSWORD X1
    PVP_II("PVP II", "Kill 500 players in the wilderness.",500, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem (ARMADYL_GODSWORD, 1)),//ARMADYL GODSWORD X1
    PVP_III("PVP III", "Kill 1,000 players in the wilderness.",1000, AchievementHandler.AchievementDifficulty.HARD, new GameItem (VESTAS_LONGSWORD, 1)),//VESTA LONGSWORD

	COMPLETIONIST("Completionist", "Complete all Achievements besides this one.", 1,AchievementHandler.AchievementDifficulty.HARD, new GameItem(786, 1)),//50$ donation scroll
   // BOUNTY_HUNTER_I("Bounty hunter I", "Kill 50 targets.", 50, AchievementHandler.AchievementDifficulty.EASY, new GameItem (PRIMORDIAL_BOOTS, 1)),
   // BOUNTY_HUNTER_II("Bounty hunter II", "Kill 100 targets.", 100, AchievementHandler.AchievementDifficulty.MEDIUM, new GameItem (NEITIZNOT_FACEGUARD, 1)),
   // BOUNTY_HUNTER_III("Bounty hunter III", "Kill 300 targets.", 300, AchievementHandler.AchievementDifficulty.EASY, new GameItem (AMULET_OF_TORTURE, 1)),
    ;


	public static List<AchievementList> asList(AchievementHandler.AchievementDifficulty difficulty) {
		return Arrays.stream(values()).filter(a -> a.getDifficulty() == difficulty).sorted(Comparator.comparing(Enum::name)).collect(Collectors.toList());
	}

	private final String name;
	private final String description;
	private int completeAmount;
	private final GameItem[] rewards;

	private final AchievementHandler.AchievementDifficulty difficulty;


	private AchievementList(String name, String description, int completeAmount, AchievementHandler.AchievementDifficulty difficulty,  GameItem... rewards) {
		this.name = name;
		this.description = description;
		this.completeAmount = completeAmount;
		this.difficulty = difficulty;
		this.rewards = rewards;
		for (GameItem b : rewards) if (b.getAmount() == 0) b.setAmount(1);
	}
	
	private AchievementList(String name, int completeAmount, AchievementHandler.AchievementDifficulty difficulty,  GameItem... rewards) {
		this.name = name;
		this.description = name;
		this.completeAmount = completeAmount;
		this.difficulty = difficulty;
		this.rewards = rewards;
		for (GameItem b : rewards) if (b.getAmount() == 0) b.setAmount(1);
	}

	public int getCompleteAmount() {
		return completeAmount;
	}



	public String getDescription() {
		return description;
	}

	public AchievementHandler.AchievementDifficulty getDifficulty() {
		return difficulty;
	}

	public String getName() {
		return name;
	}

	public static AchievementList getAchievement(String name) {
		for (AchievementList achievements : AchievementList.values())
			if (achievements.getName().equalsIgnoreCase(name))
				return achievements;
		return null;
	}

	public int getReward() {

		switch (difficulty) {
		case MEDIUM:
			return 2;
		case HARD:
			return 3;
		case EASY:

		default:
			return 1;
		}
	}



	public GameItem[] getRewards() {
		return rewards;
	}

	public static void addReward(Player player, AchievementList achievement) {
		for (GameItem item : achievement.getRewards()) {
			player.getItems().addItemToBankOrDrop(item.getId(), item.getAmount());
		}
	}


	public static int getTotal() {
		return values().length;
	}


}
