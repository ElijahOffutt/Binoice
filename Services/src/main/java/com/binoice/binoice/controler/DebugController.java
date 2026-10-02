package com.binoice.binoice.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binoice.binoice.twitch.TwitchProperties;
import com.github.twitch4j.TwitchClient;


@RestController
@RequestMapping("/debug")
public class DebugController {
    
    private final TwitchProperties twitchProperties;
    private final TwitchClient twitchClient;

    // Constructor 
    public DebugController(
        TwitchProperties twitchProperties,
        TwitchClient twitchClient
    ) {
        this.twitchProperties = twitchProperties;
        this.twitchClient = twitchClient;
    }



    @GetMapping // <== Default route for debug ("/debug"), no trailing slash
    public String debug(){ return "Debug Controller"; }

    @GetMapping("/twitch")
    public String debugTwitch() {
        return "DebugTwitch Route is working";
    }
    
    @GetMapping("/twitch/channel")
    public String getTwitchChannel() {
        return twitchProperties.getChannel();
    }

    @GetMapping("/twitch/client")
    public String getTwitchClient() {
        return twitchClient.toString();
    }


}
