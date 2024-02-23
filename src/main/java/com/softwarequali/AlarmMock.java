package com.softwarequali;

public class AlarmMock {

    private boolean wasAlarmTriggered = false;

    public void triggerAlarm() {
        wasAlarmTriggered = true;
        System.out.println("Alarm triggered");
    }

    public boolean wasAlarmTriggered() {
        return wasAlarmTriggered;
    }

}
