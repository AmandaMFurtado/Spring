package br.org.generation.lojagames.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@Column(name = "data_nascimento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "O campo Data de Nascimento é Obrigatório!")
	private LocalDate dataNascimento;

	@NotBlank
	@Email
	private String usuario;

	@NotBlank
	private String senha;

	public Usuario() {

	}

	public Usuario(Long id, String name, LocalDate dataNascimento, String usuario, String senha) {

		this.id = id;
		this.name = name;
		this.dataNascimento = dataNascimento;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
