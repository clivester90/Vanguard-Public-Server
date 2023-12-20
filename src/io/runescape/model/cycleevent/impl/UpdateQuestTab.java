package io.runescape.model.cycleevent.impl;

import java.util.concurrent.TimeUnit;

import io.runescape.model.cycleevent.Event;
import io.runescape.model.entity.player.PlayerHandler;
import io.runescape.util.Misc;

public class UpdateQuestTab extends Event<Object> {


	private static final int INTERVAL = Misc.toCycles(5, TimeUnit.SECONDS);

	
	public UpdateQuestTab() {
		super("", new Object(), INTERVAL);
	}	

	@Override
	public void execute() {
		PlayerHandler.nonNullStream().forEach(player -> player.getQuestTab().updateInformationTab());
	}
} 