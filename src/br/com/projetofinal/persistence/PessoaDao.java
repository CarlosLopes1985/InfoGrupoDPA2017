package br.com.projetofinal.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.modelo.Classificacao;
import br.com.projetofinal.modelo.Jogos;
import br.com.projetofinal.modelo.Login;
import br.com.projetofinal.modelo.Pessoa;
import br.com.projetofinal.modelo.Plataformas;
import br.com.projetofinal.modelo.Roles;

public class PessoaDao extends Dao {
	
	/**
	 * Respos�vel por alterar as roles e plataformas do usu�rio
	 * @param pessoa
	 * @param jogos
	 * @param roles
	 * @param plataforma
	 * @throws Exception
	 */
	public void alterarPessoaJogoPlataforma( Pessoa pessoa, Jogos jogos,Roles roles, Plataformas plataforma )
			throws Exception{
		try {
			
		
		open();
		
		stmt = con.prepareStatement("update pessoa_jogo_plataforma_role                       "
				                  + "   set pjpr_plataforma_codigo = ?, pjpr_role_codigo = ?  "
				                  + " where pjpr_pessoa_codigo     = ?                        "
				                  + "   and pjpr_jogo_codigo       = ?                        " );
		
		stmt.setInt(1, plataforma.getIdPlataforma() );
		stmt.setInt(2, roles.getIdRoles());
		stmt.setInt(3, pessoa.getIdPessoa() );
		stmt.setInt(4, jogos.getIdJogos() );
		
		stmt.executeUpdate();
		
		close();
		} catch (Exception e) {
			throw new Exception("Pessoa j� cadastrada no sistema!!!");
		}
	}
	
	
	/**
	 * Respons�vel por cadastrar o usu�rio no sistema
	 * 
	 * @param pessoa
	 * @throws Exception
	 */
	public void gravarPessoa( Pessoa pessoa )throws Exception{
		
		try {
			open();

			stmt = con.prepareStatement("insert into pessoa values(null,?,?,?,?,?,?)"
					,PreparedStatement.RETURN_GENERATED_KEYS);
					
			stmt.setString(1, pessoa.getNomeUsuario());

			java.sql.Timestamp dataNasc = new java.sql.Timestamp(pessoa.getDataNascimento().getTime());
			stmt.setTimestamp(2, dataNasc);
			
			java.sql.Timestamp dataCad = new java.sql.Timestamp(pessoa.getDataCadastro().getTime());
			stmt.setTimestamp(3, dataCad);
			
			stmt.setString  (4, pessoa.getFoto());
			stmt.setString(5, pessoa.getSexo());
			stmt.setInt   (6, pessoa.getLogin().getIdLogin());
			
			stmt.execute();
			
			rs = stmt.getGeneratedKeys(); //retornando a chave..

			rs.next(); //ativar a leitura dos dados..

			pessoa.setIdPessoa(rs.getInt(1)); //posi��o da chave...

			close();
			ClassificacaoDao cd = new ClassificacaoDao();
			
			cd.gravarClassificacao( pessoa );

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	/**
	 * 
	 * @param idRole
	 * @param idJogo
	 * @param idPlataforma
	 * @return
	 * @throws Exception
	 */
	public List<Pessoa>findAllPessoasJogando( int idRole, int idJogo, int idPlataforma ) throws Exception{
		open();
		
		String sql = "select pjpr.pjpr_pessoa_codigo as codigoPessoa, cla.mediaTotal, p.nomeUsuario as nomePessoa,    "
				+    "pjpr.pjpr_plataforma_codigo as codigoPlataforma, l.nomePlataforma, p.foto,                      "
				+    "pjpr.pjpr_jogo_codigo as codigoJogo, j.jogos as nomeJogo,                                       "
				+    "pjpr.pjpr_role_codigo as codigoRole, r.nomeRoles as nomeRole                                    "
                                                                                                                      
				+    "from pessoa_jogo_plataforma_role pjpr                                                           "
                                                                                                                      
				+    "inner join pessoa p                                                                             "
				+    "on pjpr.pjpr_pessoa_codigo = p.idPessoa                                                         "
                     
				+    "inner join plataformas l                                                                        "
				+    "on pjpr.pjpr_plataforma_codigo = l.idPlataformas                                                "
                                                                                                                      
				+    "inner join jogos j                                                                              "
				+    "on pjpr.pjpr_jogo_codigo = j.idJogos                                                            "
                                                                                                                      
				+    "inner join roles r                                                                              "
				+    "on pjpr.pjpr_role_codigo = r.idRoles                                                            "
				                                                                                                      
                +    "inner join classificacao cla                                                                    "
                +    "on cla.pessoa_id = p.idPessoa                                                             	  "
                                                                                                                      
				+    "and l.idPlataformas = ?                                                                         "
                                                                                                                      
				+    "and j.idJogos = ?                                                                               "
                                                                                                                      
				+    "and r.idRoles = ?                                                                               "
				+    "and pjpr.status = true                                                                             ";
		                                                                                                                                                            
		stmt = con.prepareStatement(sql);
		
		stmt.setInt( 1, idPlataforma );
		stmt.setInt( 2, idJogo       );
		stmt.setInt( 3, idRole       );
		
		rs = stmt.executeQuery();
		
		List<Pessoa>pessoas = new ArrayList<>();
		List<Jogos>jogos = new ArrayList<>();
		List<Roles>roles = new ArrayList<>();
		
		while( rs.next( ) ){
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setIdPessoa(rs.getInt("codigoPessoa"));
			pessoa.setNomeUsuario(rs.getString("nomePessoa"));
			pessoa.setFoto(rs.getString("foto"));
			
			Jogos jogo = new Jogos();
			
			jogo.setIdJogos(rs.getInt("codigoJogo"));
			jogo.setNomeJogos(rs.getString("nomeJogo"));
			
			Roles role = new Roles();
			role.setIdRoles(rs.getInt("codigoRole"));
			role.setNome(rs.getString("nomeRole"));
			
			Classificacao cla = new Classificacao();
			cla.setMediaTotal(rs.getDouble("mediaTotal"));
			
			jogos.add(jogo);
			roles.add(role);
			
			pessoa.setJogos(jogos);
			pessoa.setRoles(roles);
			pessoa.setClassificacao(cla);
			pessoas.add(pessoa);
		}
		
		close();

		return pessoas;
	}
	
	/**
	 * Respos�vel por dizer quais roles, plataformas e jogos a pessoa esta alocada
	 * @param pessoa
	 * @param jogos
	 * @param roles
	 * @param plataforma
	 * @throws Exception
	 */
	public void alocarPessoaJogoPlataforma( Pessoa pessoa, Jogos jogos,Roles roles, Plataformas plataforma )
			throws Exception{
		try {
			
		
		open();
		
		stmt = con.prepareStatement("insert into pessoa_jogo_plataforma_role values(null,?,?,?,?,?)");
		
		stmt.setInt(1, pessoa.getIdPessoa() );
		stmt.setInt(2, plataforma.getIdPlataforma() );
		stmt.setInt(3, roles.getIdRoles());
		stmt.setInt(4, jogos.getIdJogos() );
		stmt.setBoolean(5, true);
		
		stmt.execute();
		
		close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new Exception("Pessoa j� cadastrada no sistema!!!");
		}
	}
	
	//######################################
	//######################################
	//######################################
	
	/**
	 * 
	 * @param idPessoa
	 * @return
	 * @throws Exception
	 */
	public List<Pessoa> findAllPessoaLogin( )throws Exception{
		open();
		
		stmt = con.prepareStatement("Select p.idPessoa, p.nomeUsuario,l.email, p.sexo, p.dataNascimento,p.dataCadastro,l.status " +
				                    " from pessoa p "
				                  + " inner join login l on p.id_Login = l.idLogin order by p.dataCadastro" );
		
		rs = stmt.executeQuery();
		
		List<Pessoa>pessoasLogin = new ArrayList<>();
		
		while(rs.next( ) )
		{
			Pessoa p = new Pessoa();
			Login l  = new Login();
			p.setIdPessoa      ( rs.getInt   ( "idPessoa" )       );
			p.setNomeUsuario   ( rs.getString( "nomeUsuario" )    );
			l.setEmail         ( rs.getString("email" )           );
			p.setSexo          ( rs.getString( "sexo" )           );
			p.setDataNascimento( rs.getDate  ( "dataNascimento" ) );
			p.setDataCadastro  ( rs.getDate  ( "dataCadastro"   ) );
			l.setStatus        ( rs.getBoolean("status")          );
			
			p.setLogin(l);
			
			pessoasLogin.add(p);
		}
		
		return pessoasLogin;
	}
	
	public static void main(String[] args) {
		
		try {
			
		PessoaDao pd = new PessoaDao();
		
		List<Pessoa>pessoas = pd.findAllPessoaLogin();
		
		System.out.println(pessoas);
		
		} catch (Exception e) {
		e.printStackTrace();
		e.getMessage();
		}
	}

	/**
	 * 
	 * @param pessoa
	 */
	public void updateFotoPerfil( Pessoa pessoa) {
		try {
			open();
			
			stmt = con.prepareStatement("update Pessoa set foto = ? where idPessoa = ? ");
			stmt.setString(1, pessoa.getFoto() );
			stmt.setInt(2, pessoa.getIdPessoa());
			
			stmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}