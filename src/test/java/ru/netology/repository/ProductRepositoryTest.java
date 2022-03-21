package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    Book firstBook = new Book(1, "50 оттенков серого", 100, "Джеймс");
    Book secondBook = new Book(2, "11 минут", 150, "Коэльо");
    Book thirdBook = new Book(3, "Apple10", 200, "Роулинг");


    @Test
    void removeById() {
        ProductRepository repo = new ProductRepository();
        repo.save(firstBook);
        repo.save(secondBook);
        repo.save(thirdBook);

        repo.removeById(2);

        Product[] expected = new Product[]{firstBook, thirdBook};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void myTestException() {
        ProductRepository repo = new ProductRepository();
        repo.save(firstBook);
        repo.save(secondBook);
        repo.save(thirdBook);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(-3);
        });

    }


}
