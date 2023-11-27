package com.example.API.de.gerenciamento.de.tarefas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.API.de.gerenciamento.de.tarefas.Model.Task;
import com.example.API.de.gerenciamento.de.tarefas.Repository.TaskRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.API.de.gerenciamento.de.tarefas.Status;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Transactional
    public Task createTask(Task task) {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar a tarefa");
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public Task updateTask(Long id, Task updatedTask) {
        try {
            Task existingTask = taskRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Task not found"));

            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setPriority(updatedTask.getPriority());

            // Não é necessário chamar save após as atualizações, pois o objeto já está gerenciado
            return existingTask;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public Task patchTask(Long id, Status status) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    
        if (status != null) {
            existingTask.setStatus(status);
        }
    
        return existingTask;
    }
}
