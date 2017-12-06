package br.com.projetofinal.modelo;

import java.io.Serializable;

public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idRoles;
	private String nome;
	
	@Override
	public String toString() {
		return "Roles [idRoles=" + idRoles + ", nome=" + nome + "]";
	}
	public Roles() {
		super();
	}
	public Roles(Integer idRoles, String nome) {
		super();
		this.idRoles = idRoles;
		this.nome = nome;
	}
	public Integer getIdRoles() {
		return idRoles;
	}
	public void setIdRoles(Integer idRoles) {
		this.idRoles = idRoles;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
