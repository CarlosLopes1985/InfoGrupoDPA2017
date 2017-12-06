package br.com.projetofinal.modelo;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import br.com.projetofinal.modelo.chat.Sala;

public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPessoa;
	private String nomeUsuario;
	private Date dataNascimento;
	private Date dataCadastro;
	private String foto;
	private String sexo;
	private Login login;
	private List<Jogos>jogos;
	private List<Roles>roles;
	private Classificacao classificacao;
	private Sala sala;
	
//	private List<PessoaxJogos>pessoas_jogos;
	
	public Pessoa(Integer idPessoa, String nomeUsuario) {
		super();
		this.idPessoa = idPessoa;
		this.nomeUsuario = nomeUsuario;
	}
	
	
	
	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nomeUsuario=" + nomeUsuario
				+ ", dataNascimento=" + dataNascimento + ", dataCadastro="
				+ dataCadastro + ", foto=" + foto + ", sexo=" + sexo
				+ ", login=" + login + ", classificacao=" + classificacao + "]";
	}



	public Pessoa(Integer idPessoa, String nomeUsuario, Date dataNascimento,
		Date dataCadastro, String foto, String sexo, Classificacao classificacao) {
	super();
	this.idPessoa = idPessoa;
	this.nomeUsuario = nomeUsuario;
	this.dataNascimento = dataNascimento;
	this.dataCadastro = dataCadastro;
	this.foto = foto;
	this.sexo = sexo;
	this.classificacao = classificacao;
	}
	
	public Pessoa(Integer idPessoa, String nomeUsuario, Date dataNascimento,
			Date dataCadastro, String foto, String sexo, List<Jogos> jogos,
			List<Roles> roles, Classificacao classificacao, Sala sala) {
		super();
		this.idPessoa = idPessoa;
		this.nomeUsuario = nomeUsuario;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.foto = foto;
		this.sexo = sexo;
		this.jogos = jogos;
		this.roles = roles;
		this.classificacao = classificacao;
		this.sala = sala;
	}



	public Sala getSala() {
		return sala;
	}



	public void setSala(Sala sala) {
		this.sala = sala;
	}



	public Classificacao getClassificacao() {
		return classificacao;
	}



	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}



	public Pessoa() {
		 dataCadastro = new Date( );
	}

	public Pessoa(Integer idPessoa, String nomeUsuario, Date dataNascimento, Date dataCadastro, String foto,
			String sexo, Login login) {
		super();
		this.idPessoa = idPessoa;
		this.nomeUsuario = nomeUsuario;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.foto = foto;
		this.sexo = sexo;
		this.login = login;
	}
	
	public Pessoa(Integer idPessoa, String nomeUsuario, Date dataNascimento, Date dataCadastro, String foto,
			String sexo) {
		super();
		this.idPessoa = idPessoa;
		this.nomeUsuario = nomeUsuario;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.foto = foto;
		this.sexo = sexo;
	}
	
	
	
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Jogos> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogos> jogos) {
		this.jogos = jogos;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

//	public List<PessoaxJogos> getPessoas_jogos() {
//		return pessoas_jogos;
//	}
//
//	public void setPessoas_jogos(List<PessoaxJogos> pessoas_jogos) {
//		this.pessoas_jogos = pessoas_jogos;
//	}
//	
//	public void adicionar(Jogos j){
//		if( jogos == null ){
//			jogos = new ArrayList<Jogos>();
//		}
//		if(pessoas_jogos == null ){
//			pessoas_jogos = new ArrayList<PessoaxJogos>();
//		}
//		jogos.add(j);
//		pessoas_jogos.add(new PessoaxJogos(this, j) );
//	}
	
}
