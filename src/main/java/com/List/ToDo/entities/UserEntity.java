package com.List.ToDo.entities;

import com.List.ToDo.dto.UserDTO;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // evitar conflito com palavra reservada "user"
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 100, unique = true, nullable = false)
	private String email;

	@Column(length = 60, nullable = false)
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TaskEntity> tasks = new ArrayList<>();

	// Getters e Setters
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public List<TaskEntity> getTasks() { return tasks; }
	public void setTasks(List<TaskEntity> tasks) { this.tasks = tasks; }

	// Construtores
	public UserEntity() {}

	public UserEntity(UserDTO dto) {
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
	}
}
