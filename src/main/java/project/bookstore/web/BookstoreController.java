package project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//import project.bookstore.domain.Book;

@Controller
public class BookstoreController {

    @GetMapping("/index")
    public String getBook() {
         return "booklist";
    }

}


