package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Dao.AuthorDao;
import pl.coderslab.Dao.BookDao;
import pl.coderslab.Dao.PublisherDao;
import pl.coderslab.Entity.Author;
import pl.coderslab.Entity.Book;
import pl.coderslab.Entity.Publisher;
import pl.coderslab.respository.BookRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private BookRepository bookRepository;



    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/book/add", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String hello() {
        //searching for two authors
        Author author1 = authorDao.findByIdA(1);
        Author author2 = authorDao.findByIdA(2);
        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);


        Publisher publisher = Publisher.builder().name("Maciej").build();
        publisherDao.savePublisher(publisher);
        Book book = new Book();
        book.setTitle("Kopciuszek");
        book.setAuthor("Dawid Podsiadlo");
        book.setPublisher(publisher);
        book.setDescription("Bajka dla dzieci");

        //book set authors
       // book.setAuthors(authors);
        //book.setAuthors(List.of(author1,author2));
        book.setAuthors(Arrays.asList(author1,author2));
        //
        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId() + " oraz nazwa wydawcy to " + publisher.getName()
                + " a dwaj autorzy to " + author1.getFirstName() + " " + author1.getLastName()
                + " , " + author2.getFirstName()+ " " + author2.getLastName();
    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")

    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "redirect:http://localhost:8080/books";
    }
    @RequestMapping("/book/find/publisher")
    @ResponseBody
    public String findBookAllPublisher(){
        List<Book> book = bookDao.BookHavePublisher();
        return book.toString();
    }
    @RequestMapping("/books")
    public String allBooks(Model model){
        List<Book> book = bookDao.findAll();
        model.addAttribute("books", book);
        return "books";
    }
    @GetMapping(value = "/books/find/{title}", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String findBookByTitle(@PathVariable String title){
        Book book = bookRepository.findAllByTitle(title);
        if (book == null){
            return "Nie ma takiej książki";
        }else {
            return book.toString();
        }
    }
//    @GetMapping("/books/find/${title")
//    public Optional<Book> findBookByTitle(@PathVariable String title){
//        Optional<Book> book = bookRepository.findAllByTitle(title);
//        return book;
//    }
}
