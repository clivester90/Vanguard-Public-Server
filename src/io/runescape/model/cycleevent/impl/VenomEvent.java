package io.runescape.model.cycleevent.impl;

import java.util.Optional;

import io.runescape.content.combat.Hitmark;
import io.runescape.model.cycleevent.Event;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.Health;
import io.runescape.model.entity.HealthStatus;

public class VenomEvent extends Event<Entity> {

	private int damage;

	private final Optional<Entity> inflictor;

	public VenomEvent(Entity attachment, int damage, Optional<Entity> inflictor) {
		super("health_status", attachment, 33);
		this.damage = damage;
		this.inflictor = inflictor;
	}

	@Override
	public void execute() {
		if (attachment == null) {
			super.stop();
			return;
		}

		Health health = attachment.getHealth();

		if (health.isNotSusceptibleTo(HealthStatus.VENOM)) {
			super.stop();
			return;
		}

		if (attachment.getHealth().getCurrentHealth() <= 0) {
			super.stop();
			return;
		}

		attachment.appendDamage(null, damage, Hitmark.VENOM);
		inflictor.ifPresent(inf -> attachment.addDamageTaken(inf, damage));

		damage += 2;

		if (damage > 20) {
			damage = 20;
		}
	}

}
