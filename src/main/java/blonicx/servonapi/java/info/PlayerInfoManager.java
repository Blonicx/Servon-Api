package blonicx.servonapi.java.info;

import org.bukkit.entity.Player;

import java.net.InetSocketAddress;

public class PlayerInfoManager {
    public static int playerPing(Player p){
        return p.getPing();
    }

    public static InetSocketAddress playerIp(Player p){
        return p.getAddress();
    }
}
