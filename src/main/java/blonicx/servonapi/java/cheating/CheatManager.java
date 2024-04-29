package blonicx.servonapi.java.cheating;

import org.bukkit.entity.Player;

public class CheatManager {
    public static void kickPlayer(Player p, String reason){
        p.kickPlayer(reason);
    }

    public static void banPlayer(Player p, String reason){
        p.banPlayer(reason);
    }

    public static void sendWarning(Player p, String warning){
        p.sendMessage(warning);
    }

    public static void clearPlayerInventory(Player p){
        p.getInventory().clear();
    }

    public static void killPlayer(Player p){
        p.setHealth(0);
    }
}
