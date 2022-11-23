package com.ciclo3.TodoCompleto.Controllers;

import com.ciclo3.TodoCompleto.Models.Task;
import com.ciclo3.TodoCompleto.Service.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @Autowired
    private ServiceTask TaskBDX;

    @GetMapping("/TaskRegister")
    public String getTaskRegister(Model model){
        model.addAttribute("formTaskRegister", new Task());
        return "TaskRegister";
    }

    @PostMapping("/CreateTaskBD")
    public String CreateTask(@ModelAttribute("redirect:/WelcomeTask") Task TaskX){
        TaskBDX.setCreateTask(TaskX);
        return "redirect:/WelcomeTask";
    }

    @PostMapping("/deleteTaskBD/{idTask}")
    public String deleteTask(@PathVariable String id, Model model){
        try {
            TaskBDX.getDeleteTask(id);
            return "redirect:/WelcomeTask";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/updateTaskBD/{idTask}")
    public String updateTask(@PathVariable String id, Model model){
        try {
            model.addAttribute("TaskUpdate",TaskBDX.getOnlyOneTask(id));
            return "updateTaskNew";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping("/updateTaskBD")
    public String updateTask (@ModelAttribute("redirect:/WelcomeTask") Task TaskX){
        try {
            TaskBDX.getUpdateTask(TaskX);
            return "redirect:/WelcomeTask";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }


    @GetMapping("/taskList")
    public String getTaskList(Model model){
        model.addAttribute("Task",TaskBDX.getTask());
        return "TaskList";
    }

}
