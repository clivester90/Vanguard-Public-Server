package io.runescape.content.items;

import io.runescape.content.cheatprevention.CheatEngineBlock;
import io.runescape.content.dialogue.DialogueBuilder;
import io.runescape.content.skills.Skill;
import io.runescape.model.Items;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;
import lombok.Getter;

public class Lamps {

    enum LampConstants {
        ATTACK(Skill.ATTACK.getId(), 98246, 1, true),
        STRENGTH(Skill.STRENGTH.getId(), 98247, 2, true),
        RANGED(Skill.RANGED.getId(), 98248, 3, true),
        MAGIC(Skill.MAGIC.getId(), 98249, 4, true),
        DEFENCE(Skill.DEFENCE.getId(), 98250, 5, true),
        HITPOINTS(Skill.HITPOINTS.getId(), 98251, 6, true),
        PRAYER(Skill.PRAYER.getId(), 98252, 7, true),
        AGILITY(Skill.AGILITY.getId(), 98253, 8, true),
        HERBLORE(Skill.HERBLORE.getId(), 98254, 9, true),
        THIEVING(Skill.THIEVING.getId(), 98255, 10, true),
        CRAFTING(Skill.CRAFTING.getId(), 99000, 11, false),
        RUNECRAFTING(Skill.RUNECRAFTING.getId(), 99001, 12, false),
        MINING(Skill.MINING.getId(), 99002, 13, true),
        SMITHING(Skill.SMITHING.getId(), 99003, 14, false),
        FISHING(Skill.FISHING.getId(), 99004, 15, true),
        COOKING(Skill.COOKING.getId(), 99005, 16, true),
        FIREMAKING(Skill.FIREMAKING.getId(), 99006, 17, true),
        WOODUCTTING(Skill.WOODCUTTING.getId(), 99007, 18, true),
        FLETCHING(Skill.FLETCHING.getId(), 99008, 19, false),
        SLAYER(Skill.SLAYER.getId(), 99009, 20, false),
        FARMING(Skill.FARMING.getId(), 99010, 21, true),
        CONSTRUCTION(Skill.CONSTRUCTION.getId(), 99011, 22, false),
        HUNTER(Skill.HUNTER.getId(), 99012, 23, true);


        @Getter
        final int skillId;
        @Getter
        final int buttonId;
        @Getter
        final int configId;
        @Getter
        final boolean bonusExperience;

        LampConstants(int skillId, int buttonId, int configId, boolean bonusExperience) {
            this.skillId = skillId;
            this.buttonId = buttonId;
            this.configId = configId;
            this.bonusExperience = bonusExperience;
        }
    }

    public static void handleItemOptionOne(Player player, int itemId) {
        if (itemId == Items.ANTIQUE_LAMP_31) {
            player.start(new DialogueBuilder(player).statement("<col=ff0000>This lamp will reset a skill of your choice.</col>").exit(plr -> {
                player.usingLamp = true;
                handleInterfaceOpen(player, true);
            }));
        }

        if (itemId == Items.EXPERIENCE_LAMP) {
            player.usingLamp = true;
            handleInterfaceOpen(player, true);
        }

        if (itemId == Items.DARK_RELIC) {
            player.usingLamp = true;
            player.sendMessage("A dark power emanates from the relic. You sense that this power can be directed.");
            handleInterfaceOpen(player, false);
        }
        player.rubbedLamp = itemId;
    }

    public static void handleInterfaceOpen(Player player, boolean message) {
        if(message) {
            player.sendMessage("You rub the lamp...");
        }
        player.getPA().showInterface(25330);
    }

    static boolean bonusXP = false;

    public static boolean handleLampButtons(Player player, int buttonId) {
        for (LampConstants lamp : LampConstants.values()) {
            if (buttonId == lamp.getButtonId()) {
                if (!player.usingLamp && System.currentTimeMillis() - player.clickDelay <= 2200) {
                    return false;
                }

                if (!player.usingLamp) {
                    CheatEngineBlock.ExperienceAbuseAlert(player);
                    return false;
                }
                player.getPA().sendConfig(261, lamp.getConfigId());
                player.antiqueItemResetSkillId = lamp.getSkillId();
                bonusXP = lamp.isBonusExperience();
                player.sendMessage("You select <col=ff0000>" + Misc.formatEnum(lamp.name()) + "</col>.");
                return true;
            }
        }

        if (buttonId == 99013) {
            if (!player.getItems().playerHasItem(Items.EXPERIENCE_LAMP) && (!player.getItems().playerHasItem(Items.DARK_RELIC) && (!player.getItems().playerHasItem(Items.ANTIQUE_LAMP_31)))) {
                return false;
            }

            if (player.usingLamp) {
                handleLampClose(player, player.rubbedLamp, bonusXP);
                return true;
            }
        }
        return false;
    }

    public static void handleLampClose(Player player, int itemId, boolean bonusExperience) {
        if (itemId == Items.EXPERIENCE_LAMP) {
            player.sendMessage("The lamp mysteriously vanishes...");
        }

        if (itemId == Items.DARK_RELIC) {
            player.getItems().deleteItem(Items.DARK_RELIC, 1);
            player.sendMessage("The dark relic mysteriously vanishes...");
            player.sendMessage("...and you gain some experience!");
        }

        if (itemId == Items.ANTIQUE_LAMP_31) {
            player.sendMessage("The antique Lamp mysteriously vanishes...");
            player.sendMessage("...and you gain some experience!");
        }

        int playerLevel = player.playerLevel[player.antiqueItemResetSkillId];
        int experience = itemId == Items.DARK_RELIC ? playerLevel * (bonusExperience ? 150 : 50) : playerLevel * 10;
        player.usingLamp = false;
        player.getItems().deleteItem(itemId, 1);
        player.getPA().addSkillXP(experience, player.antiqueItemResetSkillId, true);
        player.getPA().closeAllWindows();
    }

}
