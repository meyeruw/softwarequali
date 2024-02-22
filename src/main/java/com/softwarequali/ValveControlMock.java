package com.softwarequali;

public class ValveControlMock {
    
    public enum ValveState {
        OPEN, CLOSED, PARTIALLY_OPEN, ERROR
    }

    private ValveState currentState;

    public ValveControlMock() {
        currentState = ValveState.CLOSED;
    }

    public void setValveState(ValveState newState) {
        currentState = newState;
        System.out.println("Valve state set to: " + newState);
    }

    public ValveState getValveState() {
        return currentState;
    }
}