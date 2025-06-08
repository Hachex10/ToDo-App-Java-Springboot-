package com.app.todoApp.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import com.app.todoApp.Entitity.Task;
import com.app.todoApp.Service.TaskService;




@Controller
//@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
       public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

     @PostMapping
       public String createTask(@RequestParam String title){
       
        taskService.createTask(title);
        return "redirect:/";
    }

    

     @GetMapping("/{id}/delete")
       public String deleteTask(@PathVariable Long id){
       taskService.deleteTask(id);
        return "redirect:/";
    }


    @GetMapping("/{id}/edit")
       public String editTask(@PathVariable Long id){
       taskService.editTask(id);
        return "redirect:/";
    }
    
    

}
