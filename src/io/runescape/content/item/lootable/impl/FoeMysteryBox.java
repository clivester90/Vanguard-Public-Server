package io.runescape.content.item.lootable.impl;

import io.runescape.content.item.lootable.LootRarity;
import io.runescape.content.item.lootable.MysteryBoxLootable;
import io.runescape.model.entity.player.Player;
import io.runescape.model.items.GameItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import QuickUltra.Rarity;

/**
 * Revamped a simple means of receiving a random item based on chance.
 * 
 * @author Jason MacKeigan
 * @date Oct 29, 2014, 1:43:44 PM
 */
public class FoeMysteryBox extends MysteryBoxLootable {

	/**
	 * A map containing a List of {@link GameItem}'s that contain items relevant to their rarity.
	 */
	private static final Map<LootRarity, List<GameItem>> items = new HashMap<>();

	/**
	 * Stores an array of items into each map with the corresponding rarity to the list
	 */
	static {
		items.put(LootRarity.COMMON, //50% chance
				Arrays.asList(
						new GameItem(21003),//Elder Maul
						new GameItem(19553),//Amulet of Torture
						new GameItem(13576),//dragon warhammer
						new GameItem(13239),//primordial boots
						new GameItem(13235),//eternal boots
						new GameItem(995, 25000000),// 25m gp
						new GameItem(6199, 6),// 6 mystery boxes

						new GameItem(11785),//ACB
						new GameItem(11832),//BCP
						new GameItem(11834),//TASSETS
						new GameItem(11828),//Arma Chest
						new GameItem(11830),//Arma Legs
						new GameItem(995, 30000000),// 25m gp
						new GameItem(6199, 6),// 6 mystery boxes
						new GameItem(21003),//Elder Maul
						new GameItem(995, 30000000),// 25m gp
						new GameItem(19553),//Amulet of Torture
						new GameItem(13576),//dragon warhammer
						new GameItem(13239),//primordial boots
						new GameItem(13235)//eternal boots
				));
		items.put(LootRarity.UNCOMMON, //50% chance
				Arrays.asList(
						new GameItem(13346, 5),//5 ultra mboxes
						new GameItem(995, 50000000),// 50m gp
						new GameItem(6828, 10),//
						new GameItem(995, 50000000),// 50m gp
						new GameItem(2396, 1),//1 $25 scroll
						new GameItem(6828, 10),//
						new GameItem(6828, 15),//
						new GameItem(995, 50000000),// 60m gp
						new GameItem(2403, 1),//1 $10 scroll
						new GameItem(6828, 15),//
						new GameItem(13346, 10),//
						new GameItem(995, 50000000),// 50m gp
						new GameItem(13346, 6)//5 ultra mboxes
				));

		items.put(LootRarity.RARE,//8% chance
				Arrays.asList(
						new GameItem(22325),//scythe
						new GameItem(13346, 10),//10 ultra mboxes
						new GameItem(20997),//twisted bow
						new GameItem(24111),//zilly godbow
						new GameItem(25736),//holy scythe
						new GameItem(26382),//torv helm
						new GameItem(26384),//torv plate
						new GameItem(26386),//torv legs
						new GameItem(30022),//Kratos Pet
						new GameItem(13346, 10),//10 ultra mboxes
						new GameItem(995, 90000000),// 90m gp
						new GameItem(607, 1), // $250 scroll
						new GameItem(26484),//Abyssal tentacle or
						new GameItem(34037),//Death cape
						new GameItem(26382),//torv helm
						new GameItem(26384),//torv plate
						new GameItem(26386),//torv legs
						new GameItem(30022),//Kratos Pet
						new GameItem(26233),//Ancient godsword
						new GameItem(21752),//rune rogue ring normal
						new GameItem(20784),//dragon claws
						new GameItem(995, 90000000),// 90m gp
						new GameItem(25734),//holy ghrazi rapier
						new GameItem(995, 90000000)// 90m gp

							));
		}

    /**
	 * Constructs a new myster box to handle item receiving for this player and this player alone
	 *
	 * @param player the player
	 */
	public FoeMysteryBox(Player player) {
		super(player);
	}

	@Override
	public int getItemId() {
		return 8167;
	}

	@Override
	public Map<LootRarity, List<GameItem>> getLoot() {
		return items;
	}
}