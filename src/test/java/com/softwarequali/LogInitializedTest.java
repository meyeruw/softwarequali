package com.softwarequali;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogInitializedTest {

    @Test
    @DisplayName("Test for the log server when the pressure is below 50")
    public void testLogServerMinimumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(49.9, 7.0));
        LogSenderMock logSender = pressureRangeHandler.getLogSender();
        pressureRangeHandler.checkPressure();

        assertTrue(logSender.wasLogSent(), "The log was not sent with a pressure of 49.9");
    }

    @Test
    @DisplayName("Test for the log server when the pressure is between 50 and 180")
    public void testLogServerLowPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(50.0, 7.0));
        LogSenderMock logSender = pressureRangeHandler.getLogSender();
        pressureRangeHandler.checkPressure();

        assertTrue(logSender.wasLogSent(), "The log was not sent with a pressure of 50.0");
    }

    @Test
    @DisplayName("Test for the log server when the pressure is above 180 and under 220")
    public void testLogServerOptimalPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(
                new PressureSensorMock(219.9, 7.0));
        LogSenderMock logSender = pressureRangeHandler.getLogSender();
        pressureRangeHandler.checkPressure();

        assertTrue(logSender.wasLogSent(), "The log was not sent with a pressure of 219.9");
    }

    @Test
    @DisplayName("Test for the log server when the pressure is between 220 and 300")
    public void testLogServerHighPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(
                new PressureSensorMock(299.9, 7.0));
        LogSenderMock logSender = pressureRangeHandler.getLogSender();
        pressureRangeHandler.checkPressure();

        assertTrue(logSender.wasLogSent(), "The log was not sent with a pressure of 299.9");
    }

    @Test
    @DisplayName("Test for the log server when the pressure is above 300")
    public void testLogServerMaximumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(
                new PressureSensorMock(300.1, 7.0));
        LogSenderMock logSender = pressureRangeHandler.getLogSender();
        pressureRangeHandler.checkPressure();

        assertTrue(logSender.wasLogSent(), "The log was not sent with a pressure of 300.1");
    }

    @Test
    @DisplayName("Test for the log server when the pressure is above 500")
    public void testLogServerDangerousPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(
                new PressureSensorMock(500.1, 7.0));
        LogSenderMock logSender = pressureRangeHandler.getLogSender();
        pressureRangeHandler.checkPressure();

        assertTrue(logSender.wasLogSent(), "The log was not sent with a pressure of 500.1");
    }
}
