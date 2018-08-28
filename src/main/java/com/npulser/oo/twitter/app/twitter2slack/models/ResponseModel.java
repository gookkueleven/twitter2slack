package com.npulser.oo.twitter.app.twitter2slack.models;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class ResponseModel{

    private String message;
    private Object data;

    public ResponseModel(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public HttpEntity<ResponseModel> build(HttpStatus status) {
        return new ResponseEntity<>(new ResponseModel(this.message, this.data), status);
    }
}