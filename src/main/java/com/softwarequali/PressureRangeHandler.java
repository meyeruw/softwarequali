package com.softwarequali;

public class PressureRangeHandler {
    private AcousticSignalMock acousticSignal;
    private AlarmMock alarm;
    private PressureSensorMock pressureSensor;

    // Constructor to initialize the dependencies
    public PressureRangeHandler(AcousticSignalMock acousticSignal, AlarmMock alarm, PressureSensorMock pressureSensor) {
        this.acousticSignal = acousticSignal;
        this.alarm = alarm;
        this.pressureSensor = pressureSensor;
    }

    public void checkPressure() {
        double pressure = pressureSensor.getPressure();
        if (pressure > 500) {
            reactToPressureRange(false, false, false, true, true, Main.PressureRange.DANGEROUS);
        } else if (pressure > 300) {
            reactToPressureRange(true, true, true, false, false, Main.PressureRange.MAXIMUM);
        } else if (pressure >= 220) {
            reactToPressureRange(false, true, true, false, false, Main.PressureRange.HIGH);
        } else if (pressure > 180) {
            reactToPressureRange(false, false, false, false, false, Main.PressureRange.OPTIMAL);
        } else if (pressure >= 50) {
            reactToPressureRange(false, true, true, false, false, Main.PressureRange.LOW);
        } else if (pressure < 50) {
            reactToPressureRange(true, true, false, false, false, Main.PressureRange.MINIMUM);
        } else {
            reactToPressureRange(false, false, false, false, false, Main.PressureRange.INVALID);
        }
    }

    private void reactToPressureRange(boolean acoustic, boolean manager, boolean maintenance, boolean alarm, boolean evacuate, Main.PressureRange range) {
        System.out.println("Pressure is " + range.toString().toLowerCase());
        acousticSignal.sendSignal();
        // Handle other actions based on pressure range
        // managerNotified = manager; // Manager-related variables are not in the scope of PressureRangeHandler
        // maintenanceTeamInformed = maintenance;
        // alarmTriggered = alarm;
        // evacuation = evacuate;
        // setValueRange(range); // This method is not available in PressureRangeHandler
    }
}
