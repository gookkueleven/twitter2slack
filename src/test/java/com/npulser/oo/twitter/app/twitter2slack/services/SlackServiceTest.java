package com.npulser.oo.twitter.app.twitter2slack.services;

import com.npulser.oo.twitter.app.twitter2slack.models.SlackModel;
import com.npulser.oo.twitter.app.twitter2slack.service.SlackService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class SlackServiceTest {

    @Mock
    private SlackService slackService;

    @Mock
    private RestTemplate restTemplateMock;

    @Test
    public void send2SlackTest_success(){
        SlackModel slackModel = new SlackModel("this is a unit test");
        slackService.send2Slack(slackModel);
    }
}