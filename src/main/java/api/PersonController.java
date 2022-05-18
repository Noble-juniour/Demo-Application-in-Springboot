package api;

import module.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController{

    private final PersonService personService;
    @Autowired
    //springboot injects the actual service to the constructor
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    //this one is served as a post request
    @PostMapping
   public void addPerson(@RequestBody Person person)
    {
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople()
    {
     return personService.getAllPeople();
    }
}
