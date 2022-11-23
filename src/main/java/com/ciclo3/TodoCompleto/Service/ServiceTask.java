package com.ciclo3.TodoCompleto.Service;


import com.ciclo3.TodoCompleto.Models.Task;
import com.ciclo3.TodoCompleto.Repositories.RepositoryTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceTask implements InterfaceTask {


    Date Today = new Date();

    @Autowired
    RepositoryTask repositoryTask;

    @Override
    public List<Task> getTask() {
        return repositoryTask.findAll();
    }

    @Override
    public Task getOnlyOneTask(String id) throws Exception {
        Optional<Task> TaskBD = repositoryTask.findById(id);
        if(TaskBD.isPresent()){
            return TaskBD.get();
        }
        throw new Exception("Id de Tarea no Encontrado");
    }

    @Override
    public String getCreateTask(Task TaskIn) {
        Optional<Task> TaskBD = repositoryTask.findById(TaskIn.getId());
        if(!TaskBD.isPresent()){
            repositoryTask.save(TaskIn);
            return ("Tarea Creada Con Exito");
        }

        return ("Id ya está en Uso");
    }

    @Override
    public String setCreateTask(Task TaskIn) {
        Optional<Task> TaskBD = repositoryTask.findById(TaskIn.getId());
        if(!TaskBD.isPresent()){
            repositoryTask.save(TaskIn);
            return "Task Creada con exito";

        }
        return ("Ese Id ya esta regitrado a una Task Existente");
    }
    @Override
    public Task getUpdateTask(Task TaskIn) throws Exception {
        Task TaskBD = getOnlyOneTask(TaskIn.getId());
        if(TaskIn.getTitle() != null && !TaskIn.getTitle().equals("")){
            TaskBD.setTitle(TaskIn.getTitle());
        }
        if(TaskIn.getDescription() != null && !TaskIn.getDescription().equals("")){
            TaskBD.setDescription(TaskIn.getDescription());
        }

        TaskBD.setUpdatedAt(Today);

        return repositoryTask.save(TaskBD);
    }

    @Override
    public String getDeleteTask(String id) throws Exception {
        Optional<Task> TaskBD = repositoryTask.findById(id);
        if(TaskBD.isPresent()){
            repositoryTask.deleteById(id);
            return "Tarea eliminada con exito";
        }

        throw new Exception("Tarea no encontrado");
    }
}
