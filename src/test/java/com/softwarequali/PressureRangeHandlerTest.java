package com.softwarequali;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PressureRangeHandlerTest {

    @Test
    public void testPressureRangeHandlerMock() {
        PressureSensorMock pressureSensor = new PressureSensorMock(49.0, 7.0);
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(pressureSensor);
        AcousticSignalMock acousticSignal = pressureRangeHandler.getAcousticSignal();
        pressureRangeHandler.checkPressure();
        assertTrue(acousticSignal.wasSignalSent());
    }

}
