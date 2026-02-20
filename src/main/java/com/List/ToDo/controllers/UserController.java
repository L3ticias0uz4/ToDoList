package com.List.ToDo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.List.ToDo.dto.UserDTO;
import com.List.ToDo.dto.TaskDTO;
import com.List.ToDo.entities.TaskEntity;
import com.List.ToDo.service.UserService;
import com.List.ToDo.service.TaskService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UserController {

	private final UserService userService;
	private final TaskService taskService;

	public UserController(UserService userService, TaskService taskService) {
		this.userService = userService;
		this.taskService = taskService;
	}

	// Criar usuário
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
	}

	// Listar todos os usuários
	@GetMapping
	public ResponseEntity<List<UserDTO>> listUsers() {
		return ResponseEntity.ok(userService.listUsers());
	}

	// Buscar usuário por ID
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	// Deletar usuário
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("Usuário excluído com sucesso!");
	}

	// Criar tarefa vinculada a um usuário
	@PostMapping("/{id}/tarefas")
	public ResponseEntity<TaskEntity> createTaskForUser(@PathVariable Long id, @Valid @RequestBody TaskDTO dto) {
		TaskEntity task = taskService.createTaskForUser(id, dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(task);
	}

	// Listar tarefas de um usuário específico
	@GetMapping("/{id}/tarefas")
	public ResponseEntity<List<TaskEntity>> getTasksByUser(@PathVariable Long id) {
		return ResponseEntity.ok(taskService.getTasksByUser(id));
	}
}