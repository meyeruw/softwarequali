package com.softwarequali;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testHelloWorld() {
        // Act
        String result = Main.sayHello();

        // Assert
        assertEquals("Hello world!", result);
    }

    @Test
    public void testKritischerMinimalwertUnterdruck() {
        Main main = new Main();

        // Setze den Druck auf einen Wert unter 50 bar (kritischer Minimalwert)
        main.setDruck(45);

        // Überprüfe, ob das akustische Signal ausgelöst wird
        assertTrue(main.isAkustischesSignalAusgeloest());

        // Überprüfe, ob der Betriebsführer benachrichtigt wurde
        assertTrue(main.isBetriebsfuehrerBenachrichtigt());
    }
}