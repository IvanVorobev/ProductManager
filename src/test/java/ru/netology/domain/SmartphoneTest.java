package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(5, 30000, "Galaxy S20", "Samsung");

    @Test
    void shouldMatchSmartByName() {
        boolean actual = smartphone.matches("Galaxy S20");
        assertTrue(actual);
    }

    @Test
    void shouldMatchSmartByManufacturer() {
        boolean actual = smartphone.matches("Samsung");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchSmartByName() {
        boolean actual = smartphone.matches("Galaxy");
        assertFalse(actual);
    }

    @Test
    void shouldNotMatchSmartByManufacturer() {
        boolean actual = smartphone.matches("Sony");
        assertFalse(actual);
    }
}