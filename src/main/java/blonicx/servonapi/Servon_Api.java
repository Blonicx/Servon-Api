package blonicx.servonapi;

//Custom Imports//
import blonicx.servonapi.minecraft.anticheat.CheatManager;
import blonicx.servonapi.minecraft.anticheat.PlayerValues;
import blonicx.servonapi.minecraft.discord.RpcManager;
import blonicx.servonapi.minecraft.messages.discord.WebhookMessages;
import blonicx.servonapi.minecraft.info.PlayerInfoManager;
import blonicx.servonapi.minecraft.info.ServerInfoManager;
import blonicx.servonapi.minecraft.manager.LoggerManager;
import blonicx.servonapi.minecraft.manager.InstanceManager;
import blonicx.servonapi.minecraft.manager.PlayerManager;
import blonicx.servonapi.minecraft.messages.minecraft.ChatMessages;
import blonicx.servonapi.minecraft.manager.UiManager;

//Servon Utils Imports//
import blonicx.servonapi.util.Servon_Api_Util;

//ServonNetwork Imports//
import blonicx.servonapi.servon_network.Database;

//Bukkit Imports//
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Servon_Api extends JavaPlugin {

    Logger logger = getLogger();

    //Instances of ServonNetwork//
    private Database database;

    //Instance of Utils//
    private Servon_Api_Util servonApiUtil;

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

        //Instances of ServonNetwork//
        database = new Database();

        //Instance of Utils//
        servonApiUtil = new Servon_Api_Util();

        //Instance of Messages//
        chatMessages = new ChatMessages();
    }

    @Override
    public void onEnable() {
        Instance();
        logger.info("Servon-Api got Loaded");
    }
}
