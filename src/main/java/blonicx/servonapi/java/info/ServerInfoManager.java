package blonicx.servonapi.java.info;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

public class ServerInfoManager {
    public static int serverPort(){
        return Bukkit.getServer().getPort();
    }

    public static String serverIp(){
        return Bukkit.getServer().getIp();
    }

    public static int maxPlayer(){
        return Bukkit.getMaxPlayers();
    }
}
