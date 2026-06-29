package com.binoice.binoice.twitch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twitch")
public class TwitchController {

    @GetMapping
    public ResponseEntity<String> twitch() {
        return ResponseEntity.ok("Twitch Controller is working");
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Twitch Controller test is working");
    }
    
}
