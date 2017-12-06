package br.com.projetofinal.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.modelo.Roles;

public class RolesDao extends Dao{

	public Integer gravarRoles( Roles roles )throws Exception{
		try {
			
		open();
			stmt =  con.prepareStatement("Insert into roles values(null,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, roles.getNome() );
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys(); //retornando a chave..

			rs.next(); //ativar a leitura dos dados..

			roles.setIdRoles(rs.getInt(1)); //posi��o da chave...

			close(); 
			} catch (Exception e) {
			e.printStackTrace();
		}
		return roles.getIdRoles();
	}

	/**
	 * 
	 * @param idJogo
	 * @return
	 * @throws Exception
	 */
	public List<Roles> findAll(Integer idJogo) throws Exception {

		open();

		List<Roles> lista = new ArrayList<>();

		if (idJogo == null) {

			stmt = con.prepareStatement("select * from roles");

		} else {
			stmt = con.prepareStatement("");
			stmt.setInt(1, idJogo);
		}

		rs = stmt.executeQuery();

		while (rs.next()) {
			lista.add(new Roles(rs.getInt(1), rs.getString(2)));
		}
		close();
		
		return lista;
	}
	
	/**
	 * M�todo Respons�vel por trazer as roles de acordo com o id do jogo selecionado
	 * @param idJogos
	 * @return
	 * @throws Exception
	 */
	public List<Roles>findAllJogoRoles(Integer idJogos )throws Exception{
		open();
		
		stmt = con.prepareStatement(
			"	      select r.idRoles, r.nomeRoles from Roles r                 " +    
			"	       inner join jogos_roles jr on r.idRoles = jr.Roles_idRoles " +
			"	       inner join jogos j on j.idJogos        = jr.jogos_idJogos " +
			"	         and j.idJogos = ?                                  	 " );                                                             
		
		stmt.setInt(1, idJogos );
		
		rs = stmt.executeQuery();
		
		
		List<Roles>lista = new ArrayList<>();
		
		while(rs.next( )){
			lista.add(new Roles(
					rs.getInt(1),
					rs.getString(2)));
		}
		
		close();
		
		return lista;
	}
	
	public List<Roles> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select * from roles");
		rs = stmt.executeQuery();
		List<Roles> lista = new ArrayList<>();
		while (rs.next()) {
			lista.add(new Roles
					(rs.getInt(1), 
					 rs.getString(2)
					) );
		}
		close();
		return lista;
	}

	/**
	 * 
	 * @param idRoles
	 * @param nomeRoles
	 * @throws Exception
	 */
	public void alterarRoles(int idRoles, String nomeRoles)throws Exception {
		open();
		
		stmt = con.prepareStatement("update roles set nomeRoles = ? where idRoles = ? ");
		
		stmt.setString( 1, nomeRoles );
		stmt.setInt   ( 2, idRoles   );
		
		stmt.executeUpdate();
		
		close();
	}
}
