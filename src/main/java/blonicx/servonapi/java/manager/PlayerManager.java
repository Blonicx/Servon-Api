package blonicx.servonapi.java.manager;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerManager {
    public static void setHealth(Player p, double health){
        p.setHealth(health);
    }

    public static void setGameMode(Player p, GameMode gameMode){
        p.setGameMode(gameMode);
    }

    public static void teleportPlayer(Player p, Location loc){
        p.teleport(loc);
    }

    public static void restMaxHealth(Player p){
        p.setMaxHealth(20);
    }

    public static void setMaxHealth(Player p, double maxHealth){
        p.setMaxHealth(maxHealth);
    }
}
