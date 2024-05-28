package blonicx.servonapi.java.info;

import org.bukkit.entity.Player;

import java.net.InetSocketAddress;

public class PlayerInfoManager {
    public static int playerPing(Player p){
        return p.getPing();
    }

    public static String playerName(Player p){
        return p.getName();
    }

    public static long getPlayTime(Player p{
        return p.getPlayerTime();
    }

    public static InetSocketAddress playerIp(Player p){
        return p.getAddress();
    }
}
