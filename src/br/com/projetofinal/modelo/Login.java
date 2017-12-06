package br.com.projetofinal.modelo;

import java.io.Serializable;

public class Login implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idLogin;
	private String email;
	private String senha;
	private String perfil;
	private Boolean status;
	private String palavraChave;
	private Pessoa pessoa;
	
	/**cadastra um usuario e depois vem aki e troca para administrador para cadastrar um adm
	 * que??  
	 * Se cadastra no sistema!!!
	 * ah sim, peraí
	 * 
	*/
	public Login() {
		this.status = true;
		this.perfil = "Usuario";
	}
	
	/**
	 * 
	 * @param idLogin
	 * @param email
	 * @param senha
	 * @param perfil
	 * @param status
	 * @param palavraChave
	 */
	public Login(Integer idLogin, String email, String senha, String perfil, Boolean status, String palavraChave) {
		super();
		this.idLogin = idLogin;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.status = status;
		this.palavraChave = palavraChave;
	}


	public Login(Integer idLogin, String email, String senha, String perfil, Boolean status,
			Pessoa pessoa) {
		super();
		this.idLogin = idLogin;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.status = status;
		this.pessoa = pessoa;
	}
	@Override
	public String toString() {
		return "Login [idLogin=" + idLogin + ", email=" + email + ", senha=" + senha 
				+ ", perfil=" + perfil + ", status=" + status + "]";
	}
	public Integer getIdLogin() {
		return idLogin;
	}
	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}
}
