package io.runescape.model.cycleevent.impl;

import io.runescape.model.cycleevent.Event;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.Health;
import io.runescape.model.entity.HealthStatus;

public class VenomResistanceEvent extends Event<Entity> {

	public VenomResistanceEvent(Entity attachment, int ticks) {
		super("venom_resistance_event", attachment, ticks);
	}

	@Override
	public void execute() {
		super.stop();
		if (attachment == null) {
			return;
		}
		Health health = attachment.getHealth();
		health.removeNonsusceptible(HealthStatus.VENOM);
	}

}
