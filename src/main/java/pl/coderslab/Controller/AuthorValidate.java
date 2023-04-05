package pl.coderslab.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Entity.Author;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class AuthorValidate {
    private  Validator validator;

    public AuthorValidate(Validator validator) {
        this.validator = validator;
    }


    @GetMapping("/validate/author")
    @ResponseBody
    public String checkBook() {

        Author author = new Author();
        author.setPesel("123456781");

        Set<ConstraintViolation<Author>> constraintViolations = validator.validate(author);
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
