package blonicx.servonapi.java.monetization;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AdsManager {
    public static void ChatAd(String adLink, Player p){
        p.sendMessage(ChatColor.YELLOW + "Visit our Sponsor here: " + ChatColor.GRAY + "[" + ChatColor.GREEN + adLink + ChatColor.GRAY + "]");
    }
}