package br.com.projetofinal.modelo;

public class JogosxRoles {

	private Jogos jogos;
	private Roles roles;
	
	public JogosxRoles(Jogos jogos, Roles roles) {
		super();
		this.jogos = jogos;
		this.roles = roles;
	}

	public JogosxRoles() {
		super();
	}

	@Override
	public String toString() {
		return "JogosxRoles [jogos=" + jogos + ", roles=" + roles + "]";
	}

	public Jogos getJogos() {
		return jogos;
	}

	public void setJogos(Jogos jogos) {
		this.jogos = jogos;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	
	
}
