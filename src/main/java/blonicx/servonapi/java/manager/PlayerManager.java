package blonicx.servonapi.java;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

public class PlayerManager {
    public static void setHealth(Player p, double health){
        p.setHealth(health);
    }

    public static void setMaxHealth(Player p, double maxHealth){
        p.setMaxHealth(maxHealth);
    }
}
