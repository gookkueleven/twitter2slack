package com.npulser.oo.twitter.app.twitter2slack.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TweetModel {

    private String tweetText;
    private String tweetUser;
    private Date created;
}