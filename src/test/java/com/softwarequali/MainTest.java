package com.softwarequali;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testHelloWorld() {
        // Act
        String result = Main.sayHello();

        // Assert
        assertEquals("Hello world!", result);
    }
}
