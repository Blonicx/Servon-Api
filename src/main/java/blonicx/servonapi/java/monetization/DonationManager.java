package blonicx.servonapi.java.monetization;

import org.bukkit.entity.Player;

public class DonationManager {
    public static void PatreonDonation(String Msg, String DonationUrl, Player p){
        p.sendMessage(Msg + DonationUrl);
    }
}
