package com.ciclo3.TodoCompleto.Repositories;


import com.ciclo3.TodoCompleto.Models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProfile extends JpaRepository<Profile,Long> {
}
