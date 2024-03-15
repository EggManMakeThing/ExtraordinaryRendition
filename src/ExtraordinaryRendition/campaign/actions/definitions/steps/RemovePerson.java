package ExtraordinaryRendition.campaign.actions.definitions.steps;

import ExtraordinaryRendition.campaign.actions.definitions.StepExecutor;
import ExtraordinaryRendition.ExtraordinaryRenditionModPlugin;
import ExtraordinaryRendition.ui.PrisonersDialogDelegate;
import com.fs.starfarer.api.characters.PersonAPI;

public class RemovePerson implements ExtraordinaryRendition.campaign.actions.definitions.StepExecutor.Step {
    @Override
    public void execute(PersonAPI person, StepExecutor executor) {
        ExtraordinaryRenditionModPlugin.removePerson(person);

        if (PrisonersDialogDelegate.getInst() != null) {
            PrisonersDialogDelegate.getInst().removePerson(person, executor);
        }
    }


    @Override
    public boolean canShow(PersonAPI person) {
        return true;
    }

    @Override
    public boolean canUse(PersonAPI person) {
        return true;
    }
}
