package br.com.projetofinal.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.modelo.Pessoa;
import br.com.projetofinal.modelo.chat.Chat;
import br.com.projetofinal.modelo.chat.Mensagem;
import br.com.projetofinal.modelo.chat.Sala;

public class ChatDao extends Dao {
	
	/**
	 * 
	 * @param mensagem
	 */
	public void cadastrarMensagem(Mensagem mensagem) {
		try {
			open();
			
			stmt = con.prepareStatement("insert into mensagem values(null,?,?,?,current_date,current_time)");
			stmt.setInt(1, mensagem.getPessoa().getIdPessoa());
			stmt.setInt(2, mensagem.getSala().getIdSala());
			stmt.setString(3, mensagem.getMensagem());
			stmt.execute();
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param statusMsg
	 * @param mensagem
	 */
	public void alteraStatusMsg(boolean statusMsg, Mensagem mensagem) {
		try {
			open();
			
			stmt = con.prepareStatement("update chat set statusMsg = true "
					+ "where idSala = ? "
					+ "and idPessoa <> ?");
			stmt.setInt(1, mensagem.getSala().getIdSala());
			stmt.setInt(2, mensagem.getPessoa().getIdPessoa());
			stmt.execute();
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param idPessoa
	 * @param idChat
	 */
	public void gravarChat(Integer idPessoa, Integer idChat){
		try {
			open();

			stmt =  con.prepareStatement("insert into chat values(null,?,?,false)");
			stmt.setInt(1, idChat);
			stmt.setInt(2, idPessoa);
			
			stmt.execute();
			
			close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param nomeSala
	 * @param sala
	 */
	public void gravarSala(String nomeSala,Sala sala){
		
		try {
			open();
			
			stmt =  con.prepareStatement("insert into sala values(null,?)"
					,PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, nomeSala);
			
			stmt.execute();
		
			rs = stmt.getGeneratedKeys(); //retornando a chave..

			rs.next(); //ativar a leitura dos dados..

			sala.setIdSala( rs.getInt(1));
			sala.setNomeSala(nomeSala);
			
			close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * se existir retorna True e se não existir retorna False
	 * 
	 * @param idPessoaBuscada
	 * @param idPessoa
	 * @return
	 */
	public boolean validaSalaIfExists(Sala sala, String pessoasNomes) {
		
		Boolean bOk= false;
		
		try {
			open();
			
			stmt =  con.prepareStatement("select * from sala where nomeSala = ? " );
			
			stmt.setString( 1, pessoasNomes );
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				
				sala.setIdSala  (rs.getInt(1) );
				sala.setNomeSala(rs.getString(2));
				bOk = true;
			}
			
			close();
			
			return bOk;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bOk;
	}
	
	/**
	 * 
	 * @param pessoa
	 * @return
	 */
	public boolean ativaBadge(Pessoa pessoa) {

		try {
			open();
			
			String sql = "select c.idChat, c.idSala, s.nomeSala, c.idPessoa, c.statusMsg "
				+ "from chat c "
				+ "inner join sala s "
				+ "on c.idSala = s.idSala "
				+ "where idPessoa = ? "
				+ "and statusMsg = 1";
			
			stmt =  con.prepareStatement(sql);
			
			stmt.setInt(1, pessoa.getIdPessoa());
			
			rs = stmt.executeQuery();
			
			if (rs.next()){

				return true;
					
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param pessoa
	 * @return
	 */
	public List<Chat> verificaStatusMsg(Pessoa pessoa) {

		try {
			open();
			
			String sql = "select c.idChat, c.idSala, s.nomeSala, c.idPessoa, c.statusMsg "
				+ "from chat c "
				+ "inner join sala s "
				+ "on c.idSala = s.idSala "
				+ "where idPessoa = ? ";
			
			stmt =  con.prepareStatement(sql);
			
			stmt.setInt(1, pessoa.getIdPessoa());
			
			rs = stmt.executeQuery();
			
			List<Chat> chats = new ArrayList<>();

			while(rs.next()){

				Chat chat = new Chat();
				Sala sala = new Sala();

				chat.setIdChat(rs.getInt("idChat"));
				sala.setIdSala(rs.getInt("idSala"));
				sala.setNomeSala(rs.getString("nomeSala"));
			    chat.setStatusMsg(rs.getBoolean("statusMsg"));
				
				chat.setSala(sala);
				
				chats.add(chat);
			}
			close();
			
			return chats;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param idSala
	 * @return
	 * @throws Exception
	 */
	public List<Mensagem> getListaMensagens(Integer idSala) throws Exception {
		open();
		
		stmt =  con.prepareStatement(
			" select m.idMensagem, m.idPessoa,   p.nomeUsuario,        "+
			"        m.idSala,     m.dataMsg,    m.horaMsg, m.mensagem "+ 
			"   from mensagem m                                        "+
			"  inner join pessoa p on m.idPessoa = p.idPessoa          "+
			"  where idSala = ?                                        "+
			"  order by dataMsg asc, horaMsg asc                       " );
		
		stmt.setInt(1, idSala);
		
		rs = stmt.executeQuery();
		List<Mensagem>mensagens = new ArrayList<>();
		
		while(rs.next()){
			
			Mensagem mensagem = new Mensagem();
			Pessoa     pessoa = new Pessoa();
			
			mensagem.setIdMensagem  ( rs.getInt   ( "idMensagem"  ));
			pessoa.setIdPessoa      ( rs.getInt   ( "idPessoa"    ));
			pessoa.setNomeUsuario   ( rs.getString( "nomeUsuario" ));
			mensagem.setDataMensagem( rs.getDate  ( "dataMsg"     ));
			mensagem.setHoraMsg     ( rs.getString( "horaMsg"     ));
			mensagem.setMensagem    ( rs.getString( "mensagem"    ));
			
			mensagem.setPessoa(pessoa);
			
			mensagens.add(mensagem);
		}
		
		close();
		
		return mensagens;
	}

	/**
	 * 
	 * @param idPessoa
	 * @throws Exception 
	 */
	public void updatestatusMsg(Integer idPessoa, Integer idSala) throws Exception {
		open();
		
		stmt = con.prepareStatement("update chat set statusMsg = ? where idPessoa = ? and idSala= ?" );
		stmt.setBoolean( 1, false    );
		stmt.setInt    ( 2, idPessoa );
		stmt.setInt    ( 3, idSala   );
		
		stmt.execute();
		
		close();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Pessoa> getListaPessoasConversas() {
		
		try {
			open();
			
			stmt = con.prepareStatement(""
					+ ""
					+ ""
					+ "");
			
			close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	
}
