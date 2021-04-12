package com.projeto_integrador_gen.egide.services;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto_integrador_gen.egide.model.Postagem;
import com.projeto_integrador_gen.egide.model.UserLogin;
import com.projeto_integrador_gen.egide.model.Usuario;
import com.projeto_integrador_gen.egide.repository.PostagemRepository;
import com.projeto_integrador_gen.egide.repository.UsuarioRepository;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	/**
	 * Registra no banco um novo usuario para acessar o sistema caso não exista, retornando um Optional com a Entidade
	 * @param 	novoUsuario uma Entidade Usuario
	 * @return 	Optional com Usuario se os parametos estiverem devidamente escritos, caso contrario vasio(empty)
	 * @since 	1.0
	 * @author 	Egide 
	 */
	public Optional<Usuario> cadastrarUsuarioEmail (Usuario novoUsuario){
		Optional<Usuario> usuarioExistente = repository.findByEmail(novoUsuario.getEmail());
		if(usuarioExistente.isPresent())
		{
			return Optional.empty();
		}
		Optional<Usuario> usuarioCad = Optional.ofNullable(repository.save(novoUsuario));
		
		if (usuarioCad.isPresent()) {
			return usuarioCad;	
		} else {
			return Optional.empty();
		}
	}
	
	/**
	 * Retorna do banco uma entidade do usuario no formato Optional.
	 * @param 	usuario tipo String
	 * @return 	Optional com Usuario se os parametos estiverem devidamente escritos, caso contrario vazio(empty)
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
	
	public Optional <Usuario> cadastrarUsuario (Usuario usuario)
	{
		Optional<Usuario> usuarioExistente = repository.findByUsuario(usuario.getUsuario()); 
		if(usuarioExistente.isPresent())
		{
			return Optional.empty();
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return Optional.ofNullable(repository.save(usuario));
	}
	
	public Optional<UserLogin> Logar (Optional<UserLogin> user)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
		
		if(usuario.isPresent())
		{
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha()))
			{
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader ="Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				
				return user;
			}
		}
		
		return null;
	}
	
	public Optional<Usuario> fazerPostagem (Postagem novaPostagem, Long idUsuario){
		Optional<Usuario> usuarioExistente = repository.findById(idUsuario);
		if (usuarioExistente.isPresent()) {
			novaPostagem.setUsuarioPublicador(usuarioExistente.get());
			postagemRepository.save(novaPostagem);
			return repository.findById(idUsuario);
		} else {
			return Optional.empty();
		}
		
	}
	
	
}
