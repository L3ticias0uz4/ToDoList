package com.List.ToDo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.List.ToDo.dto.TaskDTO;
import com.List.ToDo.entities.TaskEntity;
import com.List.ToDo.entities.UserEntity;
import com.List.ToDo.repositories.TaskRepository;
import com.List.ToDo.repositories.UserRepository;

@Service
public class TaskService {

	private final TaskRepository taskRepository;
	private final UserRepository userRepository;

	public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
		this.taskRepository = taskRepository;
		this.userRepository = userRepository;
	}

	public TaskEntity createTask(TaskDTO dto) {
		TaskEntity task = new TaskEntity(dto);
		return taskRepository.save(task);
	}

	public TaskEntity createTaskForUser(Long userId, TaskDTO dto) {
		UserEntity user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

		TaskEntity task = new TaskEntity(dto);
		task.setUser(user);

		return taskRepository.save(task);
	}

	public String deleteTask(Long id) {
		if (taskRepository.existsById(id)) {
			taskRepository.deleteById(id);
			return "Tarefa excluída com sucesso!";
		} else {
			return "Essa tarefa não existe";
		}
	}

	public List<TaskEntity> showTasks() {
		return taskRepository.findAll();
	}

	public Optional<TaskEntity> showTasksById(Long id) {
		return taskRepository.findById(id);
	}

	public List<TaskEntity> getTasksByUser(Long userId) {
		UserEntity user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
		return user.getTasks();
	}

	public TaskEntity updateTask(Long id, TaskDTO dto) {
		TaskEntity task = taskRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));

		task.setName(dto.getName());
		task.setDescription(dto.getDescription());
		task.setStatus(dto.getStatus());
		task.setBeginDate(dto.getBeginDate());
		task.setEndDate(dto.getEndDate());

		return taskRepository.save(task);
	}
}