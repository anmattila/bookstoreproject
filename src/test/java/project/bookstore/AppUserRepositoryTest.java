package project.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import project.bookstore.domain.AppUser;
import project.bookstore.domain.AppUserRepository;

@SpringBootTest
@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository repoU;

    @Test
    public void createNewUser() {
        AppUser user = new AppUser("name", "password", "role");
        repoU.save(user);
        assertThat(repoU.getId()).isNotNull();
    }

    @Test
    public void deleteUser() {
        AppUser user = new AppUser("name", "password", "role");
        repoU.save(user);
        repoU.deleteById(repoU.getId());
        assertThat(repoU.findById()).isEmpty();
    }

    @Test
    public void searchUser() {
        AppUser user = new AppUser("username", "password", "role");
        repoU.save(user);
        repoU.findByUsername("username");
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("user");
    }
}
