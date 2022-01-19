package br.org.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.model.Postagem;
import br.org.generation.blogpessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	// injeçao de dependencia
	// atraves da interface o spring instacia novos objetos

	@Autowired
	private PostagemRepository postagemRepository;

	@GetMapping
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(postagemRepository.findAll());
		// select * from tb_postagens;
	}

	// expressão lambida
	@GetMapping("/{id}") // variavel de caminho, indica de queremos uma consulyta por id na pagina de
							// postagens
	public ResponseEntity<Postagem> getById(@PathVariable Long id) {
		return postagemRepository.findById(id).map(response -> ResponseEntity.ok(response)) // para encontrar
				.orElse(ResponseEntity.notFound().build()); // caso não encontre
	}

	@GetMapping("/titulo{titulo}")
	public ResponseEntity<List<Postagem>> getByTitle(@PathVariable String titulo) {
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingignoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Postagem> postPostagem(@Valid @RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}

	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@Valid @RequestBody Postagem postagem) {
		// return
		// ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
		return postagemRepository.findById(postagem.getId())
				.map(response -> ResponseEntity.ok(postagemRepository.save(postagem)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity <?> deletePostagem(@PathVariable Long id){
		return postagemRepository.findById(id)
				.map(response -> {
				postagemRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();			
				})
				.orElse(ResponseEntity.notFound().build());
	}

}