package com.softwarequali;

import static com.softwarequali.PressureThresholdConstants.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvacuationTest {

    @Test
    @DisplayName("Test for no evacuation when the pressure is below 50")
    public void testNoEvacuationMinimumPressure() {
        Main main = new Main();
        main.setPressure(MINIMUM_PRESSURE_THRESHOLD - 1);
        assertFalse(main.isEvacuation());
    }

    @Test
    @DisplayName("Test for no evacuation when the pressure is between 50 and 180")
    public void testNoEvacuationLowPressure() {
        Main main = new Main();
        main.setPressure(LOW_PRESSURE_THRESHOLD - 1);
        assertFalse(main.isEvacuation());
    }

    @Test
    @DisplayName("Test for no evacuation when the pressure is above 180 and under 220")
    public void testNoEvacuationOptimalPressure() {
        Main main = new Main();
        main.setPressure(OPTIMAL_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isEvacuation());
    }

    @Test
    @DisplayName("Test for no evacuation when the pressure is between 220 and 300")
    public void testNoEvacuationHighPressure() {
        Main main = new Main();
        main.setPressure(HIGH_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isEvacuation());
    }

    @Test
    @DisplayName("Test for no evacuation when the pressure is above 300 but below 500")
    public void testNoEvacuationMaximumPressure() {
        Main main = new Main();
        main.setPressure(MAXIMUM_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isEvacuation());        
    }

    @Test
    @DisplayName("Test for evacuation when the pressure is above 500")
    public void testEvacuationDangerousPressure() {
        Main main = new Main();
        main.setPressure(DANGEROUS_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isEvacuation());
    }
}
