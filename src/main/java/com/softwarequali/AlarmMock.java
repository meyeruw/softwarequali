package com.softwarequali;

public class AlarmMock {
    private boolean wasAlarmTriggered = false;

    public void triggerAlarm() {
        wasAlarmTriggered = true;
    }

    public boolean wasAlarmTriggered() {
        return wasAlarmTriggered;
    }
}
