package com.projeto_integrador_gen.egide.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_integrador_gen.egide.model.Usuario;

@Repository
public interface usuarioRepository extends JpaRepository<Usuario, Long>{
	
	public List<Usuario> findAllByNomeContainingIgnoreCase (String Nome);

}
