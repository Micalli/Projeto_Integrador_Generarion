package com.projeto_integrador_gen.egide.controller;

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

import com.projeto_integrador_gen.egide.model.Postagem;
import com.projeto_integrador_gen.egide.repository.PostagemRepository;

@RestController
@RequestMapping ("/postagem") //método de mapeamento da postagem
@CrossOrigin("*")            //compativel com todas ides
public class PostagemController {
	//teste
	@Autowired  // metodo pra instanciar repositorios // 
	private PostagemRepository repository;
	
	@GetMapping //Método para pegar as postagens
	public ResponseEntity<List<Postagem>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	//Metodo de busca de uma postagem através do seu valor de id 
	@GetMapping("/{idPostagem}")
	public ResponseEntity<Postagem> getById(@PathVariable Long idPostagem)
	{
		return repository.findById(idPostagem).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post (@Valid @RequestBody Postagem postagem)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put (@Valid @RequestBody Postagem postagem)	
	{
		return ResponseEntity.ok(repository.save(postagem));
	}
	
	@DeleteMapping ("/{idPostagem}")
	public void delete (@PathVariable Long idPostagem)
	{
		repository.deleteById(idPostagem);
	}
}
