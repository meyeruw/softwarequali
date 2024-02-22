package com.softwarequali;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerNotificationTest {

    @Test
    @DisplayName("Test for the manager notification when the pressure is below 50")
    public void testManagerNotificationMinimumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(49.9, 7.0));
        NotificationMock managerNotification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertTrue(managerNotification.wasManagerNotified(), "The manager was notified with a pressure of 49.1");
    }

    @Test
    @DisplayName("Test for the manager notification when the pressure is between 50 and 180")
    public void testManagerNotificationLowPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(50.0, 7.0));
        NotificationMock managerNotification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertTrue(managerNotification.wasManagerNotified(), "The manager was notified with a pressure of 50.0");
    }

    @Test
    @DisplayName("Test for the manager notification when the pressure is above 180 and under 220")
    public void testManagerNotificationOptimalPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(219.9, 7.0));
        NotificationMock managerNotification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertFalse(managerNotification.wasManagerNotified(), "The manager was not notified with a pressure of 219.9");
    }

    @Test
    @DisplayName("Test for the manager notification when the pressure is between 220 and 300")
    public void testManagerNotificationHighPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(300.0, 7.0));
        NotificationMock managerNotification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertTrue(managerNotification.wasManagerNotified(), "The manager was notified with a pressure of 300.0");
    }

    @Test
    @DisplayName("Test for the manager notificationv when the pressure is above 300")
    public void testManagerNotificationMaximumPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(300.1, 7.0));
        NotificationMock managerNotification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertTrue(managerNotification.wasManagerNotified(), "The manager was notified with a pressure of 300.1");
    }

    @Test
    @DisplayName("Test for the manager notification when the pressure is above 500")
    public void testManagerNotificationDangerousPressure() {
        PressureRangeHandlerMock pressureRangeHandler = new PressureRangeHandlerMock(new PressureSensorMock(500.1, 7.0));
        NotificationMock managerNotification = pressureRangeHandler.getNotificationMock();
        pressureRangeHandler.checkPressure();

        assertFalse(managerNotification.wasManagerNotified(), "The manager was not notified with a pressure of 500.1");
    }
}
