package com.softwarequali;

public class PressureRangeHandlerMock {

    private PressureSensorMock pressureSensor;

    private AcousticSignalMock acousticSignal = new AcousticSignalMock();
    private NotificationMock notificationMock = new NotificationMock();
    private AlarmMock alarm = new AlarmMock();
    private EvacuationMock evacuation = new EvacuationMock();

    public PressureRangeHandlerMock(PressureSensorMock pressureSensor) {
        this.pressureSensor = pressureSensor;
    }

    public void checkPressure() {
        double pressure = pressureSensor.getPressure();
        double voltage = pressureSensor.getVoltage();

        if (voltage < 5) {
            handleLowPressure();
        } else {
            if (pressure > 500) {
                handleDangerousPressure();
            } else if (pressure > 300) {
                handleMaximumPressure();
            } else if (pressure >= 220) {
                handleHighPressure();
            } else if (pressure > 180) {
                handleOptimalPressure();
            } else if (pressure >= 50) {
                handleLowPressure();
            } else if (pressure < 50) {
                handleMinimumPressure();
            } else {
                handleInvalidPressure();
            }
        }
    }

    public void handleLowVoltage() {
        System.out.println("Low voltage detected");
        acousticSignal.sendSignal();
    }

    public void handleDangerousPressure() {
        System.out.println("Dangerous pressure detected");
        alarm.triggerAlarm();
        evacuation.initializeEvacuation();
    }

    public void handleMaximumPressure() {
        System.out.println("Maximum pressure detected");
        acousticSignal.sendSignal();
        notificationMock.notifyManager();
        notificationMock.notifyMaintenanceTeam();
    }

    public void handleHighPressure() {
        System.out.println("High pressure detected");
        notificationMock.notifyManager();
        notificationMock.notifyMaintenanceTeam();
    }

    public void handleOptimalPressure() {
        System.out.println("Optimal pressure detected");
    }

    public void handleLowPressure() {
        System.out.println("Low pressure detected");
        notificationMock.notifyManager();
        notificationMock.notifyMaintenanceTeam();
    }

    public void handleMinimumPressure() {
        System.out.println("Minimum pressure detected");
        acousticSignal.sendSignal();
        notificationMock.notifyManager();
    }

    public void handleInvalidPressure() {
        System.out.println("Invalid pressure detected");
    }

    public PressureSensorMock getPressureSensor() {
        return pressureSensor;
    }

    public AcousticSignalMock getAcousticSignal() {
        return acousticSignal;
    }

    public NotificationMock getNotificationMock() {
        return notificationMock;
    }

    public AlarmMock getAlarm() {
        return alarm;
    }

    public EvacuationMock getEvacuation() {
        return evacuation;
    }
}
