package io.runescape.content.shooting_star;



import io.runescape.Configuration;
import io.runescape.Server;
import io.runescape.model.cycleevent.CycleEvent;
import io.runescape.model.cycleevent.CycleEventContainer;
import io.runescape.model.cycleevent.CycleEventHandler;
import io.runescape.model.entity.player.broadcasts.Broadcast;
import io.runescape.model.world.objects.GlobalObject;
import io.runescape.util.Misc;
import io.runescape.util.discord.Discord;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author C.T for koranes
 *
 */

public class ShootingStar {


public static boolean spawned = false;

private static ShootingStarLocation[] locations = {new ShootingStarLocation(3195, 3436, "Varrock bank", "next to"),};

private static ShootingStarLocation currentLocation;

private static ShootingStarLocation currentHint;
		
private static String name;

private static CycleEvent cycleEvent;

private static CycleEventContainer cycleEventContainer;

public static int lastX = -1;
public static int lastY = -1;



public static void spawnShootingStar() {


	cycleEvent = new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container) {
			if(spawned == true) {
				return;
			}
			container.setTick(Misc.toCycles(60, TimeUnit.MINUTES));
			if(getCurrentLocation() != null) {
				destroyLocation();
				Configuration.STAR_EVENT_TIMER = ShootingStar.generateTime();
				return;
			}
			container.setTick(generateTime());
		    spawnStar();
			Configuration.STAR_EVENT_TIMER = ShootingStar.generateTime();
		}
	};
	setCycleEventContainer(CycleEventHandler.getSingleton().addEvent(ShootingStar.class, cycleEvent, generateTime()));
}


public static int generateTime(){
		return Misc.toCycles(60, TimeUnit.MINUTES);
	}

public static void destroyLocation() {
	if(getCurrentLocation() == null)
		return;
	List<ShootingStarLocation> locationsList = Arrays.asList(locations);
	ShootingStarLocation randomLocation = Misc.randomTypeOfList(locationsList);
	currentLocation = randomLocation;
	lastX = randomLocation.getX();
	lastY = randomLocation.getY();
	ShootingStar.setCurrentLocation(null);
	Server.getGlobalObjects().add(new GlobalObject(-1, randomLocation.getX(), randomLocation.getY(), 0, 0, 10, -1, -1));
	spawned = false;

}

public static void spawnStar() {

	List<ShootingStarLocation> locationsList = Arrays.asList(locations);
	ShootingStarLocation randomLocation = Misc.randomTypeOfList(locationsList);
	currentLocation = randomLocation;
	lastX = randomLocation.getX();
	lastY = randomLocation.getY();
	Server.getGlobalObjects().add(new GlobalObject(41020, randomLocation.getX(), randomLocation.getY(), 0, 0, 10, -1, -1));
	spawned = true;
	Server.amountMined = 0;
	new Broadcast("@cr20@ A shooting star has just crashed " + randomLocation.getHint() +" " + randomLocation.getLocationName() + "!").copyMessageToChatbox().submit();
	Discord.writeEventMessage("A shooting star has just crashed " + randomLocation.getHint() +" " + randomLocation.getLocationName() + "!");
    }

public static CycleEventContainer getCycleEventContainer() {
		return cycleEventContainer;
	}

public static void setCycleEventContainer(CycleEventContainer cycleEventContainer) {
	ShootingStar.cycleEventContainer = cycleEventContainer;
}


public static ShootingStarLocation getCurrentLocation() {
	return currentLocation;
}

public static void setCurrentLocation(ShootingStarLocation currentLocation) {
	ShootingStar.currentLocation = currentLocation;
}

public static String getName() {
	return name;
}

}

