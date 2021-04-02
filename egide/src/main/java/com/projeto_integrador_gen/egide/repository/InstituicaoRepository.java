package com.projeto_integrador_gen.egide.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_integrador_gen.egide.model.Instituicao;


@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long>{
	
	public List<Instituicao> findAllByNomeContainingIgnoreCase (String nome);
	
	public List<Instituicao> findAllByEnderecoContainingIgnoreCase (String endereco);
	
	public Optional<Instituicao> findByEmail (String email);
	public Optional<Instituicao> findByNome  (String nome);
	public Optional<Instituicao> findByCnpj (String cnpj);
}
