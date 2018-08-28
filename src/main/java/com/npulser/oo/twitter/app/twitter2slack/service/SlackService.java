package com.npulser.oo.twitter.app.twitter2slack.service;

import com.npulser.oo.twitter.app.twitter2slack.models.SlackModel;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SlackService {
    public void send2Slack(SlackModel slackModel) {
      RestTemplate restTemplate = new RestTemplate();
      restTemplate.postForEntity("https://hooks.slack.com/services/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", slackModel, String.class);
    }
}