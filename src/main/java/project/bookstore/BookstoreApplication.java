package project.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (arg) -> {
			Book test1 = new Book("Kultahäkki", "Camilla Läckberg", 2019, 123456789, 11.90);
			Book test2 = new Book("Pohjoisen mytologia", "Neil Gaiman", 2019, 987654321, 11.90);
			repository.save(test1);
			repository.save(test2);
		}; 
	}
}