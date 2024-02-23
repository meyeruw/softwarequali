package com.softwarequali;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValveControlTest {

    ValveControlMock valveControlMock = new ValveControlMock();

    @Test
    @DisplayName("Test if a query for the known valve states is possible")
    public void testValveStatusClosed() {
        ValveControlMock.ValveState state = valveControlMock.getValveState();
        assertTrue(state == ValveControlMock.ValveState.OPEN ||
                state == ValveControlMock.ValveState.CLOSED ||
                state == ValveControlMock.ValveState.PARTIALLY_OPEN, "A query for the known valve states was not possible");
    }
}
