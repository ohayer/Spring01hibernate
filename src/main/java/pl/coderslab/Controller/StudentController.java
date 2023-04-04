package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.klasa.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping ("/student")
public class StudentController {


//    @GetMapping("form")
//    public String form() {
//        return "studentform";
//    }
    @GetMapping("/add")
    public String showStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student",student);
        return "studentform";
    }
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }
    @ModelAttribute("program")
    public List<String> programs() {
        return Arrays.asList("Java","Android","JavaScript","Php","C++");
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("taniec","jazda na motorze","programowanie","czytanie","sztuki walki","gra w szachy");
    }
    @PostMapping("/add")
    @ResponseBody
    public String StudentAdd(Student student) {
     return student.toString();
    }
}
