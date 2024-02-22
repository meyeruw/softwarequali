package com.softwarequali;

import static com.softwarequali.PressureThresholdConstants.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaintenanceTeamInformedTest {

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is below 50")
    public void testMaintenanceTeamInformedMinimumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(49.9, 7.0));
        NotificationMock notification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertTrue(notification.wasMaintenanceTeamNotified(), "The maintenance team was not informed with a pressure of 49.9");
    }

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is between 50 and 180")
    public void testMaintenanceTeamInformedLowPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(50.0, 7.0));
        NotificationMock notification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertTrue(notification.wasMaintenanceTeamNotified(), "The maintenance team was not informed with a pressure of 50.0");
    }

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is above 180 and under 220")
    public void testMaintenanceTeamInformedOptimalPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(219.9, 7.0));
        NotificationMock notification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertFalse(notification.wasMaintenanceTeamNotified(), "The maintenance team was not informed with a pressure of 219.9");
    }

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is between 220 and 300")
    public void testMaintenanceTeamInformedHighPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(300.0, 7.0));
        NotificationMock notification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertTrue(notification.wasMaintenanceTeamNotified(), "The maintenance team was not informed with a pressure of 300.0");
    }

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is above 300")
    public void testMaintenanceTeamInformedMaximumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(300.1, 7.0));
        NotificationMock notification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertTrue(notification.wasMaintenanceTeamNotified(), "The maintenance team was not informed with a pressure of 300.1");
    }

    @Test
    @DisplayName("Test if the maintenance team is informed when the pressure is above 500")
    public void testMaintenanceTeamInformedDangerousPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(500.1, 7.0));
        NotificationMock notification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertFalse(notification.wasMaintenanceTeamNotified(), "The maintenance team was not informed with a pressure of 500.1");
    }
}
