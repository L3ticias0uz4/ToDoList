package com.List.ToDo.service;

import org.springframework.stereotype.Service;
import com.List.ToDo.dto.UserDTO;
import com.List.ToDo.entities.UserEntity;
import com.List.ToDo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Criar usuário
	public UserDTO createUser(UserDTO dto) {
		UserEntity user = new UserEntity(dto);
		userRepository.save(user);
		return new UserDTO(user.getName(), user.getEmail()); // não retorna senha
	}

	// Listar todos os usuários
	public List<UserDTO> listUsers() {
		return userRepository.findAll()
				.stream()
				.map(u -> new UserDTO(u.getName(), u.getEmail()))
				.collect(Collectors.toList());
	}

	// Buscar usuário por ID
	public UserDTO getUserById(Long id) {
		Optional<UserEntity> userOpt = userRepository.findById(id);
		UserEntity user = userOpt.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
		return new UserDTO(user.getName(), user.getEmail());
	}

	// Deletar usuário
	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new IllegalArgumentException("Usuário não encontrado");
		}
		userRepository.deleteById(id);
	}
}