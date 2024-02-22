package com.softwarequali;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValveControlTest {

    ValveControlMock valveControlMock = new ValveControlMock();

    @Test
    @DisplayName("Test for the valve state when the valve is closed")
    public void testValveStatusClosed() {
        valveControlMock.setCurrentState(ValveControlMock.ValveState.CLOSED);
        assertEquals(ValveControlMock.ValveState.CLOSED, valveControlMock.getValveState(), "Initial state should be CLOSED");
    }

    @Test
    @DisplayName("Test for the valve state when the valve is opened")
    public void testValveStatusOpened() {
        valveControlMock.setCurrentState(ValveControlMock.ValveState.OPEN);
        assertEquals(ValveControlMock.ValveState.OPEN, valveControlMock.getValveState(), "State should be OPEN after setting to OPEN");
    }

    @Test
    @DisplayName("Test for the valve state when the valve is partially opened")
    public void testValveStatusPartiallyOpened() {
        valveControlMock.setCurrentState(ValveControlMock.ValveState.PARTIALLY_OPEN);
        assertEquals(ValveControlMock.ValveState.PARTIALLY_OPEN, valveControlMock.getValveState(), "State should be PARTIALLY_OPEN after setting to PARTIALLY_OPEN");
    }
    
}
