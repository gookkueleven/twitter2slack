package com.npulser.oo.twitter.app.twitter2slack.service;

import com.npulser.oo.twitter.app.twitter2slack.configs.TwitterListener;
import com.npulser.oo.twitter.app.twitter2slack.models.SlackModel;

import org.springframework.stereotype.Service;

import twitter4j.FilterQuery;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.User;

@Service
 public class TweetService {

    private Twitter twitterClient;
    private TwitterStream twitterStreamClient;
    private SlackService slackService;

    public TweetService(Twitter twitterClient, TwitterStream twitterStreamClient, SlackService slackService) {
        this.twitterClient = twitterClient;
        this.twitterStreamClient = twitterStreamClient;
        this.slackService = slackService;
    }

    public void getTweetMessage(String query) throws TwitterException {
        ResponseList<Status> responseList = twitterClient.getUserTimeline(query);
        slackService.send2Slack(new SlackModel(responseList.get(0).getText()));
    }

    public void getRealTimeTweet(long userId) {
        twitterStreamClient.clearListeners();
        TwitterListener listener = new TwitterListener(slackService);
        twitterStreamClient.addListener(listener);
        twitterStreamClient.filter(new FilterQuery(userId));
    }

    public long getScreenNameId(String screenName) throws TwitterException {
        ResponseList<User> userList = twitterClient.searchUsers(screenName, 5);
        return userList.stream()
                .filter(obj -> obj.getScreenName().equalsIgnoreCase(screenName))
                .findFirst()
                .get()
                .getId();
    } 
 }