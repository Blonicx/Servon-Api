package blonicx.servonapi.java.info;

import org.bukkit.Bukkit;

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
