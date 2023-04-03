package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Dao.PublisherDao;
import pl.coderslab.Entity.Publisher;

@Controller
public class PublisherController {
    private final PublisherDao dao;
    public PublisherController(PublisherDao dao) {
        this.dao = dao;
    }
    @RequestMapping(value = "/publisher/add", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String add() {
       Publisher publisher = new Publisher();
       publisher.setName("Wacław");
        dao.savePublisher(publisher);
        return "Id dodanej książki to:"
                + publisher.getId();
    }
    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
       Publisher publisher = dao.findById(id);

        return publisher.getName();
    }
    @RequestMapping("/publisher/update/{id}/{title}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name ) {
        Publisher publisher = dao.findById(id);
        publisher.setName(name);
        dao.update(publisher);
        return "Updated";
    }
    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
       Publisher publisher = dao.findById(id);
        dao.delete(publisher);
        return "deleted";
    }
}
