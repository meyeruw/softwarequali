package com.softwarequali;

import com.softwarequali.Main.PressureRange;

public class PressureRangeHandler (AcousticSignalMock acousticSignal, AlarmMock alarm, PressureSensorMock pressureSensor) {
    private void checkPressure() {
        if (pressure > 500) {
            reactToPressureRange(false, false, false, true, true, PressureRange.DANGEROUS);
        } else if (pressure > 300) {
            reactToPressureRange(true, true, true, false, false, PressureRange.MAXIMUM);
        } else if (pressure >= 220) {
            reactToPressureRange(false, true, true, false, false, PressureRange.HIGH);
        } else if (pressure > 180) {
            reactToPressureRange(false, false, false, false, false, PressureRange.OPTIMAL);
        } else if (pressure >= 50) {
            reactToPressureRange(false, true, true, false, false, PressureRange.LOW);
        } else if (pressure < 50) {
            reactToPressureRange(true, true, false, false, false, PressureRange.MINIMUM);
        } else {
            reactToPressureRange(false, false, false, false, false, PressureRange.INVALID);
        }
    }

    private void reactToPressureRange(boolean acoustic, boolean manager, boolean maintenance, boolean alarm, boolean evacuate, PressureRange range) {
        System.out.println("Pressure is " + range.toString().toLowerCase());
        acousticSignal.sendSignal();
        managerNotified = manager;
        maintenanceTeamInformed = maintenance;
        alarmTriggered = alarm;
        evacuation = evacuate;
        setValueRange(range);
    }
}


