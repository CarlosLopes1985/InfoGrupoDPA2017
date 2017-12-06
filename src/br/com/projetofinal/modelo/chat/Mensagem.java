package br.com.projetofinal.modelo.chat;

import java.util.Date;

import br.com.projetofinal.modelo.Pessoa;

public class Mensagem {
	
	private Integer idMensagem;
	private Pessoa pessoa;
	private Sala sala;
	private String mensagem;
	private Date dataMensagem;
	private String horaMsg;

	public Mensagem() {
	}

	

	@Override
	public String toString() {
		return "Mensagem [idMensagem=" + idMensagem + ", pessoa=" + pessoa
				+ ", sala=" + sala + ", mensagem=" + mensagem
				+ ", dataMensagem=" + dataMensagem + ", horaMsg=" + horaMsg
				+ "]";
	}



	public Mensagem(Integer idMensagem, String mensagem, Date dataMensagem,
			String horaMsg) {
		this.idMensagem = idMensagem;
		this.mensagem = mensagem;
		this.dataMensagem = dataMensagem;
		this.horaMsg = horaMsg;
	}



	public Mensagem(Integer idMensagem, Pessoa pessoa, Sala sala,
			String mensagem, Date dataMensagem, String horaMsg) {
		this.idMensagem = idMensagem;
		this.pessoa = pessoa;
		this.sala = sala;
		this.mensagem = mensagem;
		this.dataMensagem = dataMensagem;
		this.horaMsg = horaMsg;
	}



	public String getHoraMsg() {
		return horaMsg;
	}



	public void setHoraMsg(String horaMsg) {
		this.horaMsg = horaMsg;
	}



	public Integer getIdMensagem() {
		return idMensagem;
	}



	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getDataMensagem() {
		return dataMensagem;
	}

	public void setDataMensagem(Date dataMensagem) {
		this.dataMensagem = dataMensagem;
	}
	
	
	
	
}
