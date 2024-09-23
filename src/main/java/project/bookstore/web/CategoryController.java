package project.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import project.bookstore.domain.Category;
import project.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repositoryC;

    @GetMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", repositoryC.findAll());
        return "categorylist";
    }

    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/savecategory")
    public String saveCategory(Category category) {
        repositoryC.save(category);
        return "redirect:/categorylist";
    }

}
