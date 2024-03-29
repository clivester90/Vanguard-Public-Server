package io.runescape.content.skills.fletching;

import io.runescape.content.skills.Skill;
import io.runescape.model.cycleevent.Event;
import io.runescape.model.entity.player.Player;

public class StringCrossbowEvent extends Event<Player> {

	private final FletchableCrossbow crossbow;

	public StringCrossbowEvent(FletchableCrossbow b, Player attachment, int ticks) {
		super("skilling", attachment, ticks);
		this.crossbow = b;
	}

	@Override
	public void execute() {
		if (attachment == null || attachment.isDisconnected() || attachment.getSession() == null) {
			stop();
			return;
		}
		if (!attachment.getItems().playerHasItem(crossbow.getItem()) || !attachment.getItems().playerHasItem(9438)) {
			stop();
			return;
		}
		attachment.startAnimation(crossbow.getAnimation());
		attachment.getItems().deleteItem2(crossbow.getItem(), 1);
		attachment.getItems().deleteItem2(9438, 1);
		attachment.getItems().addItem(crossbow.getProduct(), 1);
		attachment.getPA().addSkillXP((int) crossbow.getExperience(), Skill.FLETCHING.getId(), true);
	}

	@Override
	public void stop() {
		super.stop();
		if (attachment == null || attachment.isDisconnected() || attachment.getSession() == null) {
			return;
		}
		attachment.stopAnimation();
	}

}
