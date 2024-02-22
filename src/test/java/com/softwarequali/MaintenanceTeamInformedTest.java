package com.softwarequali;

import static com.softwarequali.PressureThresholds.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaintenanceTeamInformedTest {

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is below 50")
    public void testMaintenanceTeamInformedMinimumPressure() {
        Main main = new Main();
        main.setPressure(MINIMUM_PRESSURE_THRESHOLD - 1);
        assertTrue(main.isMaintenanceTeamInformed());
    }

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is between 50 and 180")
    public void testMaintenanceTeamInformedLowPressure() {
        Main main = new Main();
        main.setPressure(LOW_PRESSURE_THRESHOLD - 1);
        assertTrue(main.isMaintenanceTeamInformed());
    }

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is above 180 and under 220")
    public void testMaintenanceTeamInformedOptimalPressure() {
        Main main = new Main();
        main.setPressure(OPTIMAL_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isMaintenanceTeamInformed());
    }

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is between 220 and 300")
    public void testMaintenanceTeamInformedHighPressure() {
        Main main = new Main();
        main.setPressure(HIGH_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isMaintenanceTeamInformed());
    }

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is above 300")
    public void testMaintenanceTeamInformedMaximumPressure() {
        Main main = new Main();
        main.setPressure(MAXIMUM_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isMaintenanceTeamInformed());
    }

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is above 500")
    public void testMaintenanceTeamInformedDangerousPressure() {
        Main main = new Main();
        main.setPressure(DANGEROUS_PRESSURE_THRESHOLD + 1);
        assertFalse(main.isMaintenanceTeamInformed());
    }

}
