package br.com.projetofinal.manager;

import java.util.List;

import br.com.projetofinal.modelo.Jogos;
import br.com.projetofinal.modelo.Pessoa;
import br.com.projetofinal.modelo.Plataformas;
import br.com.projetofinal.modelo.Roles;
import br.com.projetofinal.persistence.Dao;
import br.com.projetofinal.persistence.JogosDao;
import br.com.projetofinal.persistence.PessoaDao;
import br.com.projetofinal.persistence.PlataformaDao;
import br.com.projetofinal.persistence.RolesDao;


public class ManagerBean extends Dao{
	
	
	private List<Jogos>listajogos;
	private List<Pessoa>listaPessoaLogin;
	private List<Plataformas>listaPlataformas;
	private List<Roles>listaRoles;
	
//	public List<Pessoa> getListaPessoas() {
//		try {
//			listaPessoas = new PessoaDao().findAll();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return listaPessoas;
//		}
	
	
	public List<Jogos> getListajogos() {
		try {
			listajogos = new JogosDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listajogos;
	}
	
	public void setListajogos(List<Jogos> listajogos) {
		this.listajogos = listajogos;
	}
	
	public List<Pessoa> getListaPessoaLogin() {
		try {
			listaPessoaLogin = new PessoaDao().findAllPessoaLogin();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return listaPessoaLogin;
	}
		
	public void setListaPessoaLogin(List<Pessoa> listaPessoaLogin) {
		this.listaPessoaLogin = listaPessoaLogin;
	}

	public List<Plataformas> getListaPlataformas() {
		try {
			listaPlataformas = new PlataformaDao().findAll();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return listaPlataformas;
	}

	public void setListaPlataformas(List<Plataformas> listaPlataformas) {
		this.listaPlataformas = listaPlataformas;
	}
	
	public List<Roles> getListaRoles() {

		try {
			listaRoles = new RolesDao().findAll(null);
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return listaRoles;
	}
	public void setListaRoles(List<Roles> listaRoles) {
		this.listaRoles = listaRoles;
	}
	
	
	
}
