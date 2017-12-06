package br.com.projetofinal.rn;

import br.com.projetofinal.modelo.Classificacao;

public class MediaNota {
	
	/**
	 * Fazer um select no banco para retornar o numero de pessoas que votaram 
	 * em determinado jogador e a média total do mesmo, fazer um update na tabela 
	 * 
	 * @param classificacao
	 * @return
	 */
	public Double calcularMediaNotas(Classificacao classificacao){
		
		Double valorTotal = (classificacao.getNotaJogador() + classificacao.getMediaTotal())
																	/ classificacao.getContadorMedia();
		
		return valorTotal;
	}
	
	public static void main(String[] args) {
		
		Classificacao cl = new Classificacao( );
		MediaNota     mn = new MediaNota();
		
		cl.setNotaJogador(8);
		cl.setMediaTotal(6.5);
		cl.setContadorMedia(3);
		
		Double valor = mn.calcularMediaNotas(cl);
	
		System.out.println( valor);
		
	}
	
}
