package blonicx.servonapi.java.monetization;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class AdsManager implements Listener {
    public static void ChatAd(String adLink, Player p){
        p.sendMessage(ChatColor.YELLOW + "Visit our Partner here: " + ChatColor.GRAY + "[" + ChatColor.GREEN + adLink + ChatColor.GRAY + "]");
    }
}