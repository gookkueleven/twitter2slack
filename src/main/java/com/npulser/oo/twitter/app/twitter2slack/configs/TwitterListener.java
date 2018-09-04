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
		SlackModel slackModel = new SlackModel(ex.getMessage());
		slackService.send2Slack(slackModel);
	}

	@Override
	public void onStatus(Status status) {
		SlackModel slackModel = new SlackModel("@" + status.getUser().getScreenName() + " - " + status.getText());
		slackService.send2Slack(slackModel);
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		SlackModel slackModel = new SlackModel("@" + statusDeletionNotice.getStatusId() + " - " + "has been deleted");
		slackService.send2Slack(slackModel);
	}

	@Override
	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		SlackModel slackModel = new SlackModel("@" + numberOfLimitedStatuses + " - " + "track has been used");
		slackService.send2Slack(slackModel);
	}

	@Override
	public void onScrubGeo(long userId, long upToStatusId) {
		SlackModel slackModel = new SlackModel("@Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
		slackService.send2Slack(slackModel);
	}

	@Override
	public void onStallWarning(StallWarning warning) {
		SlackModel slackModel = new SlackModel("@Got stall warning:" + warning);
		slackService.send2Slack(slackModel);
	}

}