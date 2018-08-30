package com.npulser.oo.twitter.app.twitter2slack.service;

import com.npulser.oo.twitter.app.twitter2slack.models.SlackModel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SlackService {
  
  @Value("${slack.channel}")
  private String slackChannel;

  public void send2Slack(SlackModel slackModel) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForEntity(slackChannel, slackModel, String.class);
  }
}