package io.runescape.content.commands.test;

import io.runescape.content.commands.Command;
import io.runescape.content.skills.slayer.SlayerMaster;
import io.runescape.content.skills.slayer.Task;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;
import org.apache.commons.lang3.Range;

import java.util.Arrays;
import java.util.Optional;

public class Slayertask extends Command {
    @Override
    public void execute(Player player, String commandName, String input) {
        if (input.isEmpty()) {
            player.sendMessage("Wrong format [::slayertask the_nightmare]");
            return;
        }

        assert SlayerMaster.MASTERS != null;
        Optional<SlayerMaster> masterOptional = SlayerMaster.MASTERS.stream().filter(it -> Arrays.stream(it.getAvailable()).anyMatch(task -> task.getPrimaryName().equalsIgnoreCase(input))).findFirst();
        if (masterOptional.isEmpty()) {
            player.sendMessage("No slayer master with task: " + input);
            return;
        }

        SlayerMaster master = masterOptional.get();
        Optional<Task> task = Arrays.stream(master.getAvailable()).filter(it -> it.getPrimaryName().equalsIgnoreCase(input)).findFirst();

        if (task.isEmpty()) {
            player.sendMessage("Task not found.");
            return;
        }

        player.getSlayer().setMaster(master.getId());
        player.getSlayer().setTask(task);
        player.getSlayer().setTaskAmount(Misc.random(Range.between(task.get().getMinimum(), task.get().getMaximum())));
        player.sendMessage("Set slayer task to " + task.get().getPrimaryName() + " with master " + master.getId());
    }

    public Optional<String> getDescription() {
        return Optional.of("Assign yourself a slayer task [::slayertask master_id the_nightmare]");
    }
}
