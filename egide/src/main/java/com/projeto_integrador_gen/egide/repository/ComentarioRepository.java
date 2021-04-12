package com.projeto_integrador_gen.egide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_integrador_gen.egide.model.Comentarios;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentarios, Long> {
	
	public List<Comentarios> findAllByComentarioContaining(Long idComentario);

}
