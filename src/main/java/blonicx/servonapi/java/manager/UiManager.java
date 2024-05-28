package blonicx.servonapi.java.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class UiManager {
    public static void setPlayerTabFooter(Player p, String text){
        p.setPlayerListFooter(text);
    }

    public static void setPlayerTabHeader(Player p, String text){
        p.setPlayerListHeader(text);
    }
}
