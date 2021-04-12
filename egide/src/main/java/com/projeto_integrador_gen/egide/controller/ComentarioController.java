package com.projeto_integrador_gen.egide.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_integrador_gen.egide.model.Comentarios;
import com.projeto_integrador_gen.egide.repository.ComentarioRepository;

@RestController
@RequestMapping ("comentario")
@CrossOrigin("*")

public class ComentarioController {
	
	@Autowired
	private ComentarioRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Comentarios>> getAll ()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Comentarios> post(@Valid @RequestBody Comentarios comentario)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(comentario));
	}

}
