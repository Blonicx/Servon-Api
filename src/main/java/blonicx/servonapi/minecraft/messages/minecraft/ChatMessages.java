package blonicx.servonapi.minecraft.messages.minecraft;

import org.bukkit.entity.Player;

public class ChatMessages {
    public static void sendMessage(Player p, String msg){
        p.sendMessage(msg);
    }
}
