package br.com.projetofinal.persistence;

import br.com.projetofinal.modelo.Pessoa;

public class ClassificacaoDao extends Dao {

	/**
	 * Responsável por inserir um valor default para cada usuário em classificacao
	 * @param pessoa
	 * @throws Exception
	 */
	public void gravarClassificacao(Pessoa pessoa) throws Exception {

		open();

		//Classificacao cla = new Classificacao();
		//cla.setPessoa(pessoa);

		stmt = con.prepareStatement("insert into classificacao values(null,?,?,?)");
		stmt.setInt   (1, 1 );
		stmt.setDouble(2, 10   );
		stmt.setInt   (3, pessoa.getIdPessoa( )   );

		stmt.execute();

		close();
	}
	
	public static void main(String[] args) {
		
		try {
			
		
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(50);
		
		ClassificacaoDao cd = new ClassificacaoDao();
		
		cd.gravarClassificacao(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
	}
}
