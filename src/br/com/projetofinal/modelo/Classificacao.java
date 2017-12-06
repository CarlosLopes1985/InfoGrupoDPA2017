package br.com.projetofinal.modelo;

public class Classificacao {
	
	private Integer idClassificacao;
	private Integer notaJogador;
	private Integer contadorMedia;
	private Double 	mediaTotal;
	private Pessoa  pessoa;
	
	public Classificacao(Integer contadorMedia, Double mediaTotal) {
		
		this.contadorMedia = contadorMedia;
		this.mediaTotal = mediaTotal;
	}

	public Classificacao(Integer idClassificacao, Integer notaJogador, Integer contadorMedia, Pessoa pessoa) {
		super();
		this.idClassificacao = idClassificacao;
		this.notaJogador = 0;
		this.contadorMedia = 1;
		this.mediaTotal = 10.;
		this.pessoa = pessoa;
	}

	public Classificacao(Integer idClassificacao, Integer notaJogador, Integer contadorMedia) {
		super();
		this.idClassificacao = idClassificacao;
		this.notaJogador = notaJogador;
		this.contadorMedia = contadorMedia;
	}

	
	
	public Classificacao() {
		this.mediaTotal = 5.0;
	}

	public Double getMediaTotal() {
		return mediaTotal;
	}

	public void setMediaTotal(Double mediaTotal) {
		this.mediaTotal = mediaTotal;
	}

	public Integer getIdClassificacao() {
		return idClassificacao;
	}

	public void setIdClassificacao(Integer idClassificacao) {
		this.idClassificacao = idClassificacao;
	}

	public Integer getNotaJogador() {
		return notaJogador;
	}

	public void setNotaJogador(Integer notaJogador) {
		this.notaJogador = notaJogador;
	}

	public Integer getContadorMedia() {
		return contadorMedia;
	}

	public void setContadorMedia(Integer contadorMedia) {
		this.contadorMedia = contadorMedia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Classificacao [idClassificacao=" + idClassificacao + ", notaJogador=" + notaJogador + ", contadorMedia="
				+ contadorMedia + ", pessoa=" + pessoa + "]";
	}
	
}
