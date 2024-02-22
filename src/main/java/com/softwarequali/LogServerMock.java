package com.softwarequali;

public class LogServerMock {

    private boolean wasLogSent = false;

    public void sendLog() {
        wasLogSent = true;
        System.out.println("Log sent");
    }

    public boolean wasLogSent() {
        return wasLogSent;
    }
    
}
