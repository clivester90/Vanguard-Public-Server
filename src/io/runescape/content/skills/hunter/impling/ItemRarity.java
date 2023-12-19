package io.runescape.content.skills.hunter.impling;

public enum ItemRarity {
	
	COMMON(0), UNCOMMON(1), RARE(2), VERY_RARE(3), ULTRA_RARE(4);

	ItemRarity(int rarity) {
		this.rarity = rarity;
	}
	
	public int rarity;

	public void setRarity(ItemRarity rarity) {
		this.rarity = rarity.rarity;
	}

	public int getRarity() {
		return this.rarity;
	}
}