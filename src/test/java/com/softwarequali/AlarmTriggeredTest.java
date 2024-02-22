package com.softwarequali;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlarmTriggeredTest {

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is below 50")
    public void testAlarmNotTriggeredMinimumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(49.9, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertFalse(alarm.wasAlarmTriggered());
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is between 50 and 180")
    public void testAlarmNotTriggeredLowPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(50.1, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertFalse(alarm.wasAlarmTriggered());
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is optimal")
    public void testAlarmNotTriggeredOptimalPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(180.1, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertFalse(alarm.wasAlarmTriggered());
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is between 220 and 300")
    public void testAlarmNotTriggeredHighPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(220.1, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertFalse(alarm.wasAlarmTriggered());
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is above 300 but less than 500")
    public void testAlarmNotTriggeredMaximumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(300.1, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertFalse(alarm.wasAlarmTriggered());
    }

    @Test
    @DisplayName("Test if the alarm is triggered when the pressure is above 500")
    public void testAlarmTriggeredDangerousPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(500.1, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertTrue(alarm.wasAlarmTriggered());
    }

}