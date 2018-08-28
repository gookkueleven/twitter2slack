package com.npulser.oo.twitter.app.twitter2slack.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetController {

    @GetMapping("/monitor")
    public HttpEntity<String> monitoringUser(@RequestParam String username) {
        
        

        return null;
    }

}