package project.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.bookstore.domain.AppUser;
import project.bookstore.domain.AppUserRepository;
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
	public CommandLineRunner bookDemo(BookRepository repositoryB, CategoryRepository repositoryC, 
			AppUserRepository appUserRepository) {
		return (arg) -> {
 
			Category thriller = new Category("Thriller");
			Category fantasy = new Category("Fantasy");
			repositoryC.save(thriller);
			repositoryC.save(fantasy);

			Book book1 = new Book("Kultahäkki", "Camilla Läckberg", 2019, 123456789, 12.95, thriller);
			Book book2 = new Book("Pohjoisen mytologia", "Neil Gaiman", 2019, 987654321, 11.90, fantasy);
			repositoryB.save(book1);
			repositoryB.save(book2);

			repositoryC.findAll().forEach(category -> {
				System.out.println(category.toString());
			});

			for (Book book : repositoryB.findAll()) {
				System.out.println(book.toString());
			}
			// 2 eri tapaa tulostaa terminaliin

			AppUser user1 = new AppUser("user", "$2a$12$SQBEz/uB8nCpQt7/YEXXb.SzBxObAaeOsQdcsZOTwoPqMdZuGV7gO", "USER");
			AppUser user2 = new AppUser("admin", "$2a$12$DVzah1D6tgIYiPwg8j0stuOQ2ojreYWjFQZdpw5.BkBz9FQtyBepO", "ADMIN");
			appUserRepository.save(user1);
			appUserRepository.save(user2);

		};
	
	}
}

// one to many, book have 1 category and category can have multiple books
// so book needs categoryid -> book is owner of the relationship