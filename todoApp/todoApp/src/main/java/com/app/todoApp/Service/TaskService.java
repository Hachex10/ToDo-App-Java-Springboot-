package com.app.todoApp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todoApp.Entitity.Task;
import com.app.todoApp.Repository.TaskRepository;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
       return taskRepository.findAll();
       
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
       taskRepository.deleteById(id);;
    }

    public void editTask(Long id) {
       Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }

}
