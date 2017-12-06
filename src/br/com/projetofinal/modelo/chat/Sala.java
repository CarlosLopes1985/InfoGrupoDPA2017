package br.com.projetofinal.modelo.chat;

import java.util.List;

import br.com.projetofinal.modelo.Pessoa;

public class Sala {
	
	private Integer idSala;
	private String nomeSala;
	private List<Pessoa>pessoas;
	
	public Sala() {
	
	}
	
	public Sala(Integer idSala, String nomeSala) {
		this.idSala = idSala;
		this.nomeSala = nomeSala;
	}

	public Sala(Integer idSala, String nomeSala, List<Pessoa> pessoas) {
		super();
		this.idSala = idSala;
		this.nomeSala = nomeSala;
		this.pessoas = pessoas;
	}

	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", nomeSala=" + nomeSala
				+ ", pessoas=" + pessoas + "]";
	}

	public Integer getIdSala() {
		return idSala;
	}

	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
