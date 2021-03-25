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
@Table(name="informacoes_instituicao")
public class InformacoesInstituicao {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long idInf;
	
	@NotNull
	@Size(min=2, max=35)
	private String nome;
	
	@NotNull
	@Size(min=2, max=50)
	private String endereco;
	
	@NotNull
	@Size(min=5, max=25)
	private String email_comercial;
	
	@NotNull
	@Size(min=14, max=14)
	private String cnpj;
	
	@OneToMany (mappedBy = "informacoesInstituicao")
	@JsonIgnoreProperties("informacoesInstituicao")
	private List<Postagem> postagem;

	public Long getId_inf() {
		return idInf;
	}

	public void setId_inf(Long id_inf) {
		this.idInf = id_inf;
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
		this.endereco=endereco;
	}

	public String getEmail_comercial() {
		return email_comercial;
	}

	public void setEmail_comercial(String email_comercial) {
		this.email_comercial = email_comercial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
}
