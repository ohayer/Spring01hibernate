package pl.coderslab.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Dao.BookDao;
import pl.coderslab.Dao.PublisherDao;
import pl.coderslab.Entity.Book;
import pl.coderslab.Entity.Publisher;

import java.util.Collection;
import java.util.List;

@Controller
public class BookFormController {
   private BookDao bookDao;
   private PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/books/form")
    public String PostForm(Model model) {
        Book book = new Book();
        Publisher publisher = new Publisher();
        model.addAttribute("book", book);
        model.addAttribute("publisher", publisher);
        return "bookform";
    }
    @PostMapping("/books/form")
    @ResponseBody
    public List<Book> StudentAdd(Book book) {
        bookDao.saveBook(book);
        return bookDao.findAll();
    }
    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.getList();
    }
}
