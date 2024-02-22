package com.softwarequali;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PressureRangeHandlerTest {

    @Test
    public void testPressureRangeHandlerMock() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(49.0, 7.0));
        AcousticSignalMock acousticSignal = pressureRangeHandler.getAcousticSignal();
        pressureRangeHandler.checkPressure();

        assertTrue(acousticSignal.wasSignalSent());
    }

}
