package com.softwarequali;

public class EvacuationMock {
    
    private boolean wasEvacuationInitialized = false;

    public void initializeEvacuation() {
        wasEvacuationInitialized = true;
        System.out.println("Evacuation initialized");
    }

    public boolean wasEvacuationTriggered() {
        return wasEvacuationInitialized;
    }

}
