package ExtraordinaryRendition.campaign.rulecmd;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.impl.campaign.rulecmd.BaseCommandPlugin;

public abstract class ExtraordinaryRenditionCommandPlugin extends BaseCommandPlugin {

    private static org.apache.log4j.Logger log = Global.getLogger(ExtraordinaryRenditionCommandPlugin.class);

//    public PersonAPI getActivePerson() {
//        return getActivePerson(null);
//    }

    //pot: hold up, why is this getting a person from the fleet, am I smoking crack
    // TODO: find out what this actually does
    /*pot:
    *
    * so I check if the dialog target has a person, then I give a person from my fleet
    * what does that even mean
    * is this only supposed to work if the personapi is a prisoner/officer in my fleet
    * */

//    public PersonAPI getActivePerson(InteractionDialogAPI dialog) {
//        SectorEntityToken token = Global.getSector().getPlayerFleet();
//        if (dialog != null && dialog.getInteractionTarget() != null && dialog.getInteractionTarget().getActivePerson() != null) {
//            return token.getActivePerson();
//        }
//        else{
//            log.info("ExtraRe: PersonAPI doesn't have a SectorEntityToken attached, possible error.");
//            return null;
//        }
//
//    }

    //pot: for legal reasons, even though the above code is probably strictly better, will strip it out to stay within license.

}
