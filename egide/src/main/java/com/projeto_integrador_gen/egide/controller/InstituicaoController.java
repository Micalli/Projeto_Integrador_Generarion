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

import com.projeto_integrador_gen.egide.model.Instituicao;
import com.projeto_integrador_gen.egide.repository.InstituicaoRepository;

@RestController
@RequestMapping("/infinstituicao")
@CrossOrigin
public class InstituicaoController {
	
	@Autowired
	private InstituicaoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Instituicao>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idInf}")
	public ResponseEntity<Instituicao> getById (@PathVariable Long idInf)
	{
		return repository.findById(idInf).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/endereco/{endereco}")
	public ResponseEntity<List<Instituicao>> geyByEndereco(@PathVariable String endereco)
	{
		 return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(endereco));
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Instituicao>> geyByNome(@PathVariable String nome)
	{
		 return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Instituicao> post (@Valid @RequestBody Instituicao informacoesinstituicao)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(informacoesinstituicao));
	}
	
	@PutMapping
	public ResponseEntity<Instituicao> put (@Valid @RequestBody Instituicao informacoesinstituicao)
	{
		return ResponseEntity.ok(repository.save(informacoesinstituicao));
	}
	
	@DeleteMapping("/{idInf}")
	public void delete (@PathVariable Long idInf )
	{
		repository.deleteById(idInf);
	}

}
