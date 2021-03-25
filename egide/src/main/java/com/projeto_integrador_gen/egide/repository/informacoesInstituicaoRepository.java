package com.projeto_integrador_gen.egide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_integrador_gen.egide.model.InformacoesInstituicao;


@Repository
public interface informacoesInstituicaoRepository extends JpaRepository<InformacoesInstituicao, Long>{
	
	public List<InformacoesInstituicao> findAllByNomeContainingIgnoreCase (String Nome);
	
	public List<InformacoesInstituicao> findAllByEnderecoContainingIgnoreCase (String endereco);
}
