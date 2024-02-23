package com.softwarequali;

public class LogSenderMock {

    private boolean wasLogSent = false;

    public void sendLog(String logMessage) {
        boolean serverResponse = simulateServerResponse(logMessage);
        if (serverResponse) {
            wasLogSent = true;
            System.out.println("Log message sent to Log Server: " + logMessage);
        } else {
            wasLogSent = false;
            System.out.println("Failed to send log message to Log Server: " + logMessage);
        }
    }

    private boolean simulateServerResponse(String logMessage) {
        // Simulate a server response.
        return logMessage.length() > 0;
    }

    public boolean wasLogSent() {
        return wasLogSent;
    }

}
