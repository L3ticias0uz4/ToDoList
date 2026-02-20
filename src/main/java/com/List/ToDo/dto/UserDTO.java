package com.List.ToDo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
	@NotBlank(message = "Nome inválido")
	private String name;
	@Email
	@NotBlank(message = "Email inválido")
	private String email;
	@NotBlank(message = "Senha inválida")
	@Size(min = 6, max = 30, message = "A senha deve ter entre 6 à 20 caracteres")
	private String password;

//	Gettes and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	Constructor
	public UserDTO(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public UserDTO() {
		super();
	}

}