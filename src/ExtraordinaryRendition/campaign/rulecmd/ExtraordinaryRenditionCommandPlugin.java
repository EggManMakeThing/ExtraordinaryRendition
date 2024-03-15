package ExtraordinaryRendition.campaign.rulecmd;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.impl.campaign.rulecmd.BaseCommandPlugin;

public abstract class ExtraordinaryRenditionCommandPlugin extends BaseCommandPlugin {

    private static org.apache.log4j.Logger log = Global.getLogger(ExtraordinaryRenditionCommandPlugin.class);

    public PersonAPI getInteractionTargetPerson() {
        return getInteractionTargetPerson(null);
    }

    public PersonAPI getInteractionTargetPerson(InteractionDialogAPI dialog) {
        SectorEntityToken token = Global.getSector().getPlayerFleet();
        if (dialog != null && dialog.getInteractionTarget() != null && dialog.getInteractionTarget().getActivePerson() != null) {
            return token.getActivePerson();
        }
        else{
            log.info("ExtraRe: PersonAPI doesn't have a SectorEntityToken attached, possible error.");
        }

    }
}
