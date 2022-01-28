package br.org.generation.blogpessoal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,Long>{
	
	public Optional<Usuario>findByUsuario(String usuario); //FindBy nome reservado Usuario é o atributo Pocure pelo nome do atr
	
	public Optional<Usuario>findAllById(Long id); //procurar por id
}
