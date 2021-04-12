package com.projeto_integrador_gen.egide.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_comentarios")
public class Comentarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComentario;
	
	@Size
	private String comentario;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name = "fk_postagem_id")
	@JsonIgnoreProperties
	private Postagem postComentario;


	public Long getIdComentario() {
		return idComentario;
	}


	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public Postagem getPostComentario() {
		return postComentario;
	}


	public void setPostComentario(Postagem postComentario) {
		this.postComentario = postComentario;
	}

}