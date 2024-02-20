package com.softwarequali;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void testMinimumPressureValue() {
        Main main = new Main();
        main.setPressure(47);
        assertTrue(main.isLogInitialized());
        main.setPressure(46);
        assertTrue(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertFalse(main.isMaintenanceTeamInformed());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
        assertFalse(main.isLogInitialized());
    }

    @Test
    public void testMaximumPressureValue() {
        Main main = new Main();
        main.setPressure(307);
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
        main.setValueRange("low");
        assertTrue(main.isLogInitialized());
    }
}