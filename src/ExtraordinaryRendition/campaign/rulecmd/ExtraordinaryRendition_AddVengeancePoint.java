package ExtraordinaryRendition.campaign.rulecmd;

import ExtraordinaryRendition.campaign.VengeanceFleetHandler;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.util.Misc;

import java.util.List;
import java.util.Map;

public class ExtraordinaryRendition_AddVengeancePoint extends ExtraordinaryRenditionCommandPlugin {
    @Override
    public boolean execute(
            String ruleId,
            InteractionDialogAPI dialog,
            List<Misc.Token> params,
            Map<String, MemoryAPI> memoryMap) {
//        String factionId = getActivePerson(dialog).getFaction().getId();
        String factionId = Global.getSector().getPlayerFleet().getActivePerson().getFaction().getId();

        VengeanceFleetHandler.INSTANCE.addVengeancePoint(factionId);
        return true;
    }
}