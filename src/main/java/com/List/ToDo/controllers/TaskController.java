package com.List.ToDo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.List.ToDo.dto.TaskDTO;
import com.List.ToDo.entities.TaskEntity;
import com.List.ToDo.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("tarefas")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	// Criar tarefa (sem vínculo direto, usado apenas se necessário)
	@PostMapping
	public ResponseEntity<TaskEntity> createTask(@Valid @RequestBody TaskDTO dto) {
		TaskEntity task = taskService.createTask(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(task);
	}

	// Deletar tarefa
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {
		String result = taskService.deleteTask(id);
		return ResponseEntity.ok(result);
	}

	// Listar todas as tarefas
	@GetMapping
	public ResponseEntity<List<TaskEntity>> getAllTasks() {
		return ResponseEntity.ok(taskService.showTasks());
	}

	// Buscar tarefa por ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getTaskById(@PathVariable Long id) {
		Optional<TaskEntity> task = taskService.showTasksById(id);
		if (task.isPresent()) {
			return ResponseEntity.ok(task.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
		}
	}

	// Atualizar tarefa
	@PutMapping("/{id}")
	public ResponseEntity<TaskEntity> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDTO dto) {
		TaskEntity updatedTask = taskService.updateTask(id, dto);
		return ResponseEntity.ok(updatedTask);
	}
}