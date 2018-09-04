package com.npulser.oo.twitter.app.twitter2slack.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;

@Configuration
public class TwitterConfiguration{

    @Value(value = "${twitter.consumer.key}")
    private String consumerKey;
    @Value(value = "${twitter.consumer.secret}")
    private String consumerSecret;
    @Value(value = "${twitter.accesstoken}")
    private String accessToken;
    @Value(value = "${twitter.accesstoken.secret}")
    private String accessTokenSecret;

    @Bean
    public Twitter twitterClient() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
        .setOAuthConsumerKey(consumerKey)
        .setOAuthConsumerSecret(consumerSecret)
        .setOAuthAccessToken(accessToken)
        .setOAuthAccessTokenSecret(accessTokenSecret);

        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }
    
    @Bean
    public TwitterStream twitterStreamClient() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
        .setOAuthConsumerKey(consumerKey)
        .setOAuthConsumerSecret(consumerSecret)
        .setOAuthAccessToken(accessToken)
        .setOAuthAccessTokenSecret(accessTokenSecret);

        TwitterStreamFactory tsf = new TwitterStreamFactory(cb.build());
		return tsf.getInstance();
    }
}
