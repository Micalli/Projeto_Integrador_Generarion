package com.projeto_integrador_gen.egide.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name="postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idPostagem;
	
	@NotNull
	@Size (min= 2, max=500)
	private String publicacao;
	
	@NotNull
	@Size (min= 2, max=500)
	private String convite;
	
	@NotNull
	@Size (min= 2, max=500)
	private String evento;
	
	@NotNull
	@Size (min= 2, max=50)
	private String comunidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date= new java.sql.Date(System.currentTimeMillis());
	

	@ManyToOne
	@JsonIgnoreProperties({"postagem","senha","email"})
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties({"postagem","email_comercial","cnpj"})
	private InformacoesInstituicao informacoesInstituicao;
	
	@ManyToOne
	@JsonIgnoreProperties ({"postagem","valor"})
	private Tema tema;
	

	public Long getId() {
		return idPostagem;
	}

	public void setId(Long id) {
		this.idPostagem = id;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	public String getConvite() {
		return convite;
	}

	public void setConvite(String convite) {
		this.convite = convite;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getComunidade() {
		return comunidade;
	}

	public void setComunidade(String comunidade) {
		this.comunidade = comunidade;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public InformacoesInstituicao getInformaçoes_Instituicao() {
		return informacoesInstituicao;
	}

	public void setInformaçoes_Instituicao(InformacoesInstituicao informaçoes_Instituicao) {
		this.informacoesInstituicao = informaçoes_Instituicao;
	}



	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
}
