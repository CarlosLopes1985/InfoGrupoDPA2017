package br.com.projetofinal.modelo;

import java.io.Serializable;
import java.util.List;

public class Plataformas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPlataforma;
	private String nomePlataforma;
	private List<Jogos>jogos; 
	
	public Plataformas() {
		super();
	}

	@Override
	public String toString() {
		return "Plataformas [idPlataforma=" + idPlataforma
				+ ", nomePlataforma=" + nomePlataforma + "]";
	}



	public Plataformas(Integer idPlataforma, String nomePlataforma) {
		this.idPlataforma = idPlataforma;
		this.nomePlataforma = nomePlataforma;
	}

	public Integer getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public String getNomePlataforma() {
		return nomePlataforma;
	}

	public void setNomePlataforma(String nomePlataforma) {
		this.nomePlataforma = nomePlataforma;
	}

	public List<Jogos> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogos> jogos) {
		this.jogos = jogos;
	}
}
