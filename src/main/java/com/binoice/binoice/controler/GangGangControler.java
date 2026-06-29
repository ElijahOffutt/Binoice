package com.binoice.binoice.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GangGangControler {
    
    @GetMapping("/")
    public String Gang(){
        return "Gang Gang";
    }

}
