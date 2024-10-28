package project.bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.bookstore.web.BookstoreController;
import project.bookstore.web.CategoryController;

@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookstoreController bookstoreController;
	@Autowired
	private CategoryController categoryController;

	@Test
	public void bookstoreLoads() {
		assertThat(bookstoreController).isNotNull();
	}

	@Test
	public void categoryLoads() {
		assertThat(categoryController).isNotNull();
	}

}
