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
@Table(name="tema")
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
	
	
	
	private float valor;
	
	@OneToMany (mappedBy="tema")
	@JsonIgnoreProperties("Tema")
	private List<Postagem> postagem;


	public long getId_tema() {
		return idTema;
	}

	public void setId_tema(long id_tema) {
		this.idTema = id_tema;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	} 
}
