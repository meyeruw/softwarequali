package com.softwarequali;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testMinimumValue() {
        Main main = new Main();
        main.setPressure(47);
        assertTrue(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertFalse(main.isInformedMaintenanceTeam());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    public void testMaximumValue() {
        Main main = new Main();
        main.setPressure(307);
        assertTrue(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertTrue(main.isInformedMaintenanceTeam());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    public void testOptimalValue() {
        Main main = new Main();
        main.setPressure(207);
        assertFalse(main.isAcousticSignalTriggered());
        assertFalse(main.isManagerNotified());  
        assertFalse(main.isInformedMaintenanceTeam());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    public void testLowPressure() {
        Main main = new Main();
        main.setPressure(107);
        assertFalse(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertTrue(main.isInformedMaintenanceTeam());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    public void testHighPressure() {
        Main main = new Main();
        main.setPressure(277);
        assertFalse(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());  
        assertTrue(main.isInformedMaintenanceTeam());
        assertFalse(main.isAlarmTriggered());
        assertFalse(main.isEvacuation());
    }

    @Test
    public void testDangerousPressure() {
        Main main = new Main();
        main.setPressure(507);
        assertFalse(main.isAcousticSignalTriggered());
        assertFalse(main.isManagerNotified());  
        assertFalse(main.isInformedMaintenanceTeam());
        assertTrue(main.isAlarmTriggered());
        assertTrue(main.isEvacuation());
    }
}