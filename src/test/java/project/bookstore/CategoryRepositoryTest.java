package project.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import project.bookstore.domain.Category;
import project.bookstore.domain.CategoryRepository;

@SpringBootTest
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repoC;

    @Test 
    public void createNewCategory() {
        Category category = new Category("children");
        repoC.save(category);
        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void deleteCategory() {
        Category category = new Category("children");
        repoC.save(category);
        repoC.deleteById(category.getCategoryid());
        assertThat(category.getCategoryid()).isNull();
    }

    @Test
    public void findCategoryByName() {
        Category category = new Category("children");
        repoC.save(category);
        List<Category> categories = repoC.findByName("children");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("children");
    }

}
