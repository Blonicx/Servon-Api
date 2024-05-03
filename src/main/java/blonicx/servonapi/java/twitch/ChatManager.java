package blonicx.servonapi.java.twitch;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

public class ChatManager {
    public static String getChetMsg(String oAuthToken, String ChannelName){
        OAuth2Credential credential = new OAuth2Credential("twitch", oAuthToken);
        StringBuilder lastMessage = new StringBuilder();

        TwitchClient twitchClient = TwitchClientBuilder.builder()
                .withEnableChat(true)
                .withChatAccount(credential)
                .build();

        twitchClient.getChat().joinChannel(ChannelName);

        twitchClient.getEventManager().onEvent(ChannelMessageEvent.class, event -> {
            lastMessage.setLength(0);
            lastMessage.append(event.getMessage());
        });

        return lastMessage.toString();
    }
}
