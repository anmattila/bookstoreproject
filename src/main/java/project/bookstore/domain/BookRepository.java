package project.bookstore.domain;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {

    // mihin entityyn viittaa/kuuluu ja mikä tyyppi
}
