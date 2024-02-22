package com.softwarequali;

public class ValveControlMock {
    
    public enum ValveState {
        OPEN, CLOSED, PARTIALLY_OPEN, ERROR
    }

    private ValveState currentState;

    public ValveControlMock() {
        currentState = ValveState.CLOSED;
    }

    public void setCurrentState(ValveState state) {
        this.currentState = state;
    }

    public ValveState getValveState() {
        return currentState;
    }
}