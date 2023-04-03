package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entity.Book;
import pl.coderslab.Entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;
    //create
    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }
    //pobieranie po id
    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }
    //aktualizacja
    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }
    //usuwanie
    public void delete(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher)); }
}
