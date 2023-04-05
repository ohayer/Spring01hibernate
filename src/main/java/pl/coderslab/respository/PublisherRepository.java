package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    Publisher findById(int id);
    Publisher findAllByNameStartingWith(String name);
}
