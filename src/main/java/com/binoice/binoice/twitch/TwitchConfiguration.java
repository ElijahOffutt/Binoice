package com.binoice.binoice.twitch;

// SPRING ANNOTATIONS
import org.springframework.context.annotation.Configuration; 
import org.springframework.context.annotation.Bean; 

/* TWITCH4J CLASSES */
import com.github.twitch4j.TwitchClient; 
import com.github.twitch4j.TwitchClientBuilder; 

// CREDENTIAL MANAGER CLASSES
import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;

@Configuration
public class TwitchConfiguration {

    @Bean
    public TwitchClient twitchClient(TwitchProperties props) {


        TwitchClient client = TwitchClientBuilder.builder()
                .withEnableChat(true)
                .withChatAccount(
                        new OAuth2Credential(
                            "twitch",
                            props.getBotAccessToken()
                        )
                    )
                .build();

        return client;
    }
}
