package project.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import project.bookstore.domain.BookRepository;
//import project.bookstore.domain.Book;

@Controller
public class BookstoreController {

    // Spring-alusta luo sovelluksen käynnistyessä CarRepository-rajapintaa toteuttavan luokan olion 
	// ja kytkee olion CarController-luokasta luodun olion attribuuttiolioksi
    @Autowired
    private BookRepository repository;

    @GetMapping("/index")
    public String getBooks(Model model) {
        model.addAttribute("books", repository.findAll());
         return "booklist";
    }

}


