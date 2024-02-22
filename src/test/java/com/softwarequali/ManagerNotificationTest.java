package com.softwarequali;

import static com.softwarequali.PressureThresholds.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerNotificationTest {

    @Test
    @DisplayName("Test for the manager notification when the pressure is below 50")
    public void testManagerNotificationMinimumPressure() {
        Main main = new Main();
        main.setPressure(MINIMUM_PRESSURE_THRESHOLD - 1);
        assertTrue(main.isManagerNotified());
    }

    @Test
    @DisplayName("Test for the manager notification when the pressure is between 50 and 180")
    public void testManagerNotificationLowPressure() {
        Main main = new Main();
        main.setPressure(LOW_PRESSURE_THRESHOLD - 1);
        assertTrue(main.isManagerNotified());
    }

    @Test
    @DisplayName("Test for the manager notification when the pressure is above 180 and under 220")
    public void testManagerNotificationOptimalPressure() {
        Main main = new Main();
        main.setPressure(OPTIMAL_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isManagerNotified());
    }

    @Test
    @DisplayName("Test for the manager notification when the pressure is between 220 and 300")
    public void testManagerNotificationHighPressure() {
        Main main = new Main();
        main.setPressure(HIGH_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isManagerNotified());
    }

    @Test
    @DisplayName("Test for the manager notificationv when the pressure is above 300")
    public void testManagerNotificationMaximumPressure() {
        Main main = new Main();
        main.setPressure(MAXIMUM_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isManagerNotified());
    }

    @Test
    @DisplayName("Test for the manager notification when the pressure is above 500")
    public void testManagerNotificationDangerousPressure() {
        Main main = new Main();
        main.setPressure(DANGEROUS_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isManagerNotified());
    }

}
