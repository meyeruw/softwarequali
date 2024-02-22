package com.softwarequali;

public class AcousticSignalMock {
    private boolean wasSignalSent = false;

    public void sendSignal() {
        wasSignalSent = true;
    }

    public boolean wasSignalSent() {
        return wasSignalSent;
    }
}
