package io.runescape.content.dialogue.impl;

import io.runescape.content.dialogue.DialogueBuilder;
import io.runescape.content.dialogue.DialogueOption;
import io.runescape.model.entity.player.Player;

public class SkillingPortalDialogue extends DialogueBuilder {



    public SkillingPortalDialogue(Player player) {
        super(player);
        setNpcId(-1)
                .option(new DialogueOption("Skilling Island", p -> player.getPA().startTeleport(3803, 3538, 0, "modern", false)),
                        new DialogueOption("Hunter Area", p -> player.getPA().startTeleport(3560, 4010, 0, "modern", false)),
                        new DialogueOption("Farming", p -> player.getPA().startTeleport(3053, 3301, 0, "modern", false)));

    }
}
