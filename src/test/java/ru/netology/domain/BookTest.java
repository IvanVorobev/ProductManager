package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {
    Book book = new Book(3, 300, "Jane Eyre", "Charlotte Bronte");

    @Test
    void shouldMatchBookByName() {
        boolean actual = book.matches("Jane Eyre");
        assertTrue(actual);
    }

    @Test
    void shouldMatchBookByAuthor() {
        boolean actual = book.matches("Charlotte Bronte");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchBookByName() {
        boolean actual = book.matches("Airport");
        assertFalse(actual);
    }

    @Test
    void shouldNotMatchBookByAuthor() {
        boolean actual = book.matches("Wels");
        assertFalse(actual);
    }
}