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
import pl.transmar.budowa.entities.Task;
import pl.transmar.budowa.repos.MachineRepository;
import pl.transmar.budowa.repos.PersonRepository;
import pl.transmar.budowa.repos.TaskRepository;

import javax.validation.Valid;

@Controller
public class TaskController {
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MachineRepository machineRepository;

    @GetMapping("/tasks") //getting list of all tasks
    public String getTasks(Model model) {
        model.addAttribute("listTasks", taskRepository.findAll()); //
        model.addAttribute("personsToString", personRepository.findAll().toString());
        return "tasks";

    }


    @RequestMapping("/new-task") //adding new Task
    public String getAllTasks(Task task, Model model) {
        model.addAttribute("personsList", personRepository.findAll());
        model.addAttribute("machinesList", machineRepository.findAll());
        return "add-task";
    }

    @PostMapping(value = "/tasks", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)  //saving new person
    public String createTask(Task task, Model model) {
        model.addAttribute("personsToString", personRepository.findAll().toString());
        taskRepository.save(task);
        return "redirect:/tasks/";

    }

    @GetMapping("/edit-task/{id}")
    public String getTask(@Valid @PathVariable long id, Model model){
        model.addAttribute("task", taskRepository.getOne(id));
        return "edit-task";
    }


    @PostMapping("/tasks/{id}") //updating task
    public String updateTask(@Valid @PathVariable long id, Task task) {
        Task taskToUpdate = taskRepository.getOne(id);

            taskToUpdate.setMachines(task.getMachines());

            taskToUpdate.setDescription(task.getDescription());


        taskRepository.save(taskToUpdate);
        return "redirect:/";
    }

    @GetMapping("/delete-task/{id}") //deleting person
    public String deleteTask(@Valid @PathVariable long id) {

        taskRepository.deleteById(id);
        return "redirect:/";
    }




}
