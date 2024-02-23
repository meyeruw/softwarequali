package com.softwarequali;

public class LogSenderMock {

    private boolean wasLogSent = false;

    public void sendLog(String logMessage) {
        wasLogSent = true;
        System.out.println("Log message sent to Log Server: " + logMessage);
    }

    public boolean wasLogSent() {
        return wasLogSent;
    }

}
