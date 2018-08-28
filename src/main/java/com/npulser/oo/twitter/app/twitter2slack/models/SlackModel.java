package com.npulser.oo.twitter.app.twitter2slack.models;

import lombok.Data;

@Data
public class SlackModel {
    private String text;

    public SlackModel(String text) {
        this.text = text;
    }
}