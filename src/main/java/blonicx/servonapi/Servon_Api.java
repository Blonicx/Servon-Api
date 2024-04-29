package blonicx.servonapi;

import blonicx.servonapi.java.cheating.CheatManager;
import blonicx.servonapi.java.cheating.PlayerValues;
import blonicx.servonapi.java.discord.RpcManager;
import blonicx.servonapi.java.discord.WebhookManager;
import blonicx.servonapi.java.info.PlayerInfoManager;
import blonicx.servonapi.java.info.ServerInfoManager;
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

    //Instances of Discord//
    private RpcManager rpcManager;
    private WebhookManager webhookManager;

    //Instances of Infos//
    private PlayerInfoManager playerInfoManager;
    private ServerInfoManager serverInfoManager;

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
        //Instances of Infos//
        serverInfoManager = new ServerInfoManager();
        playerInfoManager = new PlayerInfoManager();

        //Instances of Discord//
        rpcManager = new RpcManager();
        webhookManager = new WebhookManager();

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
            //Load Classes if loaded by Servon
            Instance();
        }
        else{
            //Error if not loaded by Servon
            logger.warning("Not loaded by ServonLoader!");
            Bukkit.getServer().getPluginManager().disablePlugin(plugin);
        }
    }
}
