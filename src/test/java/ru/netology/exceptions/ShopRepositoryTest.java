package ru.netology.exceptions;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Рубашка", 1990);
    Product product2 = new Product(2, "Футболка", 399);
    Product product3 = new Product(3, "Книга", 69);

    @Test
    public void shouldDelete() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(1);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotDelete() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(77);
        });
    }

}