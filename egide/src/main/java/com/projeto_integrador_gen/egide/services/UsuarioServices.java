package com.projeto_integrador_gen.egide.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador_gen.egide.model.Usuario;
import com.projeto_integrador_gen.egide.repository.UsuarioRepository;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository repository;
	
	
	/**
	 * Registra no banco um novo usuario para acessar o sistema caso não exista, retornando um Optional com a Entidade
	 * @param 	novoUsuario uma Entidade Usuario
	 * @return 	Optional com Usuario se os parametos estiverem devidamente escritos, caso contrario vasio(empty)
	 * @since 	1.0
	 * @author 	Egide 
	 */
	public Optional<Usuario> cadastrarUsuario(Usuario novoUsuario){
		Optional<Usuario> usuarioExistente = repository.findByEmail(novoUsuario.getEmail());
		if(usuarioExistente.isPresent())
		{
			return Optional.empty();
		}
		Optional<Usuario> usuarioCadastrado = Optional.ofNullable(repository.save(novoUsuario));
		
		if (usuarioCadastrado.isPresent()) {
			return usuarioCadastrado;	
		} else {
			return Optional.empty();
		}
	}
	
	/**
	 * Retorna do banco uma entidade do usuario no formato Optional.
	 * @param 	usuario tipo String
	 * @return 	Optional com Usuario se os parametos estiverem devidamente escritos, caso contrario vasio(empty)
	 * @since 	1.0
	 * @author 	Egide 
	 */
	public Optional<Usuario> visualizarPerfil (String nome){
		Optional<Usuario> usuarioExistente = repository.findByNome(nome);
		
		if(usuarioExistente.isPresent()) {
			return usuarioExistente;
		}else {
			return Optional.empty();
		}
	

	}
}
