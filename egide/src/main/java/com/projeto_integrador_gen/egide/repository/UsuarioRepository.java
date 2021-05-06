package com.projeto_integrador_gen.egide.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projeto_integrador_gen.egide.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
	
	public Optional<Usuario> findByEmail(String email);
	
	public Optional<Usuario> findByNome (String nome);
	
	public Optional<Usuario> findByUsuario(String usuario);
	
	@Query(value = "SELECT * FROM tb_usuarios WHERE email = :cenourinhas",nativeQuery = true)
	public Optional<Usuario> findUsuarioByEmail(@Param("cenourinhas")String email);

}
