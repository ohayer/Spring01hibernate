package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Entity.Author;
import pl.coderslab.Entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class ValidationController {
    private  Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    @ResponseBody
    public String checkBook() {

        Book book = new Book();
        book.setTitle("1234");


        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        if (constraintViolations.isEmpty()) {
            return "ok";
        } else {
            return constraintViolations
                    .stream()
                    .map(cv -> String.join(" : ", cv.getPropertyPath().toString(), cv.getMessage()))
                    .collect(Collectors.joining("<br/>"));
        }

    }
}
