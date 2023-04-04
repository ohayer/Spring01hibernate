package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entity.Author;
import pl.coderslab.Entity.Book;
import pl.coderslab.Entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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
                book : entityManager.merge(book));
    }

    public List<Book> BookHavePublisher() {
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN FETCH b.authors WHERE b.publisher IS NOT NULL");
        return query.getResultList();
    }

    public List<Book> BookHavePublisherParam(Publisher pub){
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN fetch b.authors WHERE ISNULL(:pub)");
        query.setParameter("pub",pub);
        query.setMaxResults(5);
        return query.getResultList();
    }
    public List<Book> BookHaveAuthorParam(Author author){
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN FETCH b.authors WHERE ISNULL(:author)");
        query.setParameter("author",author);
        return query.getResultList();
    }
}
