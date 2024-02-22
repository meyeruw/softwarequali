package com.softwarequali;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogInitializedTest {

    @Test
    @DisplayName("Test if logging is initialized when the pressure changes from one range to another")
    public void testLogInitializedOnPressureChange() {
        Main main = new Main();
        // Set initial pressure to ensure log is not initialized
        main.setPressure(PressureThresholds.MINIMUM_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isLogInitialized(), "Log should not be initialized for initial pressure setting within the same range");

        // Change pressure to trigger log initialization
        main.setPressure(PressureThresholds.DANGEROUS_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isLogInitialized(), "Log should be initialized when pressure changes to a different range");
    }

    @Test
    @DisplayName("Test if logging is not initialized when the pressure stays within the same range")
    public void testLogNotInitializedWithinSameRange() {
        Main main = new Main();
        // Set initial pressure
        main.setPressure(PressureThresholds.LOW_PRESSURE_THRESHOLD + 1);
        
        // Set pressure again within the same range
        main.setPressure(PressureThresholds.LOW_PRESSURE_THRESHOLD + 10);
        assertFalse(main.isLogInitialized(), "Log should not be initialized when pressure changes within the same range");
    }

    @Test
    @DisplayName("Test if logging is initialized when voltage drops below 5V")
    public void testLogInitializedOnVoltageDrop() {
        Main main = new Main();
        // Assuming setting voltage below 5V triggers log initialization
        main.setVoltage(4.9);
        assertTrue(main.isLogInitialized(), "Log should be initialized when voltage drops below 5V");
    }
}
