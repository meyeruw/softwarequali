package com.softwarequali;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

public class MainTest {

    @Test
    public void testMinimumPressureValue() {
        Main main = new Main();
        main.setPressure(51);
        main.setPressure(49);
        assertTrue(main.isLogInitialized());
        assertTrue(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertFalse(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
        main.setPressure(47);
        assertFalse(main.isLogInitialized());
        
    }

    @Test
    public void testMaximumPressureValue() {
        Main main = new Main();
        main.setPressure(298);
        assertTrue(main.isLogInitialized());
        main.setPressure(302);
        assertTrue(main.isLogInitialized());
        main.setPressure(303);
        assertTrue(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertTrue(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    public void testOptimalPressureValue() {
        Main main = new Main();
        main.setPressure(207);
        assertFalse(main.isAcousticSignalTriggered());
        assertFalse(main.isManagerNotified());  
        assertFalse(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
        assertFalse(main.isLogInitialized());
    }

    @Test
    public void testLowPressureValue() {
        Main main = new Main();
        main.setPressure(107);
        assertFalse(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertTrue(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    public void testHighPressureValue() {
        Main main = new Main();
        main.setPressure(277);
        assertFalse(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertTrue(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    public void testDangerousPressureValue() {
        Main main = new Main();
        main.setPressure(507);
        assertFalse(main.isAcousticSignalTriggered());
        assertFalse(main.isManagerNotified());  
        assertFalse(main.isMaintenanceTeamInformed());
        assertTrue(main.isAlarmTriggered());
        assertTrue(main.isEvacuation());
    }

    @Test
    public void testLowVoltageValue() {
        Main main = new Main();
        main.setVoltage(4.9);
        assertTrue(main.isAcousticSignalTriggered());
        assertFalse(main.isManagerNotified());  
        assertFalse(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    public void testLogInitialized() {
        Main main = new Main();
        main.setPressure(181);
        assertFalse(main.isLogInitialized());
        main.setPressure(179);
        assertTrue(main.isLogInitialized());
        main.setPressure(177);
        assertFalse(main.isLogInitialized());
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    public void testSendLogToServer() {
        Main main = new Main();
        String logMessage = "Test log message";
        String response = main.sendLogToServer(logMessage);
        assertEquals("Server received the following message: " + logMessage, response, "Unexpected response from server");
    }
}