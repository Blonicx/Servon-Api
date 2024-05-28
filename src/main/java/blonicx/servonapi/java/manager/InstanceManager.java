package blonicx.servonapi.java.manager;

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
    public static void InstanceSpider(Location loc, Player p){
        p.getWorld().spawnEntity(loc, EntityType.SPIDER);
    }

    public static void InstancePig(Location loc, Player p){
        p.getWorld().spawnEntity(loc, EntityType.PIG);
    }

    public static void InstanceCow(Location loc, Player p){
        p.getWorld().spawnEntity(loc, EntityType.COW);
    }
    public static void InstanceSheep(Location loc, Player p){
        p.getWorld().spawnEntity(loc, EntityType.SHEEP);
    }

    public static void InstanceEnderDragon(Location loc, Player p){
        p.getWorld().spawnEntity(loc, EntityType.ENDER_DRAGON);
    }
}