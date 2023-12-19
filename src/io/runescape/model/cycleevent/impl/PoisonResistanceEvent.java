package io.runescape.model.cycleevent.impl;

import io.runescape.model.cycleevent.Event;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.Health;
import io.runescape.model.entity.HealthStatus;

public class PoisonResistanceEvent extends Event<Entity> {

	public PoisonResistanceEvent(Entity attachment, int ticks) {
		super("poison_resistance_event", attachment, ticks);
	}

	@Override
	public void execute() {
		if (attachment == null) {
			super.stop();
			return;
		}
		super.stop();

		Health health = attachment.getHealth();
		health.removeNonsusceptible(HealthStatus.POISON);
	}

}
