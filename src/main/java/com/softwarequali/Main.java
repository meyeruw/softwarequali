package com.softwarequali;

public class Main {

    // --- INSTANCE VARIABLES  ----------------------------------------------- //

    private double pressure = 200;
    private double voltage = 7;
    private PressureRange currentValueRange = PressureRange.OPTIMAL;
    private boolean acousticSignalTriggered = false;
    private boolean managerNotified = false;
    private boolean maintenanceTeamInformed = false;
    private boolean alarmTriggered = false;
    private boolean evacuation = false;
    private boolean logInitialized = false;

    public enum PressureRange {
        MINIMUM, LOW, OPTIMAL, HIGH, MAXIMUM, DANGEROUS,
        INVALID
    }

    // --- SET VALUE METHODS  ------------------------------------------------- //

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

    // --- CHECK BOOLEAN VALUES  ----------------------------------------------- //

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

    // --- PRESSURE METHODS ----------------------------------------------- //

    public void setValueRange(PressureRange newPressureRange) {
        if (currentValueRange != newPressureRange) {
            currentValueRange = newPressureRange;
            String serverAnswer = sendLogToServer(newPressureRange + " pressure value detected");
            logInitialized = serverAnswer.contains("Server received");
        } else {
            logInitialized = false;
        }
    }

    private void setPressureValues(boolean acoustic, boolean manager, boolean maintenance, boolean alarm, boolean evacuate, PressureRange range) {
        System.out.println("Pressure is " + range.toString().toLowerCase());
        acousticSignalTriggered = acoustic;
        managerNotified = manager;
        maintenanceTeamInformed = maintenance;
        alarmTriggered = alarm;
        evacuation = evacuate;
        setValueRange(range);
    }
    
    private void checkPressure() {
        if (pressure > 500) {
            setPressureValues(false, false, false, true, true, PressureRange.DANGEROUS);
        } else if (pressure > 300) {
            setPressureValues(true, true, true, false, false, PressureRange.MAXIMUM);
        } else if (pressure >= 220) {
            setPressureValues(false, true, true, false, false, PressureRange.HIGH);
        } else if (pressure > 180) {
            setPressureValues(false, false, false, false, false, PressureRange.OPTIMAL);
        } else if (pressure <= 180) {
            setPressureValues(false, true, true, false, false, PressureRange.LOW);
        } else if (pressure < 50) {
            setPressureValues(true, true, false, false, false, PressureRange.MINIMUM);
        } else {
            setPressureValues(false, false, false, false, false, PressureRange.INVALID);
        }
    }

    // --- VOLTAGE METHODS  ----------------------------------------------- //

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
        System.out.println("Voltage is low");
    }

    // --- LOGGING METHODS  ----------------------------------------------- //

    public String sendLogToServer(String logMessage) {
        try {
            // Simulate network delay
            Thread.sleep(4);
            return "Server received the following message: " + logMessage;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error while sending log to server", e);
        }
    }

    // --- VALVE METHODS   ----------------------------------------------- //

    public class VentilMock {

        public enum VentilState {
            OPEN, CLOSED
        }
    
        private VentilState currentState;
    
        public VentilMock() {
            // Standardmäßig ist das Ventil geschlossen
            currentState = VentilState.CLOSED;
        }
    
        // Methode zum Ändern des Ventilzustands (für Testzwecke)
        public void setVentilState(VentilState newState) {
            currentState = newState;
        }
    
        // Mock-Methode zur Abfrage des aktuellen Ventilzustands
        public VentilState getVentilState() {
            return currentState;
        }
    }
    

    // --- ALARM METHODS  ----------------------------------------------- //

    // --- SIGNAL METHODS  ----------------------------------------------- //
}