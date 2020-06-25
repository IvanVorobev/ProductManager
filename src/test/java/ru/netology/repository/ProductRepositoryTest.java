package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Book item1 = new Book(1, 100, "Shantaram", "Gregory David Roberts");
    Book item2 = new Book(2, 200, "Harry Potter", "J.K. Rowling");
    Book item3 = new Book(3, 300, "Jane Eyre", "Charlotte Bronte");
    Book item4 = new Book(4, 400, "Airport", "Arthur Hailey");
    Smartphone item5 = new Smartphone(5, 30000, "Galaxy S20", "Samsung");
    Smartphone item6 = new Smartphone(6, 20000, "Mi10", "Xiaomi");
    Smartphone item7 = new Smartphone(7, 5000, "7A", "Honor");
    Smartphone item8 = new Smartphone(8, 10000, "Y7", "Huawei");
    Smartphone itemNew = new Smartphone(9, 30000, "A320", "ZTE");

    @BeforeEach
    void manageAdd() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        repository.save(item7);
        repository.save(item8);
    }

    @Test
    void shouldSave() {
        repository.save(itemNew);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{item1, item2, item3, item4, item5, item6, item7, item8, itemNew};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldremoveById() {
        repository.removeById(7);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{item1, item2, item3, item4, item5, item6, item8};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Product actual = repository.findById(1);
        assertEquals(item1, actual);
    }

    @Test
    void shoulNotdFindByNotValidId() {
        Product actual = repository.findById(10);
        assertNull(actual);
    }
}