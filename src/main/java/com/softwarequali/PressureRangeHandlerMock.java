package com.softwarequali;

import static com.softwarequali.PressureThresholdConstants.*;

public class PressureRangeHandlerMock {
    private AcousticSignalMock acousticSignal;
    private AlarmMock alarm;
    private PressureSensorMock pressureSensor;

    public PressureRangeHandlerMock(AcousticSignalMock acousticSignal, AlarmMock alarm, PressureSensorMock pressureSensor) {
        this.acousticSignal = acousticSignal;
        this.alarm = alarm;
        this.pressureSensor = pressureSensor;
    }

    pressureSensor.setPressure(100);
    double pressur = pressureSensor.getPressure();

    private void checkPressure() {
        if (pressure > 500) {
            reactToPressureRange(false, false, false, true, true, DANGEROUS_PRESSURE_THRESHOLD);
            alarm.triggerAlarm();
        } else if (pressure > 300) {
            reactToPressureRange(true, true, true, false, false, MAXIMUM_PRESSURE_THRESHOLD);
        } else if (pressure >= 220) {
            reactToPressureRange(false, true, true, false, false, HIGH_PRESSURE_THRESHOLD);
        } else if (pressure > 180) {
            reactToPressureRange(false, false, false, false, false, OPTIMAL_PRESSURE_THRESHOLD);
        } else if (pressure >= 50) {
            reactToPressureRange(false, true, true, false, false, LOW_PRESSURE_THRESHOLD);
        } else if (pressure < 50) {
            reactToPressureRange(true, true, false, false, false, MINIMUM_PRESSURE_THRESHOLD);
        } else {
            reactToPressureRange(false, false, false, false, false, INVALID_PRESSURE_THRESHOLD);
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
