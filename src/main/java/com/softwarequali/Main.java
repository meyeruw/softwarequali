package com.softwarequali;

public class Main {
    private int druck;
    private boolean akustischesSignalAusgeloest;
    private boolean betriebsfuehrerBenachrichtigt;

    public static void main(String[] args) {
        System.out.println(sayHello());
    }
    public static String sayHello() {
        return "Hello world!";
    }

    public void setDruck(int druck) {
        this.druck = druck;
        ueberpruefeDruck();
    }

    public boolean isAkustischesSignalAusgeloest() {
        return akustischesSignalAusgeloest;
    }

    public boolean isBetriebsfuehrerBenachrichtigt() {
        return betriebsfuehrerBenachrichtigt;
    }

    private void ueberpruefeDruck() {
        if (druck < 50) {
            // Kritischer Minimalwert erreicht
            akustischesSignalAusgeloest = true;
            betriebsfuehrerBenachrichtigt = true;
        } else {
            // Zurücksetzen der Zustände
            akustischesSignalAusgeloest = false;
            betriebsfuehrerBenachrichtigt = false;
        }
    }
}