package com.softwarequali;

import static com.softwarequali.PressureThresholds.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccousticSignalTest {

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is below 50")
    public void testAcousticSignalMinimumPressure() {
        Main main = new Main();
        main.setPressure(MINIMUM_PRESSURE_THRESHOLD - 1);
        assertTrue(main.);
    }

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is between 50 and 180")
    public void testAcousticSignalLowPressure() {
        Main main = new Main();
        main.setPressure(LOW_PRESSURE_THRESHOLD - 1);
        assertFalse(main.isAcousticSignalTriggered());
    }

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is above 180 and under 220")
    public void testAcousticSignalOptimalPressure() {
        Main main = new Main();
        main.setPressure(OPTIMAL_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isAcousticSignalTriggered());
    }

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is between 220 and 300")
    public void testAcousticSignalHighPressure() {
        Main main = new Main();
        main.setPressure(HIGH_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isAcousticSignalTriggered());
    }

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is above 300")
    public void testAcousticSignalMaximumPressure() {
        Main main = new Main();
        main.setPressure(MAXIMUM_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isAcousticSignalTriggered());
    }

    @Test
    @DisplayName("Test for the acoustic signal when the pressure is above 500")
    public void testAcousticSignalDangerousPressure() {
        Main main = new Main();
        main.setPressure(DANGEROUS_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isAcousticSignalTriggered());
    }
}