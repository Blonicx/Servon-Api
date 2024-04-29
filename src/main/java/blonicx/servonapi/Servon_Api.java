package blonicx.servonapi;

import blonicx.servonapi.java.cheating.CheatManager;
import blonicx.servonapi.java.cheating.PlayerValues;
import blonicx.servonapi.java.manager.LoggerManager;
import blonicx.servonapi.java.manager.InstanceManager;
import blonicx.servonapi.java.manager.PlayerManager;
import blonicx.servonapi.java.monetization.AdsManager;
import blonicx.servonapi.java.monetization.DonationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public final class Servon_Api extends JavaPlugin {

    Logger logger = getLogger();

    Plugin plugin = this;

    File pluginFile = getFile();
    String pluginFilePath = pluginFile.getPath();

    //Instances of Managers//
    private InstanceManager instanceManager;
    private PlayerManager playerManager;
    private LoggerManager loggerManager;

    //Instance of CheatingManagers//
    private CheatManager cheatManager;
    private PlayerValues playerValues;

    //Instance of Monetization//
    private AdsManager adsManager;
    private DonationManager donationManager;

    //Instance//
    void Instance(){
        //Instance of Managers//
        instanceManager = new InstanceManager();
        playerManager = new PlayerManager();
        loggerManager = new LoggerManager();

        //Instance of CheatingManagers//
        cheatManager = new CheatManager();
        playerValues = new PlayerValues();

        //Instance of Monetization//
        adsManager = new AdsManager();
        donationManager = new DonationManager();
    }

    //Check for Loader//
    private boolean isLoadedByServon(){
        if (pluginFilePath.contains("ServonLoader")){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void onEnable() {
        //Check for Servon Load
        if(isLoadedByServon() == true) {
            Instance();
        }
        else{
            //Error if not loaded by Servon
            logger.warning("Not loaded by ServonLoader!");
            Bukkit.getServer().getPluginManager().disablePlugin(plugin);
        }
    }
}
