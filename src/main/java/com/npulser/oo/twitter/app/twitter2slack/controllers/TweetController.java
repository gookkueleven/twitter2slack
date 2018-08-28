package com.npulser.oo.twitter.app.twitter2slack.controllers;

import com.npulser.oo.twitter.app.twitter2slack.models.ResponseModel;
import com.npulser.oo.twitter.app.twitter2slack.service.TweetService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import twitter4j.TwitterException;

@RestController
public class TweetController {

    private TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("/getTweet")
    public HttpEntity<ResponseModel> getTweet(@RequestParam String searchQuery) throws TwitterException {
        tweetService.getTweetMessage(searchQuery);
        tweetService.getRealTimeTweet(tweetService.getScreenNameId(searchQuery));
        return new ResponseModel("success", null).build(HttpStatus.OK);
    }

}