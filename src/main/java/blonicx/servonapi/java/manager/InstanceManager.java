package blonicx.servonapi.java;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class InstanceManager {
    public static void InstanceZombie(Location loc, Player p){
        p.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
    }

    public static void InstanceSkeleton(Location loc, Player p){
        p.getWorld().spawnEntity(loc, EntityType.SKELETON);
    }
}