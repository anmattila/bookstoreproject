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

	@Bean 		// heti ohjelman käynnistyksen jälkeen 
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (arg) -> {
			Book test1 = new Book("Kultahäkki", "Camilla Läckberg", 2019, 123456789, 12.95);
			Book test2 = new Book("Pohjoisen mytologia", "Neil Gaiman", 2019, 987654321, 11.90);
			repository.save(test1);
			repository.save(test2);

			/*  esimerkiksi, voi olla joku muu
			repository.findAll().forEach(book ->{
				System.out.println(book.toString());
			});
			*/
		}; 
	}
}