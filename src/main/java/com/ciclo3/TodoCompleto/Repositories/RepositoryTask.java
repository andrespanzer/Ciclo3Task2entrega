package com.ciclo3.TodoCompleto.Repositories;


import com.ciclo3.TodoCompleto.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTask extends JpaRepository<Task,String> {
}
