package pl.javastar.people;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        List<Person> all = personRepository.findAll();
        Person person = new Person();
        model.addAttribute("employeeToCreate", person);
        model.addAttribute("employees", all);
        return "index";
    }

    @PostMapping("/add")
    public String addPerson(Person person) {
        personRepository.save(person);
        return "redirect:/";
    }
}
