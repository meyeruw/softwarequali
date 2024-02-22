package com.softwarequali;

public class ValveControlMock {
    
    public enum ValveState {
        OPEN, CLOSED, PARTIALLY_OPEN
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

    public void openValve() {
        setValveState(ValveState.OPEN);
        System.out.println("Valve opened");
    }

    public void closeValve() {
        setValveState(ValveState.CLOSED);
        System.out.println("Valve closed");
    }

    public void partiallyOpenValve() {
        setValveState(ValveState.PARTIALLY_OPEN);
        System.out.println("Valve partially opened");
    }

}