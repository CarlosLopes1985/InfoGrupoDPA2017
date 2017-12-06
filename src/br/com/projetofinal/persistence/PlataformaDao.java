package br.com.projetofinal.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.modelo.Plataformas;

public class PlataformaDao extends Dao {

	

	public Integer gravarPlataforma( Plataformas plataforma )throws Exception{
		try {
			
		open();
			stmt =  con.prepareStatement("Insert into plataformas values(null,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, plataforma.getNomePlataforma() );
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys(); //retornando a chave..

			rs.next(); //ativar a leitura dos dados..

			plataforma.setIdPlataforma(rs.getInt(1)); //posi��o da chave...

			close(); 
			} catch (Exception e) {
			e.printStackTrace();
		}
		return plataforma.getIdPlataforma();
	}

	public List<Plataformas> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select * from plataformas");
		rs = stmt.executeQuery();
		List<Plataformas> lista = new ArrayList<>();
		while (rs.next()) {
			lista.add(new Plataformas
					(rs.getInt(1), 
					 rs.getString(2)
					) );
		}
		close();
		return lista;
	}

	/**
	 * 
	 * @param idPlataforma
	 * @param nomePlataforma
	 */
	public void alterarPlataforma(int idPlataforma, String nomePlataforma)throws Exception {
		open();
		
		stmt = con.prepareStatement("update plataformas set nomePlataforma = ? where idPlataformas = ?");
		stmt.setString( 1, nomePlataforma);
		stmt.setInt(2, idPlataforma );
		
		stmt.executeUpdate();
		
		close();
	}
	
}
