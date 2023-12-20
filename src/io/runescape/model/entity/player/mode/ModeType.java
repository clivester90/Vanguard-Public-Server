package io.runescape.model.entity.player.mode;

public enum ModeType {
	STANDARD,
	IRON_MAN,
	ULTIMATE_IRON_MAN,
	HC_IRON_MAN,
	HARDCORE,
	ROGUE_HARDCORE_IRONMAN,
	ROGUE_IRONMAN,
	GROUP_IRONMAN,
	EVENT_MAN;

	public String getFormattedName() {
		switch (this) {
			case STANDARD:
				return "Standard";
			case IRON_MAN:
				return "Ironman";
			case ULTIMATE_IRON_MAN:
				return "Ultimate Ironman";
			case HC_IRON_MAN:
				return "Hardcore Ironman";
			case HARDCORE:
				return "Hardcore";
			case ROGUE_HARDCORE_IRONMAN:
				return "Rogue Hardcore Ironman";
			case ROGUE_IRONMAN:
				return "Rogue Ironman";
			case GROUP_IRONMAN:
				return "Group Ironman";
			default:
				throw new IllegalStateException("No format option for: " + this);
		}
	}
}
