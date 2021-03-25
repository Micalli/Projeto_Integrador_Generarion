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

import com.projeto_integrador_gen.egide.model.InformacoesInstituicao;
import com.projeto_integrador_gen.egide.repository.informacoesInstituicaoRepository;

@RestController
@RequestMapping("/infinstituicao")
@CrossOrigin
public class informacaoInstituicaoController {
	
	@Autowired
	private informacoesInstituicaoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<InformacoesInstituicao>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idInf}")
	public ResponseEntity<InformacoesInstituicao> getById (@PathVariable Long idInf)
	{
		return repository.findById(idInf).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/endereco/{endereco}")
	public ResponseEntity<List<InformacoesInstituicao>> geyByEndereco(@PathVariable String endereco)
	{
		 return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(endereco));
	}
	
	@PostMapping
	public ResponseEntity<InformacoesInstituicao> post (@RequestBody InformacoesInstituicao informacoesinstituicao)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(informacoesinstituicao));
	}
	
	@PutMapping
	public ResponseEntity<InformacoesInstituicao> put (@RequestBody InformacoesInstituicao informacoesinstituicao)
	{
		return ResponseEntity.ok(repository.save(informacoesinstituicao));
	}
	
	@DeleteMapping("/{idInf}")
	public void delete (@PathVariable Long idInf )
	{
		repository.deleteById(idInf);
	}

}
