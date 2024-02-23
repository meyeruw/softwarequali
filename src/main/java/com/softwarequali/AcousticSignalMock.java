package com.softwarequali;

public class AcousticSignalMock {

    private boolean wasSignalSent = false;

    public void sendSignal() {
        wasSignalSent = true;
        System.out.println("Acoustic signal sent");
    }

    public boolean wasSignalSent() {
        return wasSignalSent;
    }

}
