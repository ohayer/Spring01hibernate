package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {
    @GetMapping(value = "/" ,produces = "text/html; charset=utf-8")
    @ResponseBody
    public String hello() {
        return "Hello it's my Hibernate project" +
               "<br></br> <a href=\"http://localhost:8080/books\">Książki</a>";

    }
}
