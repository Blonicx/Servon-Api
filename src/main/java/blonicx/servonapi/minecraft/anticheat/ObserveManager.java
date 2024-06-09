package blonicx.servonapi.minecraft.anticheat;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ObserveManager {
    public static void observePlayer(Player observer, Player playertospactate){
        observer.teleport(playertospactate);
    }

    public static void seeInventory(Player observer, Player playertospactate){
        Inventory inv = playertospactate.getInventory();
        observer.openInventory(inv);
    }
}