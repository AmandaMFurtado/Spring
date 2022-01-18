package br.org.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tb_postagens") //Para criar a tabela no banco de dados
public class Postagem {

	@Id //primary key(id)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
	private Long id;
	
	@NotBlank(message = "O atributo título é obrigatorio")//not null
	@Size (min = 5, max = 100, message = "O atributo titulo deve conter no minimo 5 e no maximo 100 caracteres")// configuraçao de tamanho
	private String title;
	
	@NotBlank(message = "O atributo título é obrigatorio")//not null
	@Size (min = 10, max = 1000, message = "O atributo texto deve conter no minimo 10 e no maximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	

}

