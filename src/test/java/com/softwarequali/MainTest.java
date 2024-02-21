package com.softwarequali;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

public class MainTest {

    private static final double MINIMUM_PRESSURE_THRESHOLD = 50;
    private static final double LOW_PRESSURE_THRESHOLD = 180;
    private static final double OPTIMAL_PRESSURE_THRESHOLD = 180;
    private static final double HIGH_PRESSURE_THRESHOLD = 220;
    private static final double MAXIMUM_PRESSURE_THRESHOLD = 300;
    private static final double DANGEROUS_PRESSURE_THRESHOLD = 500;

    // --- TESTS FOR PRESSURE RANGES ----------------------------------------------- //

    @Test
    @DisplayName("Test for the case when the pressure value is below 50")
    public void testMinimumPressureValue() {
        Main main = new Main();
        main.setPressure(MINIMUM_PRESSURE_THRESHOLD);
        main.setPressure(MINIMUM_PRESSURE_THRESHOLD - 1);
        assertTrue(main.isLogInitialized());
        assertTrue(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertFalse(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    @DisplayName("Test for the case when the pressure value is between 50 and 180")
    public void testLowPressureValue() {
        Main main = new Main();
        main.setPressure(LOW_PRESSURE_THRESHOLD + 1);
        main.setPressure(LOW_PRESSURE_THRESHOLD);
        assertTrue(main.isLogInitialized());
        assertFalse(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertTrue(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    @DisplayName("Test for the case when the pressure value is between 181 and 219")
    public void testOptimalPressureValue() {
        Main main = new Main();
        main.setPressure(OPTIMAL_PRESSURE_THRESHOLD);
        main.setPressure(OPTIMAL_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isLogInitialized());
        assertFalse(main.isAcousticSignalTriggered());
        assertFalse(main.isManagerNotified());  
        assertFalse(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    @DisplayName("Test for the case when the pressure value is between 220 and 300")
    public void testHighPressureValue() {
        Main main = new Main();
        main.setPressure(HIGH_PRESSURE_THRESHOLD - 1);
        main.setPressure(HIGH_PRESSURE_THRESHOLD);
        assertTrue(main.isLogInitialized());
        assertFalse(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertTrue(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    @DisplayName("Test for the case when the pressure value is above 300")
    public void testMaximumPressureValue() {
        Main main = new Main();
        main.setPressure(MAXIMUM_PRESSURE_THRESHOLD);
        main.setPressure(MAXIMUM_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isLogInitialized());
        assertTrue(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertTrue(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());        
    }

    @Test
    @DisplayName("Test for the case when the pressure value is above 500")
    public void testDangerousPressureValue() {
        Main main = new Main();
        main.setPressure(DANGEROUS_PRESSURE_THRESHOLD);
        main.setPressure(DANGEROUS_PRESSURE_THRESHOLD + 1);
        assertTrue(main.isLogInitialized());
        assertFalse(main.isAcousticSignalTriggered());
        assertFalse(main.isManagerNotified());  
        assertFalse(main.isMaintenanceTeamInformed());
        assertTrue(main.isAlarmTriggered());
        assertTrue(main.isEvacuation());
    }

    // --- TESTS FOR VOLTAGE ------------------------------------------------------- //

    @Test
    @DisplayName("Test for the case when the voltage is below 5")
    public void testLowVoltageValue() {
        Main main = new Main();
        main.setVoltage(4.9);
        assertTrue(main.isAcousticSignalTriggered());
        assertFalse(main.isManagerNotified());  
        assertFalse(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    // --- TESTS FOR LOGGING ------------------------------------------------------- //

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


    // test for the case when the server is not available

    // test if we only send the log to the server once when the value range changes
    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    public void testSendLogToServer() {
        Main main = new Main();
        String logMessage = "Test log message";
        String response = main.sendLogToServer(logMessage);
        assertEquals("Server received the following message: " + logMessage, response, "Unexpected response from server");
    }

    // --- TESTS FOR VENTIL -------------------------------------------------------- //

    // --- TESTS FOR ALARM --------------------------------------------------------- //

    // --- TESTS FOR SIGNAL -------------------------------------------------------- //
    
}