package io.xeros.content.skills;

import java.util.stream.Stream;

import io.xeros.util.Misc;
import lombok.Getter;

public enum Skill {



	ATTACK(0),
	DEFENCE(1),
	STRENGTH(2),
	HITPOINTS(3),
	RANGED(4),
	PRAYER(5),
	MAGIC(6),
	COOKING(7),
	WOODCUTTING(8),
	FLETCHING(9),
	FISHING(10),
	FIREMAKING(11),
	CRAFTING(12),
	SMITHING(13),
	MINING(14),
	HERBLORE(15),
	AGILITY(16),
	THIEVING(17),
	SLAYER(18),
	FARMING(19),
	RUNECRAFTING(20),
	HUNTER(21),
	CONSTRUCTION(22);

	public static final int MAX_EXP = 200_000_000;

	public static int iconForSkill(Skill skill) {
		switch (skill) {
			case ATTACK:
				return 0;
			case STRENGTH:
				return 1;
			case DEFENCE:
				return 2;
			case RANGED:
				return 3;
			case PRAYER:
				return 4;
			case MAGIC:
				return 5;
			case RUNECRAFTING:
				return 6;
			case HITPOINTS:
				return 7;
			case AGILITY:
				return 8;
			case HERBLORE:
				return 9;
			case THIEVING:
				return 10;
			case CRAFTING:
				return 11;
			case FLETCHING:
				return 12;
			case MINING:
				return 13;
			case SMITHING:
				return 14;
			case FISHING:
				return 15;
			case COOKING:
				return 16;
			case FIREMAKING:
				return 17;
			case WOODCUTTING:
				return 18;
			case SLAYER:
				return 19;
			case FARMING:
				return 20;
			case HUNTER:
				return 22;
			default:
				return 0;
		}
	}

	public static Skill forId(int id) {
		return Stream.of(values()).filter(s -> s.id == id).findFirst().orElse(null);
	}

	public static int getIconId(Skill skill) {
		switch (skill) {
			case ATTACK:
				return 134;
			case STRENGTH:
				return 135;
			case DEFENCE:
				return 136;
			case RANGED:
				return 137;
			case PRAYER:
				return 138;
			case MAGIC:
				return 139;
			case RUNECRAFTING:
				return 140;
			case HITPOINTS:
				return 141;
			case AGILITY:
				return 142;
			case HERBLORE:
				return 143;
			case THIEVING:
				return 144;
			case CRAFTING:
				return 145;
			case FLETCHING:
				return 146;
			case MINING:
				return 147;
			case SMITHING:
				return 148;
			case FISHING:
				return 14;
			case COOKING:
				return 150;
			case FIREMAKING:
				return 151;
			case WOODCUTTING:
				return 152;
			case SLAYER:
				return 153;
			case FARMING:
				return 154;
			case HUNTER:
				return 155;
			default:
				return -1;
		}
	}

	public static Skill[] getCombatSkills() {
		return Stream.of(values()).filter(skill -> skill.getId() <= 6).toArray(Skill[]::new);
	}

	public static Skill[] getNonCombatSkills() {
		return Stream.of(values()).filter(skill -> skill.getId() > 6).toArray(Skill[]::new);
	}

	public static final int MAXIMUM_SKILL_ID = 21;

	public static Stream<Skill> stream() {
		return Stream.of(values());
	}

	public static int length() {
		return values().length;
	}

	@Getter
	private final int id;

	Skill(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String name = name().toLowerCase();
		return Misc.capitalize(name);
	}

	public static final String[] SKILL_NAMES = { "attack", "defence", "strength", "hitpoints", "ranged", "prayer", "magic", "cooking", "woodcutting", "fletching", "fishing", "firemaking", "crafting", "smithing", "mining", "herblore", "agility", "thieving", "slayer", "farming", "runecrafting", "summoning", "hunter", "construction", "dungeoneering" };
}

