package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Dao.AuthorDao;
import pl.coderslab.Dao.BookDao;
import pl.coderslab.Entity.Author;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController{

     private AuthorDao dao;
    public AuthorController(AuthorDao authorDao) {
        this.dao = authorDao;
    }
    @RequestMapping(value = "/author/add", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String hello() {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bob");
        dao.saveAuthor(author);
        return"added";
    }
    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Author author = dao.findByIdA(id);
        return "Twój Autor " + author.getFirstName() + " "  + author.getLastName();
    }
    @RequestMapping("/author/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String firstName ) {
        Author author = dao.findByIdA(id);
        author.setFirstName(firstName);
        dao.update(author);
        return author.toString();
    }
    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Author author = dao.findByIdA(id);
        dao.delete(author);
        return "deleted";
    }
}