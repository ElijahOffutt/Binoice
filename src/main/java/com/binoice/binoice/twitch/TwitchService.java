package com.binoice.binoice.twitch;

import com.binoice.binoice.twitch.TwitchProperties;

import org.springframework.stereotype.Service;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.chat.events.channel.ChannelJoinEvent;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

import jakarta.annotation.PostConstruct;

@Service
public class TwitchService {
    
    private final TwitchClient twitchClient;
    private final TwitchProperties twitchProperties;

    public TwitchService(
        TwitchClient twitchClient,
        TwitchProperties twitchProperties
    ) {
        this.twitchClient = twitchClient;
        this.twitchProperties = twitchProperties;   
    }

    @PostConstruct
    public void init(){ // <== SETUP STEP AFTER CONTRUCTOR FIRES BY SPRING 
        
        twitchClient // <== DEFINE CHAT MESSAGE HANDLER
            .getEventManager()
            .onEvent(ChannelMessageEvent.class, this::onChatMessage);

        twitchClient
            .getEventManager()
            .onEvent(ChannelJoinEvent.class, this::onChannelJoin);
        
        twitchClient // <== JOIN CHANNEL
            .getChat()
            .joinChannel(twitchProperties.getChannel());
    
        }

    private void onChannelJoin(ChannelJoinEvent event) {
        String channel = event.getChannel().getName();
        System.out.printf("User joined channel: %s%n", channel);
    }

    private void onChatMessage(ChannelMessageEvent event) {
        String channel = event.getChannel().getName();
        String user = event.getUser().getName();
        String message = event.getMessage();

        System.out.printf("[%s] %s: %s%n", channel, user, message);
    }


}
