package pl.transmar.budowa.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.transmar.budowa.entities.Person;
import pl.transmar.budowa.repos.PersonRepository;

import javax.validation.Valid;

@Controller
public class PersonController {
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }




    @GetMapping("/persons") //getting list of all persons
    public String mainPage(Model model) {
        model.addAttribute("listPersons", personRepository.findAll()); //
        return "persons";

    }


    @RequestMapping ("/new") //adding new Person
    public String getAllPersons(Person person) {
        return "add-person";
    }

    @PostMapping(value = "/persons", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)  //saving new person
    public String createPerson(Person person) {
        personRepository.save(person);
        return "redirect:/persons/";

    }

    @GetMapping("/edit/{id}")
    public String getPerson(@Valid @PathVariable long id, Model model){
        model.addAttribute("person", personRepository.getOne(id));
        return "edit-person";
    }


    @PostMapping("/persons/{id}") //updating person
    public String updatePerson(@Valid @PathVariable long id, Person person) {
        Person personToUpdate = personRepository.getOne(id);

        // changing only what was typed
        if (!person.getFirstName().isBlank()) {
            personToUpdate.setFirstName(person.getFirstName());
            log.info("First name found.");
        }
        if (!person.getLastName().isBlank()) {
            personToUpdate.setLastName(person.getLastName());
            log.info("Last name found");
        }
        if (!person.getRole().isBlank()) {
            personToUpdate.setRole(person.getRole());
            log.info("Role found.");
        }
        personRepository.save(personToUpdate);
        return "redirect:/persons/";
    }

    @GetMapping("/delete/{id}") //deleting person
    public String deletePerson(@Valid @PathVariable long id) {

        personRepository.deleteById(id);
        return "redirect:/persons/";
    }




}
