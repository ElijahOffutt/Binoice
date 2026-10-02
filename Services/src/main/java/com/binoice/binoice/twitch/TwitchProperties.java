package com.binoice.binoice.twitch;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "twitch") // <== Binds properties with prefix "twitch" to this class     
public class TwitchProperties {

    private String channel;
    private String tokenGeneratorClientId;
    private String clientId;
    private String clientSecret;
    private String botAccessToken;
    private String refreshToken;

    // Getters and Setters
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTokenGeneratorClientId() {
        return tokenGeneratorClientId;
    }

    public void setTokenGeneratorClientId(String tokenGeneratorClientId) {
        this.tokenGeneratorClientId = tokenGeneratorClientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getBotAccessToken() {
        return botAccessToken;
    }

    public void setBotAccessToken(String botAccessToken) {
        this.botAccessToken = botAccessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    
}
