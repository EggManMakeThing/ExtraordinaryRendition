package ExtraordinaryRendition.campaign.listeners;

import ExtraordinaryRendition.ExtraordinaryRenditionModPlugin;
import ExtraordinaryRendition.config.FactionConfiguration;
import ExtraordinaryRendition.config.FactionConfigurationLoader;
import ExtraordinaryRendition.utils.Strings;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.BaseCampaignEventListener;
import com.fs.starfarer.api.campaign.EngagementResultForFleetAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.combat.DeployedFleetMemberAPI;
import com.fs.starfarer.api.combat.EngagementResultAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class CampaignEventListener extends BaseCampaignEventListener {

    public CampaignEventListener(boolean permaRegister) {
        super(permaRegister);
    }

    @Override
    public void reportPlayerEngagement(EngagementResultAPI result) {
        EngagementResultForFleetAPI loserSide = result.getLoserResult();

        if (loserSide.isPlayer()) {
            return;
        }

        if (loserSide.getFleet().getMemoryWithoutUpdate().getBoolean("$ziggurat")) {
            return;
        }

        if (loserSide.getAllEverDeployedCopy() == null) return;

        FactionConfiguration config = FactionConfigurationLoader.getFactionConfig(loserSide.getFleet().getFaction().getId());
        if (config == null) return;

        log.info("ExtraRe - Engagement ended. Processing enemy fleet now.");


        PersonAPI fleetCommander = loserSide.getFleet().getCommander();

        if (loserSide.getFleet().getMemoryWithoutUpdate().contains(Strings.ENEMY_FLEET_PRISONERS_MEMKEY)) {
            List<PersonAPI> persons = (List<PersonAPI>) loserSide.getFleet().getMemoryWithoutUpdate().get(Strings.ENEMY_FLEET_PRISONERS_MEMKEY);

            for (PersonAPI person : persons) {
                person.getMemoryWithoutUpdate().set(Strings.FORCE_CAPTURE_TAG, true);
                ExtraordinaryRenditionModPlugin.addPerson(person);
            }

            loserSide.getFleet().getMemoryWithoutUpdate().unset(Strings.ENEMY_FLEET_PRISONERS_MEMKEY);
        }

        for (DeployedFleetMemberAPI deployedMember : loserSide.getAllEverDeployedCopy()) {
            FleetMemberAPI member = deployedMember.getMember();
            if (member == null) continue;

            PersonAPI captain = member.getCaptain();

            float recoveryChance = config.getCaptureChance();
            if (loserSide.getDestroyed().contains(member)) {
                recoveryChance *= 0.5f;
            } else if (loserSide.getRetreated().contains(member)) {
                recoveryChance *= 0f;
            }

            boolean isCommander = captain.equals(fleetCommander);
            if (canCapture(captain, config, isCommander)) {
                if ((isCommander && config.getCommanderForcedCapture() && recoveryChance > 0f)
                        || Math.random() <= recoveryChance) {

                    if (isCommander) {
                        log.info("ExtraRe - Added enemy fleet commander as prisoner.");
                    } else {
                        log.info("ExtraRe - Added enemy officer as prisoner.");
                    }
                    ExtraordinaryRenditionModPlugin.addPerson(captain);
                }
            }
        }
    }

    private boolean canCapture(PersonAPI person, FactionConfiguration config, boolean isCommander) {
        if (person != null) {
            if (person.isDefault()) {
                return false;
            }

            if (person.equals(Global.getSector().getPlayerPerson())) {
                return false;
            }

            if (person.hasTag(Strings.NO_CAPTURE_TAG)) {
                log.info("ExtraRe - Person has blocking capture tag.");
                return false;
            }

            if (person.hasTag(Strings.FORCE_CAPTURE_TAG)) {
                log.info("ExtraRe - Person has force capture tag.");
                return true;
            }

            if (Global.getSector().getImportantPeople().getPerson(person.getId()) != null) {
                log.info("ExtraRe - Person was important.");
                return false;
            }

            if (person.isAICore()) {
                return false;
            }

            return config != null && ((isCommander && config.getCapturesCommanders()) || config.getCapturesOfficers());
        }
        return false;
    }
}
