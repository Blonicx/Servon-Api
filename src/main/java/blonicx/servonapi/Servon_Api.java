package blonicx.servonapi;

//Imports//
import blonicx.servonapi.java.anticheat.CheatManager;
import blonicx.servonapi.java.anticheat.PlayerValues;
import blonicx.servonapi.java.discord.RpcManager;
import blonicx.servonapi.java.messages.discord.WebhookMessages;
import blonicx.servonapi.java.info.PlayerInfoManager;
import blonicx.servonapi.java.info.ServerInfoManager;
import blonicx.servonapi.java.manager.LoggerManager;
import blonicx.servonapi.java.manager.InstanceManager;
import blonicx.servonapi.java.manager.PlayerManager;

//Bukkit Imports//
import blonicx.servonapi.java.messages.minecraft.ChatMessages;
import blonicx.servonapi.java.manager.UiManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Servon_Api extends JavaPlugin {

    Logger logger = getLogger();

    //Instances of Discord//
    private RpcManager rpcManager;
    private WebhookMessages webhookMessages;

    //Instances of Infos//
    private PlayerInfoManager playerInfoManager;
    private ServerInfoManager serverInfoManager;

    //Instances of Managers//
    private InstanceManager instanceManager;
    private PlayerManager playerManager;
    private LoggerManager loggerManager;
    private UiManager uiManager;

    //Instance of CheatingManagers//
    private CheatManager cheatManager;
    private PlayerValues playerValues;

    //Instance of Messages//
    private ChatMessages chatMessages;

    //Instance//
    void Instance(){
        //Instances of Infos//
        serverInfoManager = new ServerInfoManager();
        playerInfoManager = new PlayerInfoManager();

        //Instances of Discord//
        rpcManager = new RpcManager();
        webhookMessages = new WebhookMessages();

        //Instance of Managers//
        instanceManager = new InstanceManager();
        playerManager = new PlayerManager();
        loggerManager = new LoggerManager();
        uiManager = new UiManager();

        //Instance of AntiCheat//
        cheatManager = new CheatManager();
        playerValues = new PlayerValues();

        //Instance of Messages//
        chatMessages = new ChatMessages();
    }

    @Override
    public void onEnable() {
        Instance();
        logger.info("Servon-Api got Loaded");
    }
}
