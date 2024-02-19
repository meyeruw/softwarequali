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

    private void checkPressure() {

        // Critical minimum value
        if (pressure < 50) {
            acousticSignalTriggered = true;
            managerNotified = true;
            informedMaintenanceTeam = false;
            alarmTriggered = false;
            evacuation = false;

            // Critical maximum value
        } else if (pressure > 300) {
            acousticSignalTriggered = true;
            managerNotified = true;
            informedMaintenanceTeam = true;
            alarmTriggered = false;
            evacuation = false;

            // Optimal value
        } else if (pressure > 180 && pressure < 220) {
            acousticSignalTriggered = false;
            managerNotified = false;
            informedMaintenanceTeam = false;
            alarmTriggered = false;
            evacuation = false;

            // Underpressure
        } else if (pressure >= 50 && pressure <= 180) {
            acousticSignalTriggered = false;
            managerNotified = true;
            informedMaintenanceTeam = true;
            alarmTriggered = false;
            evacuation = false;

            // Overpressure
        } else if (pressure >= 220 && pressure <= 300) {
            acousticSignalTriggered = false;
            managerNotified = true;
            informedMaintenanceTeam = true;
            alarmTriggered = false;
            evacuation = false;

            // Dangerous value
        } else if (pressure > 500) {
            acousticSignalTriggered = false;
            managerNotified = false;
            informedMaintenanceTeam = false;
            alarmTriggered = true;
            evacuation = true;

        }
    }
}
