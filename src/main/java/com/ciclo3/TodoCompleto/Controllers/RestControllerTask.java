package com.ciclo3.TodoCompleto.Controllers;


import com.ciclo3.TodoCompleto.Models.Answer;
import com.ciclo3.TodoCompleto.Models.Task;
import com.ciclo3.TodoCompleto.Service.InterfaceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerTask {


    @Autowired
    InterfaceTask interfaceTask;

    @GetMapping("/TaskList")
    public ResponseEntity<List<Task>> getTask(){
        return new ResponseEntity<>(interfaceTask.getTask(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/OneTask/{id}")
    public ResponseEntity<Object> getTaskPath(@PathVariable String id){
        try{
            Task TaskX = interfaceTask.getOnlyOneTask(id);
            return new ResponseEntity<>(TaskX,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/CreateTask")
    public ResponseEntity<String> PostCreateTask(@RequestBody Task TaskX){
        try{
            String message = interfaceTask.getCreateTask(TaskX);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/UpdateTask")
    public ResponseEntity<Answer> putUpdateTask(@RequestBody Task TaskX){
        try{
            Task TaskBD = interfaceTask.getUpdateTask(TaskX);
            return new ResponseEntity<>(new Answer("Actualizacion exitosa", TaskBD),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Answer(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/DeleteTask/{id}")
    public ResponseEntity<String> DeleteTask(@PathVariable String id){
        try{
            String message = interfaceTask.getDeleteTask(id);
            return new ResponseEntity<>(message,HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
