package project.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;

@Controller
public class BookstoreController {

    // Spring-alusta luo sovelluksen käynnistyessä BookRepository-rajapintaa toteuttavan luokan olion 
	// ja kytkee olion BookController-luokasta luodun olion attribuuttiolioksi ?
    @Autowired
    private BookRepository repository;

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
         return "booklist"; 
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    
    @PostMapping("/save")
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }
    
    @GetMapping("/delete/{id}")         // id polkumuuttuja, ei parametritieto
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return ("redirect:/booklist");
    }

    @GetMapping("/edit/{id}") 
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        // tallennus / muutos nykyisen kirja idn mukaan
        return "editbook";
    }
    
}

