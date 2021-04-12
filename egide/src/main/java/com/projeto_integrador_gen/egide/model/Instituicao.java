package com.projeto_integrador_gen.egide.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tb_instituicoes")
public class Instituicao {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long idInf;
	
	@NotNull
	@Size(min=2, max=35)
	private String nome;
	
	@NotNull
	@Size(min=6, max=100)
	private String senha;
	
	@NotNull
	@Size(min=2, max=35)
	private String usuario;
	
	@NotNull
	@Size(min=2, max=50)
	private String endereco;
	
	@NotNull
	@Size(min=5, max=25)
	private String email;
	
	@NotNull
	@Size(min=14, max=14)
	private String cnpj;
	
	@OneToMany (mappedBy = "instituicaoPublicadora")
	@JsonIgnoreProperties({"instituicaoPublicadora"})
	private List<Postagem> postagens = new ArrayList<>();

	public Long getIdInf() {
		return idInf;
	}

	public void setIdInf(Long idInf) {
		this.idInf = idInf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
