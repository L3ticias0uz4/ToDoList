package com.List.ToDo.entities;

import com.List.ToDo.dto.TaskDTO;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 2000, nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	private Status status;

	private LocalDate beginDate;
	private LocalDate endDate;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	// Getters e Setters
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	public Status getStatus() { return status; }
	public void setStatus(Status status) { this.status = status; }

	public LocalDate getBeginDate() { return beginDate; }
	public void setBeginDate(LocalDate beginDate) { this.beginDate = beginDate; }

	public LocalDate getEndDate() { return endDate; }
	public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

	public UserEntity getUser() { return user; }
	public void setUser(UserEntity user) { this.user = user; }

	// Construtores
	public TaskEntity() {}

	public TaskEntity(TaskDTO dto) {
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.status = dto.getStatus() != null ? dto.getStatus() : Status.PENDING;
		this.beginDate = dto.getBeginDate() != null ? dto.getBeginDate() : LocalDate.now();
		this.endDate = dto.getEndDate();
	}
}