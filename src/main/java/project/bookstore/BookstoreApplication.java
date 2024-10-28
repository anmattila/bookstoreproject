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

	@Bean
	public CommandLineRunner bookDemo(BookRepository repositoryB, CategoryRepository repositoryC, 
			AppUserRepository appUserRepository) {
		return (arg) -> {
 
			Category thriller = new Category("Thriller");
			Category fantasy = new Category("Fantasy");
			Category romance = new Category("Romance");
			Category scifi = new Category("Sci-fi");
			Category mystery = new Category("Mystery");
			repositoryC.save(thriller);
			repositoryC.save(fantasy);
			repositoryC.save(romance);
			repositoryC.save(scifi);
			repositoryC.save(mystery);

			Book book1 = new Book("Women Without Nercy", "Camilla Läckberg", 2018, 123456789, 14.95, thriller);
			Book book2 = new Book("The Secret Histroy", "Donna Tartt", 1992, 987654321, 28.80, mystery);
			Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, 456789321, 26.50, fantasy);
			Book book4 = new Book("This Is How You Lose the Time War", "El-Mohtarand & Gladstone", 2019, 387652194, 16.20, scifi);
			repositoryB.save(book1);
			repositoryB.save(book2);
			repositoryB.save(book3);
			repositoryB.save(book4);

			// 2 eri tapaa tulostaa terminaliin loggerin lisäksi
			repositoryC.findAll().forEach(category -> {
				System.out.println(category.toString());
			});
			for (Book book : repositoryB.findAll()) {
				System.out.println(book.toString());
			}
			
			AppUser user1 = new AppUser("user", "$2a$12$SQBEz/uB8nCpQt7/YEXXb.SzBxObAaeOsQdcsZOTwoPqMdZuGV7gO", "USER");
			AppUser user2 = new AppUser("admin", "$2a$12$DVzah1D6tgIYiPwg8j0stuOQ2ojreYWjFQZdpw5.BkBz9FQtyBepO", "ADMIN");
			appUserRepository.save(user1);
			appUserRepository.save(user2);

		};
	
	}
}

// one to many, book have 1 category and category can have multiple books
// so book needs categoryid -> book is owner of the relationship