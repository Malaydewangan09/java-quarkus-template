package com.asyncapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    @JsonProperty("payload")
    private String payload;

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
} 