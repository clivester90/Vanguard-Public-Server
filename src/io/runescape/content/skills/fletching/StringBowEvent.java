package io.runescape.content.skills.fletching;

import io.runescape.content.achievement_diary.impl.KandarinDiaryEntry;
import io.runescape.content.dailytasks.DailyTasks;
import io.runescape.content.skills.Skill;
import io.runescape.model.cycleevent.Event;
import io.runescape.model.entity.player.Boundary;
import io.runescape.model.entity.player.Player;

public class StringBowEvent extends Event<Player> {

	private final FletchableBow bow;

	public StringBowEvent(FletchableBow bow, Player attachment, int ticks) {
		super("skilling", attachment, ticks);
		this.bow = bow;
	}

	@Override
	public void execute() {
		if (attachment == null || attachment.isDisconnected() || attachment.getSession() == null) {
			stop();
			return;
		}
		if (!attachment.getItems().playerHasItem(bow.getItem()) || !attachment.getItems().playerHasItem(1777)) {
			stop();
			return;
		}
		switch (bow.getProduct()) {
		case 853:
			if (Boundary.isIn(attachment, Boundary.SEERS_BOUNDARY)) {
				attachment.getDiaryManager().getKandarinDiary().progress(KandarinDiaryEntry.STRING_MAPLE_SHORT);
			}
			break;

		case 857:
			DailyTasks.increase(attachment, DailyTasks.PossibleTasks.YEW_SHORTBOWS);
			break;
			
		case 859:
			if (Boundary.isIn(attachment, Boundary.LLETYA_BOUNDARY)) {
			}
			break;
		}
		attachment.startAnimation(bow.getAnimation());
		attachment.getItems().deleteItem2(bow.getItem(), 1);
		attachment.getItems().deleteItem2(1777, 1);
		attachment.getItems().addItem(bow.getProduct(), 1);
		attachment.getPA().addSkillXP((int) bow.getExperience(), Skill.FLETCHING.getId(), true);
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
