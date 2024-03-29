package com.softwarequali;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlarmTriggeredTest {

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is below 50")
    public void testAlarmMinimumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(49.9, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertFalse(alarm.wasAlarmTriggered(), "The alarm was not triggered with a pressure of 49.9");
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is between 50 and 180")
    public void testAlarmLowPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(50.0, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertFalse(alarm.wasAlarmTriggered(), "The alarm was not triggered with a pressure of 50.0");
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is optimal")
    public void testAlarmOptimalPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(
                new PressureSensorMock(219.9, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertFalse(alarm.wasAlarmTriggered(), "The alarm was not triggered with a pressure of 219.9");
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is between 220 and 300")
    public void testAlarmHighPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(300, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertFalse(alarm.wasAlarmTriggered(), "The alarm was not triggered with a pressure of 300.0");
    }

    @Test
    @DisplayName("Test if the alarm is not triggered when the pressure is above 300 but less than 500")
    public void testAlarmMaximumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(
                new PressureSensorMock(300.1, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertFalse(alarm.wasAlarmTriggered(), "The alarm was not triggered with a pressure of 300.1");
    }

    @Test
    @DisplayName("Test if the alarm is triggered when the pressure is above 500")
    public void testAlarmDangerousPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(
                new PressureSensorMock(500.1, 7.0));
        AlarmMock alarm = pressureRangeHandler.getAlarm();
        pressureRangeHandler.checkPressure();

        assertTrue(alarm.wasAlarmTriggered(), "The alarm was triggered with a pressure of 500.1");
    }

}
