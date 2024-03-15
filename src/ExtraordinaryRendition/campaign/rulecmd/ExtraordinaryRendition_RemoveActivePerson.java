package ExtraordinaryRendition.campaign.rulecmd;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.util.Misc;
import ExtraordinaryRendition.campaign.actions.definitions.steps.RemovePerson;

import java.util.List;
import java.util.Map;

public class ExtraordinaryRendition_RemoveActivePerson extends ExtraordinaryRenditionCommandPlugin {
    @Override
    public boolean execute(String ruleId, InteractionDialogAPI dialog, List<Misc.Token> params, Map<String, MemoryAPI> memoryMap) {
        //new RemovePerson().execute(getActivePerson(dialog), null);
        new RemovePerson().execute(Global.getSector().getPlayerFleet().getActivePerson(), null);
        return true;
    }
}
