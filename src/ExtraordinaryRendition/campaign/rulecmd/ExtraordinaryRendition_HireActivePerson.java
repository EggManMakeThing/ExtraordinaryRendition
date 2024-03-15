package ExtraordinaryRendition.campaign.rulecmd;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.util.Misc;
import ExtraordinaryRendition.campaign.actions.definitions.HireAction;

import java.util.List;
import java.util.Map;

public class ExtraordinaryRendition_HireActivePerson extends ExtraordinaryRenditionCommandPlugin {
    @Override
    public boolean execute(String ruleId, InteractionDialogAPI dialog, List<Misc.Token> params, Map<String, MemoryAPI> memoryMap) {
        //new HireAction(dialog).execute(getActivePerson(dialog));

        new HireAction(dialog).execute(Global.getSector().getPlayerFleet().getActivePerson());
        return true;
    }
}
