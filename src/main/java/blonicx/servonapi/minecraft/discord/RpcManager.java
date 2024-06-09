package blonicx.servonapi.minecraft.discord;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class RpcManager {

    private static DiscordRPC discordRPC;
    private static DiscordRichPresence presence;


    public static void createRpc(String applicationId, String details) {
        // Initialize Discord RPC
        discordRPC = DiscordRPC.INSTANCE;
        DiscordEventHandlers handlers = new DiscordEventHandlers();

        //Check for appId and if no appId use the Servon-Api app
        if(applicationId == ""){
            discordRPC.Discord_Initialize("1237097724625551391", handlers, true, "");
        }else {
            discordRPC.Discord_Initialize(applicationId, handlers, true, "");
        }

        // Set initial presence
        presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        presence.details = details;
        discordRPC.Discord_UpdatePresence(presence);
    }

    public static void updateRpc(String details){
        //Set new presence
        presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        presence.details = details;
        discordRPC.Discord_UpdatePresence(presence);
    }
}
