package com.example.API.de.gerenciamento.de.tarefas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.API.de.gerenciamento.de.tarefas.Priority;
import com.example.API.de.gerenciamento.de.tarefas.Status;
import com.example.API.de.gerenciamento.de.tarefas.Model.Task;


import java.util.List;
import java.util.Optional;



public interface TaskRepository extends JpaRepository<Task, Long> {

@Transactional
    @Modifying
    @Query("UPDATE Task t SET " +
       "t.title = :title, " +
       "t.description = :description, " +
       "t.status = :status, " +
       "t.dueDate = :dueDate, " +
       "t.priority = :priority " +
       "WHERE t.id = :taskId")
    void updateStatus(@Param("taskId") Long taskId, @Param("status") String status);
    


    Optional<Task> findById(Long id);

    List<Task> findByStatus(Status status);

    List<Task> findByPriority(Priority priority);  // Corrigido aqui

    List<Task> findByDueDateBefore(java.time.LocalDate date);

    List<Task> findByDescriptionContaining(String keyword);

    void deleteById(Long id);

    
}