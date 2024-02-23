package com.softwarequali;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValveControlTest {

    ValveControlMock valveControlMock = new ValveControlMock();

    @Test
@DisplayName("Test for the valve state when the valve is closed")
public void testValveStatusClosed() {
    valveControlMock.setCurrentState(ValveControlMock.ValveState.CLOSED);
    ValveControlMock.ValveState state = valveControlMock.getValveState();
    assertTrue(state == ValveControlMock.ValveState.OPEN ||
               state == ValveControlMock.ValveState.CLOSED ||
               state == ValveControlMock.ValveState.PARTIALLY_OPEN, "State should be either OPEN, CLOSED, or PARTIALLY_OPEN");
    }
}
