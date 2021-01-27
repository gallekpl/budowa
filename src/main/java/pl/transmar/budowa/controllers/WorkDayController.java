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
import pl.transmar.budowa.entities.WorkDay;
import pl.transmar.budowa.repos.MachineRepository;
import pl.transmar.budowa.repos.PersonRepository;
import pl.transmar.budowa.repos.TaskRepository;
import pl.transmar.budowa.repos.WorkDayRepository;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WorkDayController {
    private static final Logger log = LoggerFactory.getLogger(WorkDayController.class);
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private WorkDayRepository workDayRepository;

    @GetMapping("/workdays") //getting list of all days
    public String getWorkDays(Model model) {
        model.addAttribute("listTasks", taskRepository.findAll()); //
        model.addAttribute("personsToString", personRepository.findAll().toString());
        model.addAttribute("workDayList", workDayRepository.findAll());
        return "workdays";

    }


    @RequestMapping("/new-workday") //adding new workday
    public String getAllWorkDays(WorkDay workDay, Model model) {
        //model.addAttribute("personsList", personRepository.findAll());
        //model.addAttribute("machinesList", machineRepository.findAll());
        model.addAttribute("workDayList", workDayRepository.findAll());
        return "add-workday";
    }

    @PostMapping(value = "/workdays", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createWorkDay(WorkDay workDay, Model model) {
        model.addAttribute("workDayList", workDayRepository.findAll());
        workDayRepository.save(workDay);
        return "redirect:/workdays/";

    }
/*
    @GetMapping("/edit-workday/{id}")
    public String getTask(@Valid @PathVariable long id, Model model){
        model.addAttribute("task", taskRepository.getOne(id));
        return "edit-task";
    }
*/

    @PostMapping("/workdays/{id}") //updating workday
    public String updateWorkday(@Valid @PathVariable long id, WorkDay workDay) {
        WorkDay workdayToUpdate = workDayRepository.getOne(id);

            workdayToUpdate.setDate(workDay.getDate());

            workdayToUpdate.setHoursWorked(workDay.getHoursWorked());


        workDayRepository.save(workdayToUpdate);
        return "redirect:/";
    }

    @GetMapping("/delete-workday/{dateString}") //deleting workday
    public String deleteWorkday(@Valid @PathVariable String dateString) throws ParseException {
        Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
        WorkDay workDayToDelete = workDayRepository.findByDate(date);
        workDayRepository.delete(workDayToDelete);
        return "redirect:/workdays/";
    }






}
