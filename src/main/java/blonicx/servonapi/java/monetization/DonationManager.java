package blonicx.servonapi.java.monetization;

import org.bukkit.entity.Player;

public class DonationManager {
    public static void DonationLink(String Msg, String DonationUrl, Player p){
        p.sendMessage(Msg + DonationUrl);
    }
}