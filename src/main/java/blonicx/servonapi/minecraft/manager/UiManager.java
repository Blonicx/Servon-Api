package blonicx.servonapi.minecraft.manager;

import org.bukkit.entity.Player;

public class UiManager {
    public class BukkitUI{
        public static void setPlayerTabFooter(Player p, String text){
            p.setPlayerListFooter(text);
        }

        public static void setPlayerTabHeader(Player p, String text){
            p.setPlayerListHeader(text);
        }
    }

    public class ServonUI{
        //Todo #1.1: Add ServonUI or add a way to implement UI like text or buttons
        //Todo #1.2: Add Fabric Compability or UI Designer for UI
    }
}
