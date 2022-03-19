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
    private ProductManager manager = new ProductManager(repository);

    //Подготовка данных
    Book firstBook = new Book(1, "50 оттенков серого", 100, "Джеймс");
    Book secondBook = new Book(2, "11 минут", 150, "Коэльо");
    Book thirdBook = new Book(3, "Apple10", 200, "Роулинг");
    Smartphone firstPhone = new Smartphone(4, "Apple7", 20_000, "Apple");
    Smartphone secondPhone = new Smartphone(5, "Apple10", 200_000, "Apple");
    Smartphone thirdPhone = new Smartphone(6, "Samsung X2", 1500, "Samsung");

    @BeforeEach
    public void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);

    }

    @Test
    public void shouldFindAuthorBook() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Коэльо");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNamePhone() {
        Product[] expected = new Product[]{firstPhone};
        Product[] actual = manager.searchBy("Apple7");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("50 оттенков серого");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneCreator() {
        Product[] expected = new Product[]{thirdPhone};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneBookName() {
        Product[] expected = new Product[]{thirdBook, secondPhone};
        Product[] actual = manager.searchBy("Apple10");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindPhoneName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Книга");

        assertArrayEquals(expected, actual);
    }
}



