package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findByPesel(String pesel);
    List<Author> findAllByLastName(String lastName);
}
