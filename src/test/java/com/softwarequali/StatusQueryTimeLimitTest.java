package com.softwarequali;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.softwarequali.ValveControlMock.ValveState;

public class StatusQueryTimeLimitTest {

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test if the status query of the pressure value of the pressure sensor needs more than 10ms to complete")
    public void testPressureValueTimeLimit() {
        PressureSensorMock pressureSensor = new PressureSensorMock(200.0, 7.0);

        assertTrue(pressureSensor.getPressure() == 200.0, "The status query of the pressure value of the pressure sensor needed longer than 10ms to complete");
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test if the status query of the voltage value of the pressure sensor needs more than 10ms to complete")
    public void testVoltageValueTimeLimit() {
        PressureSensorMock pressureSensor = new PressureSensorMock(200.0, 7.0);

        assertTrue(pressureSensor.getVoltage() == 7.0, "The status query of the voltage value of the pressure sensor needed longer than 10ms to complete");
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test if the status query of the acoustic signal needs more than 10ms to complete")
    public void testAcousticSignalTimeLimit() {
        AcousticSignalMock acousticSignal = new AcousticSignalMock();

        assertFalse(acousticSignal.wasSignalSent(), "The status query of the acoustic signal needed longer than 10ms to complete");
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test if the status query of the alarm signal needs more than 10ms to complete")
    public void testAlarmTimeLimit() {
        AlarmMock alarm = new AlarmMock();

        assertFalse(alarm.wasAlarmTriggered(), "The status query of the alarm signal needed longer than 10ms to complete");
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test if the status query of the evacuation needs more than 10ms to complete")
    public void testEvacuationTimeLimit() {
        EvacuationMock evacuation = new EvacuationMock();

        assertFalse(evacuation.wasEvacuationTriggered(), "The status query of the evacuation needed longer than 10ms to complete");
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test if the status query of logging needs more than 10ms to complete")
    public void testLoggingTimeLimit() {
        LogServerMock logServer = new LogServerMock();

        assertFalse(logServer.wasLogSent(), "The status query of logging needed longer than 10ms to complete");
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test if the status query of the notification of the manager needs more than 10ms to complete")
    public void testNotificationManagerTimeLimit() {
        NotificationMock notification = new NotificationMock();

        assertFalse(notification.wasManagerNotified(), "The status query of the notification of the manager needed longer than 10ms to complete");
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test if the status query of the notification of the maintenance team needs more than 10ms to complete")
    public void testNotificationMaintenanceTeamTimeLimit() {
        NotificationMock notification = new NotificationMock();

        assertFalse(notification.wasMaintenanceTeamNotified(), "The status query of the notification of the maintenance team needed longer than 10ms to complete");
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test if the status query of the valve control needs more than 10ms to complete")
    public void testValveControlTimeLimit() {
        ValveControlMock valveControl = new ValveControlMock();

        assertTrue(valveControl.getValveState() == ValveState.CLOSED, "The status query of the valve control needed longer than 10ms to complete");
    }
}
