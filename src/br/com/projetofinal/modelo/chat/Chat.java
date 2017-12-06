package br.com.projetofinal.modelo.chat;

import br.com.projetofinal.modelo.Pessoa;

public class Chat {
	
	private Integer idChat;
	private Sala sala;
	private Pessoa pessoa;
	private boolean statusMsg;
	
	public Chat() {
	}
	
	public Chat(Integer idChat, Sala sala, Pessoa pessoa, boolean statusMsg) {
		this.idChat = idChat;
		this.sala = sala;
		this.pessoa = pessoa;
		this.statusMsg = statusMsg;
	}
	
	public Integer getIdChat() {
		return idChat;
	}
	public void setIdChat(Integer idChat) {
		this.idChat = idChat;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public boolean isStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(boolean statusMsg) {
		this.statusMsg = statusMsg;
	}
	@Override
	public String toString() {
		return "Chat [idChat=" + idChat + ", sala=" + sala + ", pessoa="
				+ pessoa + ", statusMsg=" + statusMsg + "]";
	}
	
	
}
