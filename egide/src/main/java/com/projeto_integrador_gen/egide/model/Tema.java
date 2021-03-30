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
@Table(name="tb_temas")
public class Tema {
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long idTema;
	
	@NotNull
	@Size(min= 2, max=20)
	private String doacao; 
	
	@NotNull
	@Size(min= 2, max=50)
	private String visita; 
	
	private Float valor;
	
	@OneToMany (mappedBy="temaPost")
	@JsonIgnoreProperties({"temaPost"})
	private List<Postagem> postagens = new ArrayList<>();

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	public String getDoacao() {
		return doacao;
	}

	public void setDoacao(String doacao) {
		this.doacao = doacao;
	}

	public String getVisita() {
		return visita;
	}

	public void setVisita(String visita) {
		this.visita = visita;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	
}
