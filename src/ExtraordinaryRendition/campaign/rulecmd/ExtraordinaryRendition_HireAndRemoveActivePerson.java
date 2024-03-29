package ExtraordinaryRendition.campaign.rulecmd;

import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.util.Misc;
import ExtraordinaryRendition.ExtraordinaryRenditionModPlugin;
import ExtraordinaryRendition.campaign.actions.definitions.HireAction;
import ExtraordinaryRendition.campaign.actions.definitions.steps.RemovePerson;

import java.util.List;
import java.util.Map;

public class ExtraordinaryRendition_HireAndRemoveActivePerson extends ExtraordinaryRendition.campaign.rulecmd.ExtraordinaryRenditionCommandPlugin {
    @Override
    public boolean execute(String ruleId, InteractionDialogAPI dialog, List<Misc.Token> params, Map<String, MemoryAPI> memoryMap) {
        PersonAPI person = getActivePerson(dialog);

        HireAction action = new HireAction(dialog);
        action.execute(person);
        new RemovePerson().execute(person, action);

        return true;
    }
}
