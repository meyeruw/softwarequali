package com.softwarequali;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testCriticalMinimumPressure() {
        Main main = new Main();

        main.setPressure(45);
        assertTrue(main.isAcousticSignalTriggered());
        assertTrue(main.isManagerNotified());
    }
}