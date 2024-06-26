package blonicx.servonapi.minecraft.anticheat;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerValues {
    public static float getPlayerSpeed(Player p){
        return p.getWalkSpeed();
    }

    public static double getPlayerHealth(Player p){
        return p.getHealth();
    }

    public static double getPlayerMaxHealth(Player p){
        return p.getMaxHealth();
    }

    public static Location getPlayerLocation(Player p){
        return  p.getLocation();
    }

    public static int getPlayerLevel(Player p){
        return p.getLevel();
    }
}
