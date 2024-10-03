package project.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;
import project.bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {

    // Spring-alusta luo sovelluksen käynnistyessä BookRepository-rajapintaa
    // toteuttavan luokan olion
    // ja kytkee olion BookController-luokasta luodun olion attribuuttiolioksi ?
    @Autowired
    private BookRepository repositoryB;

    @Autowired 
    private CategoryRepository repositoryC;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repositoryB.findAll());
        return "booklist";
    }
    
    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", repositoryC.findAll());
        return "addbook";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repositoryB.findById(bookId));
        // tallennus / muutos nykyisen kirja idn mukaan
        model.addAttribute("categories", repositoryC.findAll());
        return "editbook";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        repositoryB.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}") // id polkumuuttuja, ei parametritieto
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repositoryB.deleteById(bookId);
        return ("redirect:/booklist");
    }

}