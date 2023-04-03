package pl.coderslab.Dao;
import org.springframework.stereotype.Repository;
import pl.coderslab.Entity.Author;
import pl.coderslab.Entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }
    //pobieranie po id
    public Author findByIdA(long id) {
        return entityManager.find(Author.class, id);
    }
    //aktualizacja
    public void update(Author author) {
        entityManager.merge(author);
    }
    //usuwanie
    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author)); }

}
