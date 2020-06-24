package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book item1 = new Book(1, 100, "Shantaram", "Gregory David Roberts");
    Book item2 = new Book(2, 200, "Harry Potter", "J.K. Rowling");
    Book item3 = new Book(3, 300, "Jane Eyre", "Charlotte Bronte");
    Book item4 = new Book(4, 400, "Airport", "Arthur Hailey");
    Smartphone item5 = new Smartphone(5, 30000, "Galaxy S20", "Samsung");
    Smartphone item6 = new Smartphone(6, 20000, "Mi10", "Xiaomi");
    Smartphone item7 = new Smartphone(7, 5000, "7A", "Honor");
    Smartphone item8 = new Smartphone(8, 10000, "Y7", "Huawei");

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
    void searchByBookName() {
        Product[] expected = new Product[]{item4};
        Product[] actual = manager.searchBy("Airport");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookAuthor() {
        Product[] expected = new Product[]{item2};
        Product[] actual = manager.searchBy("J.K. Rowling");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookNotValidAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Tolstoy");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[]{item8};
        Product[] actual = manager.searchBy("Y7");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = new Product[]{item5};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneNotValidManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Sony");
        assertArrayEquals(expected, actual);
    }
}
