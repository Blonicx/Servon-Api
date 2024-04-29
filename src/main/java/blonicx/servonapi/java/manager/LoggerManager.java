package blonicx.servonapi.java.manager;

import org.bukkit.Bukkit;

import java.util.logging.Logger;

public class LoggerManager {
    static Logger logger = Bukkit.getLogger();

    public static void sendWarn(String warn){
        logger.warning(warn);
    }

    public static void sendInfo(String info){
        logger.info(info);
    }
}
