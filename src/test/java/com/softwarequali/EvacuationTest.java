package com.softwarequali;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvacuationTest {

    @Test
    @DisplayName("Test for no evacuation when the pressure is below 50")
    public void testNoEvacuationMinimumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(49.9, 7.0));
        EvacuationMock evacuation = pressureRangeHandler.getEvacuation();
        pressureRangeHandler.checkPressure();

        assertFalse(evacuation.wasEvacuationTriggered(), "Evacuation was triggered with a pressure of 49.9");
    }

    @Test
    @DisplayName("Test for no evacuation when the pressure is between 50 and 180")
    public void testNoEvacuationLowPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(50.0, 7.0));
        EvacuationMock evacuation = pressureRangeHandler.getEvacuation();
        pressureRangeHandler.checkPressure();

        assertFalse(evacuation.wasEvacuationTriggered(), "Evacuation was triggered with a pressure of 50.0");
    }

    @Test
    @DisplayName("Test for no evacuation when the pressure is above 180 and under 220")
    public void testNoEvacuationOptimalPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(219.9, 7.0));
        EvacuationMock evacuation = pressureRangeHandler.getEvacuation();
        pressureRangeHandler.checkPressure();

        assertFalse(evacuation.wasEvacuationTriggered(), "Evacuation was triggered with a pressure of 219.9");
    }

    @Test
    @DisplayName("Test for no evacuation when the pressure is between 220 and 300")
    public void testNoEvacuationHighPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(300.0, 7.0));
        EvacuationMock evacuation = pressureRangeHandler.getEvacuation();
        pressureRangeHandler.checkPressure();

        assertFalse(evacuation.wasEvacuationTriggered(), "Evacuation was triggered with a pressure of 300.0");
    }

    @Test
    @DisplayName("Test for no evacuation when the pressure is above 300 but below 500")
    public void testNoEvacuationMaximumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(300.1, 7.0));
        EvacuationMock evacuation = pressureRangeHandler.getEvacuation();
        pressureRangeHandler.checkPressure();

        assertFalse(evacuation.wasEvacuationTriggered(), "Evacuation was triggered with a pressure of 300.1");
    }

    @Test
    @DisplayName("Test for evacuation when the pressure is above 500")
    public void testEvacuationDangerousPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(500.1, 7.0));
        EvacuationMock evacuation = pressureRangeHandler.getEvacuation();
        pressureRangeHandler.checkPressure();

        assertTrue(evacuation.wasEvacuationTriggered(), "Evacuation was not triggered with a pressure of 500.1");
    }
}
