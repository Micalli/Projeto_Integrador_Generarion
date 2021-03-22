package com.projeto_integrador_gen.egide.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private long id_usuario;
	
	
	@NotNull
	@Size(min= 2, max=20)
	private String nome; 
	
	@NotNull
	@Size(min= 8, max=30)
	private String email; 
	
	@NotNull
	@Size(min= 6, max=10)
	private String senha;
	
	@OneToMany (mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	} 
}
