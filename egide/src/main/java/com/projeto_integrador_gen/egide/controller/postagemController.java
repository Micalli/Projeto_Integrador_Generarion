package com.projeto_integrador_gen.egide.controller;

import java.util.List;

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
import com.projeto_integrador_gen.egide.repository.postagemRepository;

@RestController
@RequestMapping ("/postagem")
@CrossOrigin("*")
public class postagemController {
	
	@Autowired
	private postagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idPostagem}")
	public ResponseEntity<Postagem> getById(@PathVariable Long idPostagem)
	{
		return repository.findById(idPostagem).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem)	
	{
		return ResponseEntity.ok(repository.save(postagem));
	}
	
	@DeleteMapping ("/{idPostagem}")
	public void delete (@PathVariable Long idPostagem)
	{
		repository.deleteById(idPostagem);
	}
}
