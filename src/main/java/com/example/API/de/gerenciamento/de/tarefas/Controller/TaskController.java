package com.example.API.de.gerenciamento.de.tarefas.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.API.de.gerenciamento.de.tarefas.Status;
import com.example.API.de.gerenciamento.de.tarefas.Service.TaskService;
import com.example.API.de.gerenciamento.de.tarefas.Model.Task;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
@Api(tags = "Tarefa Controller", description = "Operações relacionadas a tarefas")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }

    @ApiOperation("Atualiza parcialmente uma tarefa (PATCH)")
@PatchMapping("/{id}")
public ResponseEntity<Task> patchTask(
        @PathVariable Long id,
        @ApiParam(value = "Atualizar status da tarefa", allowableValues = "TODO, IN_PROGRESS, DONE") @RequestParam(required = false) Status status) {
    Task updatedTask = taskService.patchTask(id, status);
    return ResponseEntity.ok(updatedTask);
}
}
