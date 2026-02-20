package com.List.ToDo.dto;

import java.time.LocalDate;

import com.List.ToDo.entities.Status;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskDTO {

	@NotBlank
	@NotNull
	private String name;
	@NotBlank
	@NotNull
	private String description;
	private Status status;
	private LocalDate beginDate;
	@Future
	private LocalDate endDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public TaskDTO(String name, String description, Status status, LocalDate beginDate, LocalDate endDate) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

}