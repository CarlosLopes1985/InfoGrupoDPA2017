package br.com.projetofinal.modelo;

import java.io.Serializable;

public class PessoaxJogos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Jogos jogos;
	private Pessoa pessoa;
	
	
	public PessoaxJogos() {
		super();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Jogos getJogos() {
		return jogos;
	}

	public void setJogos(Jogos jogos) {
		this.jogos = jogos;
	}

	public PessoaxJogos(Pessoa pessoa, Jogos jogos) {
		super();
		this.pessoa = pessoa;
		this.jogos = jogos;
	}

	@Override
	public String toString() {
		return "PessoaxJogos [pessoa=" + pessoa + ", jogos=" + jogos + "]";
	}
}
