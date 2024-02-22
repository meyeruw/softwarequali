package com.softwarequali;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlarmTriggeredTest {

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is below 50")
    public void testAlarmNotTriggeredMinimumPressure() {
        Main main = new Main();
        main.setPressure(PressureThresholdConstants.MINIMUM_PRESSURE_THRESHOLD - 1);
        assertFalse(main.isAlarmTriggered());
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is between 50 and 180")
    public void testAlarmNotTriggeredLowPressure() {
        Main main = new Main();
        main.setPressure(PressureThresholdConstants.LOW_PRESSURE_THRESHOLD - 1);
        assertFalse(main.isAlarmTriggered());
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is optimal")
    public void testAlarmNotTriggeredOptimalPressure() {
        Main main = new Main();
        main.setPressure(PressureThresholdConstants.OPTIMAL_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isAlarmTriggered());
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is between 220 and 300")
    public void testAlarmNotTriggeredHighPressure() {
        Main main = new Main();
        main.setPressure(PressureThresholdConstants.HIGH_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isAlarmTriggered());
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is above 300 but less than 500")
    public void testAlarmNotTriggeredMaximumPressure() {
        Main main = new Main();
        main.setPressure(PressureThresholdConstants.MAXIMUM_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isAlarmTriggered());
    }

    @Test
    @DisplayName("Test if the alarm is triggered when the pressure is above 500")
    public void testAlarmTriggeredDangerousPressure() {
        Main main = new Main();
        main.setPressure(PressureThresholdConstants.DANGEROUS_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isAlarmTriggered());
    }
}
