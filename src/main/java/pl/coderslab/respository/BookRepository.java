package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
   Book findAllByTitle(String title);
  // Optional<Book> findAllByTitle(String title);
   List<Book> findBookByPublisher(String publisher);
   List<Book> findBookByAuthor(String author);
   Book findBookByAuthorOrderByTitle(String author);
}
