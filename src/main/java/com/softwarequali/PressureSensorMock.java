package com.softwarequali;

public class PressureSensorMock {

    private double pressure;

    public void setPressure(double pressure) {
        this.pressure = pressure;
        System.out.println("Pressure set to " + pressure);
    }

    public double getPressure() {
        return this.pressure;
    }

}