package ExtraordinaryRendition.campaign.rulecmd;

import ExtraordinaryRendition.campaign.actions.definitions.ExecuteAction;
import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.util.Misc;

import java.util.List;
import java.util.Map;

public class ExtraordinaryRendition_ExecuteActivePerson extends ExtraordinaryRendition.campaign.rulecmd.ExtraordinaryRenditionCommandPlugin {
    @Override
    public boolean execute(String ruleId, InteractionDialogAPI dialog, List<Misc.Token> params, Map<String, MemoryAPI> memoryMap) {
        new ExecuteAction(dialog).execute(getActivePerson(dialog));

        return true;
    }
}
