package com.npulser.oo.twitter.app.twitter2slack.models;

import java.util.Date;

import lombok.Data;

@Data
public class TweetModel {

    private String tweetText;
    private String tweetUser;
    private Date created;

    public TweetModel(String tweetText, String string, Date created) {
        this.tweetText = tweetText;
        this.tweetUser = string;
        this.created = created;
    }
}