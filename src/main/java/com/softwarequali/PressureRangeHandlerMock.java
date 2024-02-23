package com.softwarequali;

public class PressureRangeHandlerMock {

    private PressureSensorMock pressureSensor;

    private AcousticSignalMock acousticSignal = new AcousticSignalMock();
    private NotificationMock notificationMock = new NotificationMock();
    private AlarmMock alarm = new AlarmMock();
    private EvacuationMock evacuation = new EvacuationMock();
    private LogSenderMock logSender = new LogSenderMock();

    public PressureRangeHandlerMock(PressureSensorMock pressureSensor) {
        this.pressureSensor = pressureSensor;
    }

    public void checkPressure() {
        double pressure = pressureSensor.getPressure();
        double voltage = pressureSensor.getVoltage();

        if (voltage < 5.0) {
            handleLowVoltage();
        } else {
            if (pressure > 500.0) {
                handleDangerousPressure();
            } else if (pressure > 300.0) {
                handleMaximumPressure();
            } else if (pressure >= 220.0) {
                handleHighPressure();
            } else if (pressure > 180.0) {
                handleOptimalPressure();
            } else if (pressure >= 50.0) {
                handleLowPressure();
            } else if (pressure < 50.0) {
                handleMinimumPressure();
            } else {
                handleInvalidPressure();
            }
        }
    }

    public void handleLowVoltage() {
        logSender.sendLog("Voltage is under 5.0 (low)");
        acousticSignal.sendSignal();
    }

    public void handleDangerousPressure() {
        logSender.sendLog("Pressure is above 500.0 (dangerous)");
        alarm.triggerAlarm();
        evacuation.initializeEvacuation();
    }

    public void handleMaximumPressure() {
        logSender.sendLog("Pressure is above 300.0 (maximum)");
        acousticSignal.sendSignal();
        notificationMock.notifyManager();
        notificationMock.notifyMaintenanceTeam();
    }

    public void handleHighPressure() {
        logSender.sendLog("Pressure is between 220.0 and 300.0 (high)");
        notificationMock.notifyManager();
        notificationMock.notifyMaintenanceTeam();
    }

    public void handleOptimalPressure() {
        logSender.sendLog("Pressure is above 180.0 and below 220.0 (optimal)");
    }

    public void handleLowPressure() {
        logSender.sendLog("Pressure is between 50.0 and 180.0 (low)");
        notificationMock.notifyManager();
        notificationMock.notifyMaintenanceTeam();
    }

    public void handleMinimumPressure() {
        logSender.sendLog("Pressure is under 50.0 (minimum)");
        acousticSignal.sendSignal();
        notificationMock.notifyManager();
    }

    public void handleInvalidPressure() {
        logSender.sendLog("Pressure is invalid");
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

    public LogSenderMock getLogSender() {
        return logSender;
    }

}
