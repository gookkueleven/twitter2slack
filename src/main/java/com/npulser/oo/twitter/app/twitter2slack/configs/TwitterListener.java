package com.npulser.oo.twitter.app.twitter2slack.configs;

import com.npulser.oo.twitter.app.twitter2slack.models.SlackModel;
import com.npulser.oo.twitter.app.twitter2slack.service.SlackService;

import org.springframework.stereotype.Service;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

@Service
public class TwitterListener implements StatusListener{

	private SlackService slackService;

	public TwitterListener(SlackService slackService) {
		this.slackService = slackService;
	}

	@Override
	public void onException(Exception ex) {
		ex.printStackTrace();
	}

	@Override
	public void onStatus(Status status) {
		SlackModel slackModel = new SlackModel(status.getText());
		slackService.send2Slack(slackModel);
		System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
	}

	@Override
	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
	}

	@Override
	public void onScrubGeo(long userId, long upToStatusId) {
		System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
	}

	@Override
	public void onStallWarning(StallWarning warning) {
		System.out.println("Got stall warning:" + warning);
	}

}