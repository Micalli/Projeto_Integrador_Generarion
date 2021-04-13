package com.projeto_integrador_gen.egide.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_postagens")
//teste
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPostagem;

	@NotNull
	@Size(min = 2, max = 500)
	private String publicacao;

	@NotNull
	@Size(min = 2, max = 500)
	private String evento;

	@NotNull
	@Size(min = 2, max = 50)
	private String comunidade;
	
	@NotNull
	@Size(min = 2, max = 50)
	private String tema;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_usuario_id")
	@JsonIgnoreProperties({"idUsuario","email","senha","minhasPostagens"})
	private Usuario usuarioPublicador;

	public Long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(Long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
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

	public Usuario getUsuarioPublicador() {
		return usuarioPublicador;
	}

	public void setUsuarioPublicador(Usuario usuarioPublicador) {
		this.usuarioPublicador = usuarioPublicador;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	

}
