package ExtraordinaryRendition.utils;

import ExtraordinaryRendition.config.FactionConfigurationLoader;
import org.magiclib.util.MagicSettings;

public class Settings {
    private static int maxPrisoners = -1;

    public static int getMaxPrisoners() {
        return maxPrisoners;
    }


    public static void reloadMaxPrisoners() {
        maxPrisoners = MagicSettings.getInteger("ExtraordinaryRendition", "maxPrisoners");
    }

    public static void reloadSettings() {
        Settings.reloadMaxPrisoners();
        FactionConfigurationLoader.load();
    }
}
