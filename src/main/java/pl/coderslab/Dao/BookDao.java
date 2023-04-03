package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entity.Book;
import pl.coderslab.Entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;
    //create
    public void saveBook(Book book) {
        entityManager.persist(book);
    }
    //pobieranie po id
    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }
    //aktualizacja
    public void update(Book book) {
        entityManager.merge(book);
    }
    //usuwanie
    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book)); }


}
