package com.softwarequali;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccousticSignalTest {

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is below 50")
    public void testAcousticSignalMinimumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(49.9, 7.0));
        AcousticSignalMock acousticSignal = pressureRangeHandler.getAcousticSignal();
        pressureRangeHandler.checkPressure();

        assertTrue(acousticSignal.wasSignalSent(), "The acoustic signal was not sent with a pressure of 49.9");
    }

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is between 50 and 180")
    public void testAcousticSignalLowPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(50.0, 7.0));
        AcousticSignalMock acousticSignal = pressureRangeHandler.getAcousticSignal();
        pressureRangeHandler.checkPressure();

        assertFalse(acousticSignal.wasSignalSent(), "The acoustic signal was sent with a pressure of 50.0");
    }

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is above 180 and under 220")
    public void testAcousticSignalOptimalPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(219.9, 7.0));
        AcousticSignalMock acousticSignal = pressureRangeHandler.getAcousticSignal();
        pressureRangeHandler.checkPressure();

        assertFalse(acousticSignal.wasSignalSent(), "The acoustic signal was sent with a pressure of 219.9");
    }

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is between 220 and 300")
    public void testAcousticSignalHighPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(300.0, 7.0));
        AcousticSignalMock acousticSignal = pressureRangeHandler.getAcousticSignal();
        pressureRangeHandler.checkPressure();

        assertFalse(acousticSignal.wasSignalSent(), "The acoustic signal was sent with a pressure of 300.0");
    }

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is above 300")
    public void testAcousticSignalMaximumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(300.1, 7.0));
        AcousticSignalMock acousticSignal = pressureRangeHandler.getAcousticSignal();
        pressureRangeHandler.checkPressure();

        assertTrue(acousticSignal.wasSignalSent(), "The acoustic signal was not sent with a pressure of 300.1");
    }

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is above 500")
    public void testAcousticSignalDangerousPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(500.1, 7.0));
        AcousticSignalMock acousticSignal = pressureRangeHandler.getAcousticSignal();
        pressureRangeHandler.checkPressure();

        assertFalse(acousticSignal.wasSignalSent(), "The acoustic signal was sent with a pressure of 500.1");
    }
}
