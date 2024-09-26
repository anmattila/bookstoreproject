package project.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;

@RestController
public class BookRestController {

    @Autowired
    private BookRepository repositoryB;

    @GetMapping("/books")
    public @ResponseBody List<Book> getBooksRest() {
        List<Book> books = (List<Book>) repositoryB.findAll();
        return books;
    }

    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getOneBookRest (
        @PathVariable(name = "id") Long bookid) {
            return repositoryB.findById(bookid);
        }

}
