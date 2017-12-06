package br.com.projetofinal.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.modelo.Jogos;
import br.com.projetofinal.modelo.Pessoa;
import br.com.projetofinal.modelo.Plataformas;
import br.com.projetofinal.modelo.Roles;

public class JogosDao extends Dao {

	/**
	 * 
	 * @param idJogo
	 */
	public void desativarJogos( int idJogo, boolean status, int idPessoa ) {
		try {
			open();
			
			stmt = con.prepareStatement("update pessoa_jogo_plataforma_role set status = ? where pjpr_jogo_codigo = ? and pjpr_pessoa_codigo = ? ");
			
			stmt.setBoolean(1, status);
			stmt.setInt(2, idJogo);
			stmt.setInt(3, idPessoa);
			
			stmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param jogos
	 * @return
	 * @throws Exception
	 */
	public Integer gravarJogos(Jogos jogos) throws Exception {
		try {

			open();
			stmt = con.prepareStatement("Insert into jogos values(null,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString (1, jogos.getNomeJogos());
			
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys(); // retornando a chave..

			rs.next(); // ativar a leitura dos dados..

			jogos.setIdJogos(rs.getInt(1)); // posi��o da chave...

			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jogos.getIdJogos();
	}
	
	/**
	 *Respons�vel por montar a combo da p�gina JOGOS CADASTRADOS, trar� como resultado 
	 *somente os jogos que o usu�rio possui no sistema 
	 * 
	 * @param pessoa
	 * @return
	 * @throws Exception
	 */
	public List<Jogos>listarJogosPessoas( Pessoa pessoa ) throws Exception{
		open();
		
		stmt = con.prepareStatement(
				" SELECT j.idJogos, j.jogos                                                      " +
 	   			"    FROM jogos j                                                                " +
                "   INNER JOIN pessoa_jogo_plataforma_role pj ON pj.pjpr_jogo_codigo = j.idJogos " +
                "   WHERE pj.pjpr_pessoa_codigo = ?                                              " );
		
		stmt.setInt(1,pessoa.getIdPessoa() );
		
		rs = stmt.executeQuery();
		
		List<Jogos> lista = new ArrayList<>();
		
		while(rs.next()){
			lista.add( new Jogos( rs.getInt(1),
								  rs.getString(2)));
		}
		close();
		
		return lista;
	}
	
	/**
	 * Retorna todos os jogos cadastrados no sistema
	 * @return
	 * @throws Exception
	 */
	public List<Jogos> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select * from jogos");
		rs = stmt.executeQuery();
		List<Jogos> lista = new ArrayList<>();
		while (rs.next()) {
			lista.add(new Jogos(rs.getInt(1), rs.getString(2)));
		}
		close();
		return lista;
	}
	
	/**
	 * M�todo respos�vel por trazer somente os jogos que a pessoa n�o tem cadastrado
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Jogos> findAllPessoasJogos() throws Exception {
		open();
		stmt = con.prepareStatement("select * from jogos");
		rs = stmt.executeQuery();
		List<Jogos> lista = new ArrayList<>();
		while (rs.next()) {
			lista.add(new Jogos(rs.getInt(1), rs.getString(2)));
		}
		close();
		return lista;
	}
	
	/**
	 * M�todo respons�vel por montar a combo de plataforma de acordo com o jogo selecionado na combo anterior
	 * 
	 * @param idJogos
	 * @return
	 * @throws Exception
	 */
	public List<Plataformas>findAllJogo(Integer idJogos) throws Exception {

		open();

		stmt = con
				.prepareStatement("	select p.idPlataformas, p.nomePlataforma                                            "
						+ "	          from Plataformas p                                                                "
						+ "	          inner join jogos_plataformas jp on p.idPlataformas = jp.plataformas_idPlataformas "
						+ "	          inner join jogos j on jp.jogos_idJogos = j.idJogos                                "
						+ "	          and j.idJogos = ?                                                                 ");

		stmt.setInt(1, idJogos);

		rs = stmt.executeQuery();

		List<Plataformas> lista = new ArrayList<>();

		while (rs.next()) {
			lista.add(new Plataformas(
					rs.getInt(1),
					rs.getString(2)));
		}

		close();

		return lista;
	}

	/**
	 * 
	 * @param jogos
	 * @param roles
	 * @throws Exception
	 */
	public boolean alocarJogosRoles(Jogos jogos, Roles roles) throws Exception {

		boolean bOk = false;

		try {

			open();

			stmt = con.prepareStatement("insert into jogos_roles values(?,?)");

			stmt.setInt(1, jogos.getIdJogos());
			stmt.setInt(2, roles.getIdRoles());
			stmt.executeUpdate();
			close();
			bOk = true;

		} catch (Exception e) {
			System.out.println("Cliente j� alocado!!!");
			e.printStackTrace();
		}
		return bOk;
	}

	/**
	 * 
	 * @param jogos
	 * @param roles
	 * @throws Exception
	 */
	public boolean alocarJogosPlataformas(Plataformas plataformas, Jogos jogos)
			throws Exception {

		boolean bOk = false;

		try {

			open();

			stmt = con
					.prepareStatement("insert into jogos_plataformas values(?,?)");

			stmt.setInt(1, jogos.getIdJogos());
			stmt.setInt(2, plataformas.getIdPlataforma());

			stmt.execute();

			close();

			bOk = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return bOk;
	}
	
	/**
	 * 
	 * @param idPessoa
	 * @param jogos
	 * @throws Exception
	 */
	public List<Jogos> buscarJogosCadastradosPessoas(Integer idPessoa) throws Exception {
		open();
		

			stmt = con.prepareStatement(                                                                
					 "  select j.idJogos as idJogo,j.jogos as nomeJogo, p.idPlataformas as idPlataforma,p.nomePlataforma, " +
					 " 		r.idRoles as idRole, r.nomeRoles as nomeRole, pjp.status                                      " +
					 "  from pessoa_jogo_plataforma_role pjp                                                              " +
					 "  INNER JOIN jogos j on j.idJogos = pjp.pjpr_jogo_codigo                                            " + 
					 "  INNER JOIN plataformas p on pjp.pjpr_plataforma_codigo = p.idPlataformas                          " +
					 "  INNER JOIN roles r on pjp.pjpr_role_codigo = r.idRoles                                            " +
					 " 	WHERE pjp.pjpr_pessoa_codigo = ?                                                                  ");
			
				stmt.setInt(1, idPessoa);
			
			
			rs = stmt.executeQuery();
			
			
			List<Jogos>jogosLst = new ArrayList<>();

			
			while(rs.next()){
				
				Jogos jogo = new Jogos();
				Plataformas plataforma = new Plataformas();
				Roles role = new Roles();
				
				jogo.setIdJogos  ( rs.getInt("idJogo"));
				jogo.setNomeJogos(rs.getString("nomeJogo"));
				jogo.setStatus   (rs.getBoolean("status"));
				
				plataforma.setIdPlataforma(rs.getInt("idPlataforma"));
				plataforma.setNomePlataforma(rs.getString("nomePlataforma"));
				
				role.setIdRoles(rs.getInt("idRole"));
				role.setNome(rs.getString("nomeRole"));
				
				List<Plataformas> plataformas = new ArrayList<>();
				List<Roles> roles = new ArrayList<>();
				
				plataformas.add(plataforma);
				roles.add(role);
				
				jogo.setRoles(roles);
				jogo.setPlataformas(plataformas);
				
				jogosLst.add(jogo);				
			}
			
		close();
		return jogosLst;
	}
	
	/**
	 * 
	 * @param idPessoa
	 * @param jogos
	 * @throws Exception
	 */
	public List<Jogos> buscarJogosCadastradosPessoasJogos(Integer idPessoa,Integer idJogo) throws Exception {
		open();
		

			stmt = con.prepareStatement(                                                                
					 "  select j.idJogos as idJogo,j.jogos as nomeJogo, p.idPlataformas as idPlataforma,p.nomePlataforma, " +
					 " 		r.idRoles as idRole, r.nomeRoles as nomeRole                                                  " +
					 "  from pessoa_jogo_plataforma_role pjp                                                              " +
					 "  INNER JOIN jogos j on j.idJogos = pjp.pjpr_jogo_codigo                                            " + 
					 "  INNER JOIN plataformas p on pjp.pjpr_plataforma_codigo = p.idPlataformas                          " +
					 "  INNER JOIN roles r on pjp.pjpr_role_codigo = r.idRoles                                            " +
					 " 	WHERE pjp.pjpr_pessoa_codigo = ? "+
					 "    AND pjp.pjpr_jogo_codigo = ? ");
			
				stmt.setInt(1, idPessoa);
				stmt.setInt(2, idJogo);
			
			rs = stmt.executeQuery();
			
			
			List<Jogos>jogosLst = new ArrayList<>();

			
			while(rs.next()){
				
				Jogos jogo = new Jogos();
				Plataformas plataforma = new Plataformas();
				Roles role = new Roles();
				
				jogo.setIdJogos  ( rs.getInt("idJogo"));
				jogo.setNomeJogos(rs.getString("nomeJogo"));
				
				plataforma.setIdPlataforma(rs.getInt("idPlataforma"));
				plataforma.setNomePlataforma(rs.getString("nomePlataforma"));
				
				role.setIdRoles(rs.getInt("idRole"));
				role.setNome(rs.getString("nomeRole"));
				
				List<Plataformas> plataformas = new ArrayList<>();
				List<Roles> roles = new ArrayList<>();
				
				plataformas.add(plataforma);
				roles.add(role);
				
				jogo.setRoles(roles);
				jogo.setPlataformas(plataformas);
				
				jogosLst.add(jogo);				
			}
			
		close();
		return jogosLst;
	}
	
	/**
	 * 
	 * @param idJogo
	 * @return
	 * @throws Exception
	 */
	public String buscarNomeJogo(int idJogo)throws Exception{
		open();
		
		stmt = con.prepareStatement("select jogos from jogos where idJogos = ? ");
		stmt.setInt(1, idJogo);
		
		rs = stmt.executeQuery();
		
		String nomeJogo = "";
		
		if(rs.next()){
			nomeJogo = rs.getString("jogos");
		}
		
		close();
		
		return nomeJogo;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	public Boolean isJogoCadastrado(int idJogo, int idPessoa ) throws Exception{
		open();
		
		boolean bOk = false;
		
		stmt = con.prepareStatement(  " select * from pessoa_jogo_plataforma_role "
		 							+ "        where pjpr_pessoa_codigo = ?       "
		 							+ "          and pjpr_jogo_codigo   = ?       " );
		
		 rs =  stmt.executeQuery();
		 
		 if(rs.next()){
			 bOk = true;
		 }
		 
		 close();
		
		 return bOk;
	}
	
	public void updateJogos(int idJogo, String nomeJogo)throws Exception{
		open();
		
		stmt = con.prepareStatement("update jogos set jogos = ? where idJogos = ? ");
		stmt.setString( 1, nomeJogo);
		stmt.setInt   ( 2, idJogo);
		
		stmt.execute();
		
		close();
	}
}
