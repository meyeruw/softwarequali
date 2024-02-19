package com.softwarequali;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private int pressure;
    private boolean acousticSignalTriggered;
    private boolean managerNotified;
    private boolean informedMaintenanceTeam;
    private boolean alarmTriggered;
    private boolean evacuation;

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

    public boolean isInformedMaintenanceTeam() {
        return informedMaintenanceTeam;
    }

    public boolean isAlarmTriggered() {
        return alarmTriggered;
    }

    public boolean isEvacuation() {
        return evacuation;
    }

    private void checkMinValue() {
        if (pressure < 50) {
            acousticSignalTriggered = true;
            managerNotified = true;
            informedMaintenanceTeam = false;
            alarmTriggered = false;
            evacuation = false;
        }
    }

    private void checkMaxValue() {
        if (pressure > 300) {
            acousticSignalTriggered = true;
            managerNotified = true;
            informedMaintenanceTeam = true;
            alarmTriggered = false;
            evacuation = false;
        }
    }

    private void checkOptimalValue() {
        if (pressure > 180 && pressure < 220) {
            acousticSignalTriggered = false;
            managerNotified = false;
            informedMaintenanceTeam = false;
            alarmTriggered = false;
            evacuation = false;
        }
    }

    private void checkLowPressure() {
        if (pressure >= 50 && pressure <= 180) {
            acousticSignalTriggered = false;
            managerNotified = true;
            informedMaintenanceTeam = true;
            alarmTriggered = false;
            evacuation = false;
        }
    }

    private void checkHighPressure() {
        if (pressure >= 220 && pressure <= 300) {
            acousticSignalTriggered = false;
            managerNotified = true;
            informedMaintenanceTeam = true;
            alarmTriggered = false;
            evacuation = false;
        }
    }

    private void checkDangerousValue() {
        if (pressure > 500) {
            acousticSignalTriggered = false;
            managerNotified = false;
            informedMaintenanceTeam = false;
            alarmTriggered = true;
            evacuation = true;
        }
    }

    private void checkPressure() {
        checkMinValue();
        checkMaxValue();
        checkOptimalValue();
        checkLowPressure();
        checkHighPressure();
        checkDangerousValue();
    }
}
