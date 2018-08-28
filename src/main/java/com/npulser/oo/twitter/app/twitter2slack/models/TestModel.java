package com.npulser.oo.twitter.app.twitter2slack.models;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class TestModel{

    private String message;
    private Object data;

    public TestModel(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public HttpEntity<TestModel> build(HttpStatus status) {
        return new ResponseEntity<>(new TestModel(this.message, this.data), status);
    }
}