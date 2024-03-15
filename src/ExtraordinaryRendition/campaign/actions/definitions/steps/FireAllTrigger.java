package ExtraordinaryRendition.campaign.actions.definitions.steps;

import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.impl.campaign.rulecmd.FireAll;
import ExtraordinaryRendition.campaign.actions.definitions.StepExecutor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FireAllTrigger implements ExtraordinaryRendition.campaign.actions.definitions.StepExecutor.Step {
    private final InteractionDialogAPI dialog;
    private final String trigger;

    @Override
    public boolean canShow(PersonAPI person) {
        return true;
    }

    @Override
    public boolean canUse(PersonAPI person) {
        return true;
    }

    @Override
    public void execute(PersonAPI person, StepExecutor executor) {
        FireAll.fire(null, dialog, dialog.getPlugin().getMemoryMap(), trigger);
    }
}
