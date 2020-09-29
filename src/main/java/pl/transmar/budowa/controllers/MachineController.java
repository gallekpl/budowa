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
import pl.transmar.budowa.entities.Machine;
import pl.transmar.budowa.repos.MachineRepository;
import pl.transmar.budowa.repos.PersonRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping
public class MachineController {
    private static final Logger log = LoggerFactory.getLogger(MachineController.class);
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private PersonRepository personRepository;
    @GetMapping("/machines")
    public String mainPage(Model model) {
        model.addAttribute("listMachines", machineRepository.findAll());
        return "machines";

    }
    @GetMapping("/machines/{id}")
    public Optional<Machine> getMachine(@Valid @PathVariable long id) {
       return machineRepository.findById(id);
    }

    @RequestMapping ("/new-machine") //new Machine
    public String getAllMachines(Machine machine, Model model) {
        model.addAttribute("personsList", personRepository.findAll());
        return "add-machine";
    }


    @PostMapping(value = "/machines", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)  //save
    public String createMachine(Machine machine) {
        machineRepository.save(machine);
        return "redirect:/";
    }

    @GetMapping("/edit-machine/{id}")
    public String getPerson(@Valid @PathVariable long id, Model model){
        model.addAttribute("machine", machineRepository.getOne(id));
        model.addAttribute("personsList", personRepository.findAll());
        return "edit-machine";
    }

    @PostMapping("/machines/{id}") //updating person
    public String updateMachine(@Valid @PathVariable long id, Machine machine) {
        Machine machineToUpdate = machineRepository.getOne(id);

        // changing only what was typed
        if (!machine.getName().isBlank()) {
            machineToUpdate.setName(machine.getName());

        }



        machineToUpdate.setPerson(machine.getPerson());
        machineToUpdate.setType(machine.getType());
        machineRepository.save(machineToUpdate);
        return "redirect:/machines/";
    }

    @GetMapping("/delete-machine/{id}") //deleting person
    public String deleteMachine(@Valid @PathVariable long id) {

        machineRepository.deleteById(id);
        return "redirect:/machines/";
    }

}
