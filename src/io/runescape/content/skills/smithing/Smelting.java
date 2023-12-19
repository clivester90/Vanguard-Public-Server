package io.runescape.content.skills.smithing;

import io.runescape.Server;
import io.runescape.content.achievement.AchievementType;
import io.runescape.content.achievement.Achievements;
import io.runescape.model.cycleevent.CycleEventHandler;
import io.runescape.model.cycleevent.Event;
import io.runescape.model.entity.player.Player;
import io.runescape.model.items.GameItem;
import io.runescape.model.items.ItemAssistant;

import java.util.Objects;

public class Smelting {

	public enum Bars {
		BRONZE(new GameItem(436), new GameItem(438), 2349, 1, 6, 2405, true, "bronze"),
		IRON(new GameItem(440), new GameItem(-1), 2351, 15, 13, 2406, false, "iron"),
		SILVER(new GameItem(442, 1), new GameItem(-1), 2355, 20, 14, 2407, false, "silver"),
		STEEL(new GameItem(440, 1), new GameItem(453, 1), 2353, 30, 18, 2409, true, "steel"),
		GOLD(new GameItem(444, 1), new GameItem(-1), 2357, 40, 23, 2410, false, "gold"),
		MITHRIL(new GameItem(447, 1), new GameItem(453, 4), 2359, 50, 30, 2411, true, "mithril"),
		ADAMANT(new GameItem(449, 1), new GameItem(453, 6), 2361, 70, 38, 2412, true, "adamant"),
		RUNE(new GameItem(451, 1), new GameItem(453, 8), 2363, 85, 50, 2413, true, "rune");


		private final GameItem mainIngredientOre;
		private final GameItem combinationOre;
		private final int bar;
		private final int req;
		private final int exp;
		private final int frame;
		private final boolean twoOres;
		private final String type;

		GameItem getMainIngredientOre() {
			return mainIngredientOre;
		}

		GameItem getCombinationOre() {
			return combinationOre;
		}

		public int getBar() {
			return bar;
		}

		int getReq() {
			return req;
		}

		int getExp() {
			return exp;
		}

		int getFrame() {
			return frame;
		}

		boolean twoOres() {
			return twoOres;
		}

		String getType() {
			return type;
		}

		Bars(GameItem ore, GameItem ore2, int bar, int req, int xp, int frame, boolean two, String type) {
			this.mainIngredientOre = ore;
			this.combinationOre = ore2;
			this.bar = bar;
			this.req = req;
			this.exp = xp;
			this.frame = frame;
			this.twoOres = two;
			this.type = type;
		}

		static Bars forType(String type) {
			for (Bars bar : values())
				if (bar.getType().equals(type))
					return bar;
			return null;
		}
	}

	/**
	 * Starts Smelting
	 */
	public static void startSmelting(Player c, String type, String amount, String usage) {
		c.barType = type;
		c.smeltAmount = getAmount(amount);
		c.bar = Bars.forType(c.barType);
		if (c.bar == null) //Making sure when the "bar" is null it returns
			return;
		boolean hasItems;
		if (c.bar.twoOres()) {
			hasItems = hasItems(c, new GameItem(c.bar.getMainIngredientOre().getId()), new GameItem(c.bar.getCombinationOre().getId()), c.bar.getBar());
		} else {
			hasItems = hasItems(c, new GameItem(c.bar.getMainIngredientOre().getId()), new GameItem(-1), c.bar.getBar());
		}
		if (hasItems) {
			if (hasReqLvl(c, c.bar.getReq(), c.bar.getBar())) {
				startCycle(c, usage);
			}
		}
	}

	private static void startCycle(final Player c, String usage) {
		c.getPA().stopSkilling();
		Server.getEventHandler().submit(new Event<>("skilling", c, 1) {
			public void execute() {
				if (c.isDisconnected()) {
					this.stop();
					return;
				}
				if (c.lastSmelt <= 0 || System.currentTimeMillis() - c.lastSmelt >= 1000) {
					if (c.smeltAmount <= 0) {
						stop();
						return;
					}
					appendDelay(c, usage);
				}
			}

			@Override
			public void stop() {
				super.stop();
				if (c.isDisconnected()) {
					return;
				}
				resetSmelting(c);
			}
		});
	}

