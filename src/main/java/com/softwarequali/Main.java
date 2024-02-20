package com.softwarequali;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private double pressure = 200.0;
    private double voltage = 5.5;
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

    //voltage gets updated in real time
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
        if (!currentValueRange.equals(newValueRange)){
            currentValueRange = newValueRange;
            logInitialized = true;
        } else {
            logInitialized = false;
        }
    }

    private void checkMinValue() {
        if (pressure < 50) {
            System.out.println("Pressure is too low");
            acousticSignalTriggered = true;
            managerNotified = true;
            maintenanceTeamInformed = false;
            alarmTriggered = false;
            evacuation = false;
            setValueRange("minimum");
        }
    }

    private void checkMaxValue() {
        if (pressure > 300 && pressure < 500) {
            System.out.println("Pressure is too high");
            acousticSignalTriggered = true;
            managerNotified = true;
            maintenanceTeamInformed = true;
            alarmTriggered = false;
            evacuation = false;
            setValueRange("maximum");
        }
    }

    private void checkOptimalValue() {
        if (pressure > 180 && pressure < 220) {
            System.out.println("Pressure is optimal");
            acousticSignalTriggered = false;
            managerNotified = false;
            maintenanceTeamInformed = false;
            alarmTriggered = false;
            evacuation = false;
            setValueRange("optimal");
        }
    }

    private void checkLowPressure() {
        if (pressure >= 50 && pressure <= 180) {
            System.out.println("Pressure is low");
            acousticSignalTriggered = false;
            managerNotified = true;
            maintenanceTeamInformed = true;
            alarmTriggered = false;
            evacuation = false;
            setValueRange("low");
        }
    }

    private void checkHighPressure() {
        if (pressure >= 220 && pressure <= 300) {
            System.out.println("Pressure is high");
            acousticSignalTriggered = false;
            managerNotified = true;
            maintenanceTeamInformed = true;
            alarmTriggered = false;
            evacuation = false;
            setValueRange("high");
        }
    }

    private void checkDangerousValue() {
        if (pressure >= 500) {
            System.out.println("Pressure is dangerous");
            acousticSignalTriggered = false;
            managerNotified = false;
            maintenanceTeamInformed = false;
            alarmTriggered = true;
            evacuation = true;
            setValueRange("dangerous");
        }
    }

    private void checkPressure() {
        checkMinValue();
        checkMaxValue();
        checkOptimalValue();
        checkLowPressure();
        checkHighPressure();
        checkDangerousValue();
        checkLowVoltageValue();
    }

    private void checkVoltage() {
        checkLowVoltageValue();
    }

    private void checkLowVoltageValue() {
        if (voltage < 5.0) {
            acousticSignalTriggered = true;
            managerNotified = false;
            maintenanceTeamInformed = false;
            alarmTriggered = false;
            evacuation = false;
        }
    }
}
