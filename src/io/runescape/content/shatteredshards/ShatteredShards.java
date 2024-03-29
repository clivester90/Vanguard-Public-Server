package io.runescape.content.shatteredshards;

import io.runescape.Configuration;
import io.runescape.Server;
import io.runescape.content.achievement.AchievementType;
import io.runescape.content.achievement.Achievements;
import io.runescape.content.event.eventcalendar.EventChallenge;
import io.runescape.model.Items;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.PlayerHandler;
import io.runescape.model.entity.player.Right;
import io.runescape.model.items.GameItem;
import io.runescape.model.items.ItemAssistant;
import io.runescape.util.Misc;
import io.runescape.util.discord.Discord;
import io.runescape.util.logging.player.FireOfExchangeLog;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static io.runescape.content.shatteredshards.ShatteredShardPrice.getBurnPrice;

public class ShatteredShards {

    public static final int SS_SHOP_ID = 171;

    public static int TOTAL_POINTS_EXCHANGED;

    public static boolean canBurnWithBranch(Player c) {
        int currentItem = c.currentExchangeItem;
        boolean isFoeRewardItem = getExchangeShopPrice(currentItem) != Integer.MAX_VALUE;

        if (isFoeRewardItem) {
            c.sendMessage("You cannot burn this item with your ancient branch.");
            return false;
        }
        return true;
    }


    public static void exchangeItemForPoints(Player c) {
        if (Configuration.DISABLE_SS) {
            c.sendMessage("Shattered Shard Exchange has been temporarily disabled.");
            return;
        }
        c.objectYOffset = 5;
        c.objectXOffset = 5;
        c.objectDistance = 5;
        c.getQuesting().exchangeItemForPoints(c);
        if (c.currentExchangeItem == -1) {
            c.sendMessage("@red@You cannot exchange this item for shards.");
            return;
        }

        int exchangePrice = getBurnPrice(c, c.currentExchangeItem, true) * c.currentExchangeItemAmount;
        if (exchangePrice == -1) {
        	c.sendMessage("@red@You cannot exchange @blu@" + ItemAssistant.getItemName(c.currentExchangeItem) + " for @red@ shards.");
        	return;
		}

        if (!c.getItems().playerHasItem(c.currentExchangeItem)) {
            c.sendMessage("You no longer have this item on you.");
            return;
        }

        if (c.getMode().isIronmanType() && canBurnWithBranch(c)) {
                exchangePrice *= 1.10;
        }
        int itemAmount = c.currentExchangeItemAmount;
        c.getItems().deleteItem2(c.currentExchangeItem, itemAmount);
        c.getItems().addItem(6466, exchangePrice);
		TOTAL_POINTS_EXCHANGED += exchangePrice;
        List<Player> staff = PlayerHandler.nonNullStream().filter(Objects::nonNull).filter(p -> (p.getRights().isOrInherits(Right.OWNER)|| p.getRights().isOrInherits(Right.MODERATOR))).collect(Collectors.toList());
        Discord.writeServerSyncMessage("[Shattered Shards] "+ c.getDisplayName() +" burned " + ItemAssistant.getItemName(c.currentExchangeItem)
                +  " x" + c.currentExchangeItemAmount);
        Discord.writeFoeMessage("[Shattered Shards] "+ c.getDisplayName() +" burned " + ItemAssistant.getItemName(c.currentExchangeItem)
                +  " x" + c.currentExchangeItemAmount);
		if (TOTAL_POINTS_EXCHANGED >= 100000) {
			PlayerHandler.executeGlobalMessage("@bla@[@red@Shattered Shards@bla@]@blu@ Another @red@100,000@blu@ shards has been consumed by the mist!");
			TOTAL_POINTS_EXCHANGED = 0;
		}

        c.sendMessage("The mist takes your @blu@" + ItemAssistant.getItemName(c.currentExchangeItem) + "@bla@ and gives back @blu@" + Misc.formatCoins(exchangePrice) + " shards!");
        if (canBurnWithBranch(c)) {
        c.getEventCalendar().progress(EventChallenge.GAIN_X_EXCHANGE_POINTS, exchangePrice);
        }
        if (c.currentExchangeItem != 691 &&
                c.currentExchangeItem != 692 &&
                c.currentExchangeItem != 693 &&
                c.currentExchangeItem != 696 &&
                c.currentExchangeItem != 2399 &&
                c.currentExchangeItem != 21046 &&
                c.currentExchangeItem != 8866 &&
                c.currentExchangeItem != 8868) {
            Achievements.increase(c, AchievementType.FOE_POINTS, exchangePrice);
            c.totalEarnedExchangePoints += exchangePrice;
            if (exchangePrice > 20000) {
                PlayerHandler.executeGlobalMessage("@bla@[@red@Shattered Shards@bla@] @blu@"+c.getDisplayNameFormatted()+" burned a " + ItemAssistant.getItemName(c.currentExchangeItem) + " x" + c.currentExchangeItemAmount +
                        "@blu@ for @red@" + Misc.formatCoins(exchangePrice) + " shards.");

            }
        }
        Server.getLogging().write(new FireOfExchangeLog(c, new GameItem(c.currentExchangeItem, c.currentExchangeItemAmount)));
    }

    /**
     * Buying from shop price.
     */
    public static int getExchangeShopPrice(int id) {

        switch (id) {

            case 30010://postie pete
                return 25000;
            case 30011://imp
                return 30000;
            case 30012://toucan
                return 30000;
            case 30013://penguin king
                return 35000;
            case 30014://k'klik
                return 150000;
            case 30015://melee pet
                return 75000;
            case 30016://range pet
                return 75000;
            case 30017://mage pet
                return 75000;
            case 30018://healer
                return 80000;
            case 30019://holy
                return 80000;
            case 23939://corrupt beast
                return 100000;
            case 30020://corrupt beast
                return 500000;
            case 30021://roc
                return 500000;
            case 30022://yama
                return 1500000;
            case 23804://imbue dust
                return 15000;
            case 12783://row i scroll
                return 100000;
            case 21259://name change scroll
                return 35000;
            case 691://10k cert
                return 10000;
            case 692://25k cert
                return 25000;
            case 693://50k cert
                return 50000;
            case 696://250k cert
                return 250000;
            case 21046://chest rate increase
                return 850;
            case 8866://uim key
                return 250;
            case 8868://perm uim key
                return 10000;
            case 7629://double slayer points
                return 1250;
            case 24460://double clues
                return 2500;
            case 7968://pet rate increase
                return 4000;
            case Items.OVERLOAD_4://pet rate increase
                return 2000;
            case 1004://25m coins
                return 10000;
        }
        return Integer.MAX_VALUE;
    }


}
