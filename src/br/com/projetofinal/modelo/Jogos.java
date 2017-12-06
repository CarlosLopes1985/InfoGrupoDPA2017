package br.com.projetofinal.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jogos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer                 idJogos;
	private String                  nomeJogos;
	private Boolean 				status;
	private List<Pessoa>            pessoas;
	private List<Plataformas>       plataformas;
	private List<JogosxPlataformas> jogosxplataformas;
	private List<Roles>             roles;
	private List<JogosxRoles>       jogosxroles;
	
//	
	
	public Jogos() {
		
	}
	
	
	@Override
	public String toString() {
		return "Jogos [idJogos=" + idJogos + ", nomeJogos=" + nomeJogos + ", status=" + status + ", pessoas=" + pessoas
				+ ", plataformas=" + plataformas + ", jogosxplataformas=" + jogosxplataformas + ", roles=" + roles
				+ ", jogosxroles=" + jogosxroles + "]";
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
	public Jogos(Integer idJogos, String nomeJogos) {
		super();
		this.idJogos = idJogos;
		this.nomeJogos = nomeJogos;
	}


	public Jogos(Integer idJogos, String nomeJogos, Boolean status) {
		super();
		this.idJogos = idJogos;
		this.nomeJogos = nomeJogos;
		this.status = true;
	}


	public Integer getIdJogos() {
		return idJogos;
	}
	public void setIdJogos(Integer idJogos) {
		this.idJogos = idJogos;
	}
	public String getNomeJogos() {
		return nomeJogos;
	}
	public void setNomeJogos(String nomeJogos) {
		this.nomeJogos = nomeJogos;
	}
	public List<Plataformas> getPlataformas() {
		return plataformas;
	}
	public void setPlataformas(List<Plataformas> plataformas) {
		this.plataformas = plataformas;
	}
	public List<JogosxPlataformas> getJogosxplataformas() {
		return jogosxplataformas;
	}
	public void setJogosxplataformas(List<JogosxPlataformas> jogosxplataformas) {
		this.jogosxplataformas = jogosxplataformas;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
	
	
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public List<JogosxRoles> getJogosxroles() {
		return jogosxroles;
	}
	public void setJogosxroles(List<JogosxRoles> jogosxroles) {
		this.jogosxroles = jogosxroles;
	}
	
	/**
	 * 
	 * @param p
	 */
	public void adicionar(Plataformas p){
		if( plataformas == null ){
			plataformas = new ArrayList<Plataformas>();
		}
		if(jogosxplataformas == null ){
			jogosxplataformas = new ArrayList<JogosxPlataformas>();
		}
		plataformas.add(p);
		jogosxplataformas.add(new JogosxPlataformas(this, p) );
	}
	
	/**
	 * 
	 * @param p
	 */
	public void adicionar(Roles r){
		if( roles == null ){
			roles = new ArrayList<Roles>();
		}
		if(jogosxroles == null ){
			jogosxroles = new ArrayList<JogosxRoles>();
		}
		roles.add(r);
		jogosxroles.add(new JogosxRoles(this, r) );
	}
	
	
	
	
}
