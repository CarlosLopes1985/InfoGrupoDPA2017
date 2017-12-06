package br.com.projetofinal.validacoes;

import br.com.projetofinal.persistence.Dao;

public class CadastroUsuario extends Dao {
	
	/**
	 *  Responsï¿½vel de validar se o nomeUsuario informado existe ou nï¿½o
	 * @param nomeUsuario
	 * @return
	 */
	public boolean ifExistsNomeUsuario(String nomeUsuario){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from pessoa where nomeUsuario = ?" );
			stmt.setString(1, nomeUsuario);
			rs = stmt.executeQuery();
			
			if( rs.next() )
				bOk = true;
			else
				bOk = false;
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return bOk;
	}
	
	/**
	 *  Responsï¿½vel de validar se o nomeUsuario informado existe ou nï¿½o
	 * @param nomeUsuario
	 * @return
	 */
	public boolean ifExistsNomeJogos(String jogos){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from jogos where jogos = ?" );
			stmt.setString(1, jogos);
			rs = stmt.executeQuery();
			
			if( rs.next() )
				bOk = true;
			else
				bOk = false;
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return bOk;
	}
	
	/**
	 * 
	 * @param nomePlataforma
	 * @return
	 */
	public boolean ifExistsNomeRoles(String roles){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from roles where nomeRoles = ?" );
			stmt.setString(1, roles );
			rs = stmt.executeQuery();
			
			if( rs.next() )
				bOk = true;
			else
				bOk = false;
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return bOk;
	}
	
	/**
	 *  Responsï¿½vel de validar se o nomeUsuario informado existe ou nï¿½o
	 * @param nomeUsuario
	 * @return
	 */
	public boolean ifExistsNomePlataformas(String nomePlataforma){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from plataformas where nomePlataforma = ?" );
			stmt.setString(1, nomePlataforma );
			rs = stmt.executeQuery();
			
			if( rs.next() )
				bOk = true;
			else
				bOk = false;
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return bOk;
	}
	
	
	
	/**
	 * Responsï¿½vel de validar se o email informado existe ou nï¿½o
	 * 
	 * @param email
	 * @return
	 */
	public boolean ifExistsEmail(String email){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from login where email = ?" );
			stmt.setString(1, email);
			
			rs = stmt.executeQuery();
			
			if( rs.next() )
				bOk = true;
			else
				bOk = false;
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return bOk;
	}
	
	/** Responsável de validar se o jogo informado já existe no sistema
	 * 
	 * @param email
	 * @return
	 */
	public boolean ifExistsJogos(String NomeJogos){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from Jogos where nomeJogo = ?" );
			stmt.setString(1, NomeJogos );
			
			rs = stmt.executeQuery();
			
			if( rs.next() )
				bOk = true;
			else
				bOk = false;
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return bOk;
	}
	
	/** Responsável de validar se o jogo informado já existe no sistema
	 * 
	 * @param email
	 * @return
	 */
	public boolean ifExistsPlataformas(String nomePlataformas){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from Platafaormas where nomePlataformas = ?" );
			stmt.setString(1, nomePlataformas );
			
			rs = stmt.executeQuery();
			
			if( rs.next() )
				bOk = true;
			else
				bOk = false;
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return bOk;
	}
	
	/** Responsável de validar se o jogo informado já existe no sistema
	 * 
	 * @param email
	 * @return
	 */
	public boolean ifExistsRoles(String nomeRoles){
		
		Boolean bOk = true;
		try {
			open();
			
			stmt = con.prepareStatement("select 1 from Jogos where nomeJogo = ?" );
			stmt.setString(1, nomeRoles );
			
			rs = stmt.executeQuery();
			
			if( rs.next() )
				bOk = true;
			else
				bOk = false;
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return bOk;
	}
	
	public static void main(String[] args) {
		
		CadastroUsuario cd = new CadastroUsuario();
		
		if( cd.ifExistsNomeUsuario("carloslopes") == true ){
			System.out.println("Nome existe");
		}else 
			System.out.println("Nï¿½o existe!!!");
		
	}
	
}
