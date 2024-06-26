package blonicx.servonapi.minecraft.messages.discord;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebhookMessages {
    public static void sendWebhookMessage(String message, String webhookUrl) {
        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            String jsonPayload = "{\"content\": \"" + message + "\"}";

            try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
                dos.write(jsonPayload.getBytes());
                dos.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                Bukkit.getLogger().warning("Failed to send webhook message. Response code: " + responseCode);
            }

            con.disconnect();
        } catch (Exception e) {
            Bukkit.getLogger().warning("Error sending webhook message: " + e.getMessage());
        }
    }

    public static void sendWebhookMessageWithUsername(String message, String webhookUrl, Player p) {
        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            String jsonPayload = "{\"content\": \"" + "[" + p.getName() + "] " + message + "\"}";

            try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
                dos.write(jsonPayload.getBytes());
                dos.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                Bukkit.getLogger().warning("Failed to send webhook message. Response code: " + responseCode);
            }

            con.disconnect();
        } catch (Exception e) {
            Bukkit.getLogger().warning("Error sending webhook message: " + e.getMessage());
        }
    }
}
