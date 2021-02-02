package pl.transmar.budowa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.transmar.budowa.other.SearchDTO;
import pl.transmar.budowa.repos.MachineRepository;
import pl.transmar.budowa.repos.PersonRepository;
import pl.transmar.budowa.repos.TaskRepository;
import pl.transmar.budowa.repos.WorkDayRepository;

@Controller
public class OtherController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private WorkDayRepository workDayRepository;



    @GetMapping("/")
    public String searchPage(Model model, SearchDTO searchDTO) {
        model.addAttribute("searchDTO", searchDTO);
        return "index";
    }

    @PostMapping("/")
    public String searchPost(SearchDTO searchDTO) {
        return "redirect:/test/"+searchDTO.getSearch();
    }

}