	/**
	 * Applies Smelting delay
	 */
	private static void appendDelay(Player c, String usage) {
		boolean goldSmithGaunts = c.getItems().isWearingItem(776) && c.bar.getBar() == 2357;
		double percentOfXp = c.bar.getExp() / 2;
		if (c.smeltAmount > 0) {
			boolean hasItems;
			if (c.bar.twoOres())
				hasItems = hasItems(c, c.bar.getMainIngredientOre(), c.bar.getCombinationOre(), c.bar.getBar());
			else
				hasItems = hasItems(c, c.bar.getMainIngredientOre(), new GameItem(-1), c.bar.getBar());
			if (hasItems) {
				Achievements.increase(c, AchievementType.SMITH, 1);
				c.getPA().sendSound(2725);

				if (!Objects.equals(usage, "INFERNAL")) {
					c.startAnimation(899);
				}
				c.getItems().deleteItem(c.bar.getMainIngredientOre().getId(), c.bar.getMainIngredientOre().getAmount());
				if (c.bar.twoOres()) {
					c.getItems().deleteItem(c.bar.getCombinationOre().getId(), c.bar.getCombinationOre().getAmount());
				}
				c.getItems().addItem(c.bar.getBar(), 1);
				c.getPA().addSkillXP(Objects.equals(usage, "INFERNAL") ? (double) c.bar.getExp() / 2 : c.bar.getExp(), Player.playerSmithing, true);
			}
		} else {
			resetSmelting(c);
			c.getPA().removeAllWindows();
			return;
		}
		c.lastSmelt = System.currentTimeMillis();
		c.smeltAmount--;
		c.getPA().removeAllWindows();
	}

	/**
	 * Resets Smelting variables
	 */
	private static void resetSmelting(Player c) {
		c.smeltAmount = 0;
		c.barType = "";
		c.bar = null;
		c.isSmelting = false;
		c.lastSmelt = 0;
		CycleEventHandler.getSingleton().stopEvents(c, c.smeltEventId);
	}

	/**
	 * Checks if the player has the required level
	 */
	private static boolean hasReqLvl(Player c, int req, int bar) {
		int level = c.getPA().getLevelForXP(c.playerXP[Player.playerSmithing]);
		if (level >= req)
			return true;
		else
			c.sendMessage("You need a Smithing level of " + req + " to smelt a " + ItemAssistant.getItemName(bar));
		resetSmelting(c);
		return false;
	}

	/**
	 * Checks if the player has the required items
	 */
	private static boolean hasItems(Player c, GameItem firstOre, GameItem secondOre, int createdBar) {
		String ingredientOreName = ItemAssistant.getItemName(firstOre.getId());
		String combinationOreName = ItemAssistant.getItemName(secondOre.getId());
		String barOutcome = ItemAssistant.getItemName(createdBar);
		if (secondOre.getId() > 0) {
			if (c.getItems().playerHasItem(firstOre.getId(), firstOre.getAmount()) && c.getItems().playerHasItem(secondOre.getId(), secondOre.getAmount()))
				return true;
		} else {
			if (c.getItems().playerHasItem(firstOre.getId(), firstOre.getAmount()))
				return true;
		}
		if (secondOre.getId() > 0)
			c.sendMessage("You need an " + ingredientOreName + " and " + secondOre.getAmount() + "x " + combinationOreName + " to smelt a " + barOutcome + ".");
		else
			c.sendMessage("You need an " + ingredientOreName + " to smelt a " + barOutcome + ".");
		resetSmelting(c);
		return false;
	}

	/**
	 * Gets the smelting amount
	 */
	private static int getAmount(String amount) {
		if (Objects.equals(amount, "ONE"))
			return 1;
		if (Objects.equals(amount, "FIVE"))
			return 5;
		if (Objects.equals(amount, "TEN"))
			return 10;
		if (Objects.equals(amount, "ALL"))
			return 28;

		return -1;
	}

}
