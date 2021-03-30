package com.projeto_integrador_gen.egide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_integrador_gen.egide.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
	
	
}
