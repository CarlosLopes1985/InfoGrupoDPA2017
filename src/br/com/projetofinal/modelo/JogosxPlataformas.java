package br.com.projetofinal.modelo;

import java.io.Serializable;

public class JogosxPlataformas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Plataformas plataforma;
	private Jogos jogos;
	
	public JogosxPlataformas( Jogos jogos,Plataformas plataforma) {
		super();
		this.jogos = jogos;
		this.plataforma = plataforma;
		
	}

	public JogosxPlataformas() {
		super();
	}

	public Plataformas getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataformas plataforma) {
		this.plataforma = plataforma;
	}

	public Jogos getJogos() {
		return jogos;
	}

	public void setJogos(Jogos jogos) {
		this.jogos = jogos;
	}

	@Override
	public String toString() {
		return "JogosXPlataformas [plataforma=" + plataforma + ", jogos=" + jogos + "]";
	}
	
	
	
	
	
}
