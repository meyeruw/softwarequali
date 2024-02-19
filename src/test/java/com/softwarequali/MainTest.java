package com.softwarequali;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testHelloWorld() {
        // Arrange
        Main main = new Main();

        // Act
        String result = main.sayHello();

        // Assert
        assertEquals("Hello world!", result);
    }
}
