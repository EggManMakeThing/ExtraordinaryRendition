package ExtraordinaryRendition.campaign.rulecmd;

import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.util.Misc;

import java.util.List;
import java.util.Map;

public class ExtraordinaryRendition_LevelUp extends ExtraordinaryRendition.campaign.rulecmd.ExtraordinaryRenditionCommandPlugin {
    @Override
    public boolean execute(String ruleId, InteractionDialogAPI dialog, List<Misc.Token> params, Map<String, MemoryAPI> memoryMap) {
        PersonAPI person = getActivePerson(dialog);
        person.getStats().setLevel(person.getStats().getLevel() + 1);
        person.getStats().setPoints(person.getStats().getPoints() + 1);
        return true;
    }
}
