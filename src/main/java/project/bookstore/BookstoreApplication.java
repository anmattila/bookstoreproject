package project.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;
import project.bookstore.domain.Category;
import project.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 		// heti ohjelman käynnistyksen jälkeen 
	public CommandLineRunner bookDemo(CategoryRepository repositoryC, BookRepository repositoryB) {
		return (arg) -> {

			Category thriller = new Category("Thiller");
			Category fantasy = new Category("Fantasy");
			repositoryC.save(thriller);
			repositoryC.save(thriller);

			Book book1 = new Book("Kultahäkki", "Camilla Läckberg", 2019, 123456789, 12.95, thriller);
			Book book2 = new Book("Pohjoisen mytologia", "Neil Gaiman", 2019, 987654321, 11.90, fantasy);
			repositoryB.save(book1);
			repositoryB.save(book2);
			
			repositoryB.findAll().forEach(book -> {
				System.out.println(book.toString());
			});
			repositoryC.findAll().forEach(category -> {
				System.out.println(category.toString());
			});
		}; 
	}
	
}

// one to many, book have 1 category and category can have multiple books
// so book needs categoryid -> book is owner of the relationship