package com.softwarequali;

public class Main {
    private int pressure;
    private boolean acousticSignalTriggered;
    private boolean managerNotified;

    public void setPressure(int pressure) {
        this.pressure = pressure;
        checkPressure();
    }

    public boolean isAcousticSignalTriggered() {
        return acousticSignalTriggered;
    }

    public boolean isManagerNotified() {
        return managerNotified;
    }

    private void checkPressure() {
        if (pressure < 50) {
            // Critical minimum value reached
            acousticSignalTriggered = true;
            managerNotified = true;
        } else {
            // Resetting states
            acousticSignalTriggered = false;
            managerNotified = false;
        }
    }
}