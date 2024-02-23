package com.softwarequali;

public class PressureSensorMock {

    private double pressure;
    private double voltage;

    public PressureSensorMock(double pressure, double voltage) {
        this.pressure = pressure;
        this.voltage = voltage;
    }

    public double getPressure() {
        return this.pressure;
    }

    public double getVoltage() {
        return this.voltage;
    }

}
