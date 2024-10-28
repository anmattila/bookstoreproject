package project.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;

@SpringBootTest
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repoB;

    @Test
    public void createNewBook() {
        Book book = new Book("Book title", "Author", 2024, 1234567, 10.10, null);
        repoB.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBookFromList() {
        Book book = new Book("Book title", "Author", 2024, 1234567, 10.10, null);
        repoB.save(book);
        repoB.deleteById(book.getId());
        assertThat(repoB.findById(book.getId()).isEmpty());
    }

}


// Add JPA repository tests (for all repositories)
// Test create, delete and search functionalities