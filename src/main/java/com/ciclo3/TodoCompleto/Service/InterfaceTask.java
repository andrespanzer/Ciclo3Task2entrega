package com.ciclo3.TodoCompleto.Service;



import com.ciclo3.TodoCompleto.Models.Task;

import java.util.List;

public interface InterfaceTask {
    
    public List<Task> getTask();

    public Task getOnlyOneTask(String id) throws Exception;

    public String getCreateTask(Task TaskIn);

    public String setCreateTask(Task taskIn);

    public Task getUpdateTask(Task TaskIn) throws Exception;

    public String getDeleteTask(String id) throws Exception;
}
