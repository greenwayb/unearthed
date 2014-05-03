package com.inventive.system.monitoring.gwt.client.service.streaming;

public class TextStreamMessage implements StreamMessage {

    private String message;

    private TextStreamMessage() {
    }

    public TextStreamMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
