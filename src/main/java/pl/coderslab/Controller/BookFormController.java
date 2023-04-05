package pl.coderslab.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.Dao.AuthorDao;
import pl.coderslab.Dao.BookDao;
import pl.coderslab.Dao.PublisherDao;
import pl.coderslab.Entity.Author;
import pl.coderslab.Entity.Book;
import pl.coderslab.Entity.Publisher;

import java.util.Collection;
import java.util.List;

@Controller
public class BookFormController {
    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/books/form")
    public String PostForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "bookform";
    }

    @PostMapping("/books/form")
    public String BookAdd(@ModelAttribute("book") @Validated Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "bookform";
        }
        bookDao.saveBook(book);
        return "redirect:/books";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.getList();
    }

    @ModelAttribute("authors")
    public Collection<Author> authors() {
        return this.authorDao.findAll();
    }
}
