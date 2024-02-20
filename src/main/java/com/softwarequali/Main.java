package com.softwarequali;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private double pressure = 200;
    private double voltage = 7;
    private String currentValueRange = "optimal";
    private boolean acousticSignalTriggered = false;
    private boolean managerNotified = false;
    private boolean maintenanceTeamInformed = false;
    private boolean alarmTriggered = false;
    private boolean evacuation = false;
    private boolean logInitialized = false;

    // pressure gets updated in real time
    public void setPressure(double pressureSensorValue) {
        // pressure value from sensor
        this.pressure = pressureSensorValue;
        checkPressure();
    }

    // voltage gets updated in real time
    public void setVoltage(double voltageSensorValue) {
        // voltage value from sensor
        this.voltage = voltageSensorValue;
        checkVoltage();
    }

    public boolean isLogInitialized() {
        return logInitialized;
    }

    public boolean isAcousticSignalTriggered() {
        return acousticSignalTriggered;
    }

    public boolean isManagerNotified() {
        return managerNotified;
    }

    public boolean isMaintenanceTeamInformed() {
        return maintenanceTeamInformed;
    }

    public boolean isAlarmTriggered() {
        return alarmTriggered;
    }

    public boolean isEvacuation() {
        return evacuation;
    }

    public void setValueRange(String newValueRange) {
        if (!currentValueRange.equals(newValueRange)) {
            currentValueRange = newValueRange;
            String serverAnswer = sendLogToServer(newValueRange + " pressure value detected");
            if (serverAnswer.contains("Server received")) {
                logInitialized = true;
            } else {
                logInitialized = false;
            }
        } else {
            logInitialized = false;
        }
    }

    private void minValue() {
        System.out.println("Pressure is too low");
        acousticSignalTriggered = true;
        managerNotified = true;
        maintenanceTeamInformed = false;
        alarmTriggered = false;
        evacuation = false;
        setValueRange("minimum");
    }

    private void maxValue() {
        System.out.println("Pressure is too high");
        acousticSignalTriggered = true;
        managerNotified = true;
        maintenanceTeamInformed = true;
        alarmTriggered = false;
        evacuation = false;
        setValueRange("maximum");
    }

    private void optimalValue() {
        System.out.println("Pressure is optimal");
        acousticSignalTriggered = false;
        managerNotified = false;
        maintenanceTeamInformed = false;
        alarmTriggered = false;
        evacuation = false;
        setValueRange("optimal");
    }

    private void lowPressure() {
        System.out.println("Pressure is low");
        acousticSignalTriggered = false;
        managerNotified = true;
        maintenanceTeamInformed = true;
        alarmTriggered = false;
        evacuation = false;
        setValueRange("low");
    }

    private void highPressure() {
        System.out.println("Pressure is high");
        acousticSignalTriggered = false;
        managerNotified = true;
        maintenanceTeamInformed = true;
        alarmTriggered = false;
        evacuation = false;
        setValueRange("high");
    }

    private void dangerousValue() {
        System.out.println("Pressure is dangerous");
        acousticSignalTriggered = false;
        managerNotified = false;
        maintenanceTeamInformed = false;
        alarmTriggered = true;
        evacuation = true;
        setValueRange("dangerous");
    }

    private void checkPressure() {
        if (pressure > 500) {
            dangerousValue();
        } else if (pressure > 300) {
            maxValue();
        } else if (pressure >= 220) {
            highPressure();
        } else if (pressure > 180) {
            optimalValue();
        } else if (pressure >= 50) {
            lowPressure();
        } else {
            minValue();
        }
    }

    private void checkVoltage() {
        if (voltage < 5.0) {
            lowVoltageValue();
        }
    }

    private void lowVoltageValue() {
        acousticSignalTriggered = true;
        managerNotified = false;
        maintenanceTeamInformed = false;
        alarmTriggered = false;
        evacuation = false;
    }

    public String sendLogToServer(String logMessage) {
        try {
            // Simulate network delay
            Thread.sleep(4);
            return "Server received the following message: " + logMessage;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
