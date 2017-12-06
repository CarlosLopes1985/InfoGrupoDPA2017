package br.com.projetofinal.persistence;

import java.sql.PreparedStatement;

import br.com.projetofinal.modelo.Login;
import br.com.projetofinal.modelo.Pessoa;
import br.com.projetofinal.util.Criptografia;
import br.com.projetofinal.util.EnviarEmail;

public class LoginDao extends Dao {
	
	public int createLogin( Login l )throws Exception{
		open();
		
		Criptografia cf = new Criptografia();
		
		cf.criptografia(l);
		
		stmt = con.prepareStatement("insert into login values( null,?,?,?,?,?)"
				,PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, l.getEmail( ) );
		stmt.setString(2, l.getSenha( ) );
		stmt.setString(3, l.getPerfil( ) );
		stmt.setBoolean(4, l.getStatus( ) );
		stmt.setString(5, l.getPalavraChave());
		stmt.execute();
		
		rs = stmt.getGeneratedKeys(); //retornando a chave..

		rs.next(); //ativar a leitura dos dados..

		l.setIdLogin(rs.getInt(1)); //posi��o da chave...

		close(); 
		
		return l.getIdLogin(); //retornando a chave..
	}
	
	/**
	 * Verifica se o email do usu�rio existe no banco de dados
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public boolean findByEmail(String email) throws Exception{
		open();
		boolean bOk = false;
		
		stmt =  con.prepareStatement("Select l.email from login l where l.email = ? "); 
		stmt.setString(1, email);
		
		rs = stmt.executeQuery();
		
		if(rs.next()){
			bOk = true;
		}
		
		close();
		
		return bOk;
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public String buscarCodRecuperacao( String email )throws Exception{
		open();
		
		stmt =  con.prepareStatement("Select l.palavraChave from login l where l.email = ? "); 
		stmt.setString(1, email);
		rs =  stmt.executeQuery();
		String palavraChave = "";
		
		if(rs.next()){
			palavraChave = rs.getString(1);
		}
		
		close();
		
		return palavraChave;
	}
	
	/**
	 * 
	 * @param l
	 * @return
	 * @throws Exception
	 */
	public Login findByLogin( Login l )throws Exception{
		open();
		
		Criptografia cf = new Criptografia();
		
		cf.criptografia(l);
		
		stmt = con.prepareStatement("select * from login l where email= ? and senha= ? and status = ?");
		stmt.setString (1, l.getEmail( )  );
		stmt.setString (2, l.getSenha( )  );
		stmt.setBoolean(3, l.getStatus( ) );
		
		rs = stmt.executeQuery();
		
		Login login = null;
		
		 boolean b = l.getStatus();
		 
		 if( b == false ){
		    login = null;	 
		 }
		
		else if(rs.next( ) ){
			login = new Login();
			login.setIdLogin( rs.getInt    ( 1 ) );
			login.setEmail  ( rs.getString ( 2 ) );
			login.setSenha  ( rs.getString ( 3 ) );
			login.setPerfil ( rs.getString ( 4 ) );
			login.setStatus ( rs.getBoolean( 5 ) );
		}
		stmt.close();

		close();
		
		return login; //null (quando nao encontra) ou cheio
	}
	
	/**
	 * 
	 * @param login
	 * @throws Exception
	 */
	public void updateSenha(Login login)throws Exception {
		open();
		
		Criptografia        cf = new Criptografia();
		String palavraChaveNew = new EnviarEmail().gerarPalavraChave();
		String palavraChaveOld = login.getPalavraChave();
		
		cf.criptografia(login);
		
		stmt = con.prepareStatement("update login set senha = ? where palavraChave = ? ");
		stmt.setString(1, login.getSenha());
		stmt.setString(2, palavraChaveOld );
		
		stmt.executeUpdate();
		
		close();
		
		open();
		
		stmt = con.prepareStatement("update login set palavraChave = ? where palavraChave = ? ");
		
		stmt.setString(1, palavraChaveNew );
		stmt.setString(2, palavraChaveOld );
		
		stmt.executeUpdate();
		
		close();
		
	}

	/**
	 * Respons�vel por preencher a tela de perfil e a tela principal com os dados de pessoas
	 * @param idLogin
	 * @return
	 * @throws Exception
	 */
	public Pessoa findAllLogin(Integer idLogin)throws Exception{
		open();
		stmt = con.prepareStatement("select * from pessoa where id_Login = ?");
		stmt.setInt(1, idLogin);
		rs = stmt.executeQuery();
		
		Pessoa pessoa = null;
		
		if( rs.next( ) ){
			
			pessoa = new Pessoa();
			pessoa.setIdPessoa(rs.getInt(1));
			pessoa.setNomeUsuario(rs.getString("nomeUsuario"));
			pessoa.setDataNascimento(rs.getDate(3));
			pessoa.setDataCadastro(rs.getDate(4));
			pessoa.setFoto(rs.getString(5));
			
//			System.out.println("NOME PESSOA1:"+rs.getString(5));
//			System.out.println("NOME PESSOA2:"+rs.getString("nomeUsuario"));
			
			pessoa.setSexo(rs.getString(6));
			
		}
		stmt.close();
		
		close();
		return pessoa;
	}
}
