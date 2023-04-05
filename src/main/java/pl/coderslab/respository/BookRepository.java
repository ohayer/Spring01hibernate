package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
   Book findAllByTitle(String title);
}
