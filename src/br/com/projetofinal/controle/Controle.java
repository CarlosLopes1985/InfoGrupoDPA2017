package br.com.projetofinal.controle;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.projetofinal.modelo.Jogos;
import br.com.projetofinal.modelo.Login;
import br.com.projetofinal.modelo.Pessoa;
import br.com.projetofinal.modelo.Plataformas;
import br.com.projetofinal.modelo.Roles;
import br.com.projetofinal.modelo.chat.Chat;
import br.com.projetofinal.modelo.chat.Mensagem;
import br.com.projetofinal.modelo.chat.Sala;
import br.com.projetofinal.persistence.ChatDao;
import br.com.projetofinal.persistence.JogosDao;
import br.com.projetofinal.persistence.LoginDao;
import br.com.projetofinal.persistence.PessoaDao;
import br.com.projetofinal.persistence.RolesDao;
import br.com.projetofinal.util.DataFormate;
import br.com.projetofinal.util.EnviarEmail;
import br.com.projetofinal.util.Logs;
import br.com.projetofinal.validacoes.CadastroUsuario;

@WebServlet("/Controle")
public class Controle extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPessoa;
	
	private Logs log;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		execute(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * Responsï¿½vel por resgatar as flags das pï¿½ginas e redirecionar as seus
	 * respectivos mï¿½todos
	 * 
	 * @param request
	 * @param response
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			
			String cmd = request.getParameter("cmd");

			if(cmd.equalsIgnoreCase("logar"))
				logar(request, response);

			if(cmd.equalsIgnoreCase("gravar"))
				cadastrarPessoas(request, response);

			if(cmd.equalsIgnoreCase("lembrarSenha"))
				lembrarSenha(request, response);

			if(cmd.equalsIgnoreCase("mudarSenha"))
				mudarSenha(request, response);

			if(cmd.equalsIgnoreCase("listarPessoasJogando"))
				listarPessoasJogando(request, response);

			if(cmd.equalsIgnoreCase("consultaJogo"))
				consultaJogo(request, response);
			
			if(cmd.equalsIgnoreCase("validaNomeUsuario"))
				validaNomeUsuario(request, response);
			
			if(cmd.equalsIgnoreCase("validaEmail"))
				validaEmail(request, response);
			
			if(cmd.equalsIgnoreCase("alocarPessoaPlatRoles"))
				alocarPessoaPlataformaRoles(request,response);
				
			if(cmd.equalsIgnoreCase("filtrarJgCadastrados"))
				filtrarJogos(request,response);
			
			if(cmd.equalsIgnoreCase("buscarJogosCadastrados"))
				buscarJogosCadastrados(request,response);
			
			if(cmd.equalsIgnoreCase("montarTabelaJgCadastrados"))
				montarTabelaJgCadastrados(request,response);
			
			if(cmd.equalsIgnoreCase("buscarNomeJogo"))
				buscarNomeJogo( request, response );
			
			if(cmd.equalsIgnoreCase("alterarPlataformaRoles"))
				alterarPlataformaRoles( request, response );
			
			if(cmd.equalsIgnoreCase("updateJogoUsuario"))
				desativarJogos(request, response);
			
			if(cmd.equalsIgnoreCase("alterarJogos"))
				alterarJogos(request, response);
			
			if(cmd.equalsIgnoreCase("validaJogos"))
				validaJogos(request, response);
			
			if(cmd.equalsIgnoreCase("fileUpload"))
				uploadFotoPerfil(request,response);
			
			if(cmd.equalsIgnoreCase("cadastrarMensagem"))
				cadastrarMensagem(request,response);
			
			if(cmd.equalsIgnoreCase("carregaMensagens"))
				carregaMensagens(request,response);
			
			if(cmd.equalsIgnoreCase("criarSala"))
				criarSala(request,response);
			
			if (cmd.equalsIgnoreCase("verificaStatusMsg"))
				verificaStatusMsg(request, response);
			
			if (cmd.equalsIgnoreCase("ativaBadge"))
				ativaBadge(request, response);
			
			if (cmd.equalsIgnoreCase("consultaConversasRealizadas"))
				consultaConversasRealizadas(request, response);
			
		} catch (Exception e) {
			log.logSaida("execute");
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void consultaConversasRealizadas(HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		try {
			
			ChatDao cd = new ChatDao();
			
			List<Pessoa>pessasConversa = cd.getListaPessoasConversas();
			
			resposta.put("pessoasConversas", pessasConversa );
			response.getWriter().print(resposta);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void updateStatusMsg(Integer idPessoa, Integer idSala)throws Exception {
		
		ChatDao cd = new ChatDao();
		
		cd.updatestatusMsg( idPessoa, idSala );
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void carregaMensagens(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		Pessoa pessoa = (Pessoa)session.getAttribute("pessoa");
		try {
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		Integer idSala = new Integer(request.getParameter("idSala"));
		
		ChatDao cd = new ChatDao();
		
		List<Mensagem> mensagem = cd.getListaMensagens(idSala);
		
		resposta.put("mensagens", mensagem );
		response.getWriter().print(resposta);
		
		System.out.println(resposta.get("mensagens"));
		
		updateStatusMsg( pessoa.getIdPessoa(), idSala );
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void verificaStatusMsg(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		Pessoa pessoa = (Pessoa)session.getAttribute("pessoa");
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		try {
			
			ChatDao chatDao = new ChatDao();
			
			List<Chat> chats = chatDao.verificaStatusMsg(pessoa);
			
			if (!chats.isEmpty()) {
				resposta.put("chats", chats);
				resposta.put("resposta", "sim");
				response.getWriter().print(resposta);
			} else {
				resposta.put("resposta", "nao");
				response.getWriter().print(resposta);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
	}
	
	private void ativaBadge(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		Pessoa pessoa = (Pessoa)session.getAttribute("pessoa");
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		try {
			
//			Pessoa pessoa = new Pessoa();
//			pessoa.setIdPessoa(idPessoa);
			
			ChatDao chatDao = new ChatDao();
			
			if (chatDao.ativaBadge(pessoa)) {
				resposta.put("resposta", "sim");
				response.getWriter().print(resposta);
			} else {
				resposta.put("resposta", "nao");
				response.getWriter().print(resposta);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void criarSala(HttpServletRequest request,HttpServletResponse response)throws Exception {
		
		HttpSession session = request.getSession();
		
		Pessoa pessoa = (Pessoa)session.getAttribute("pessoa");
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			
			int idPessoaBuscada   = new Integer(request.getParameter("idPessoa"));
			String nomePessoas    = request.getParameter("nomeUsuario");
			String pessoasEpessoa = pessoa.getNomeUsuario() +" e " + nomePessoas;
			
			ChatDao cd = new ChatDao();
			Sala sala  = new Sala();

			if (!cd.validaSalaIfExists(sala, pessoasEpessoa)) {
			
				cd.gravarSala( pessoasEpessoa,sala );
	
				cd.gravarChat(pessoa.getIdPessoa(), sala.getIdSala());
				cd.gravarChat(idPessoaBuscada, sala.getIdSala());
			}
			
			resposta.put("idSala", sala.getIdSala());
			resposta.put("nomeSala", pessoasEpessoa);
			response.getWriter().print(resposta);
			//request.setAttribute("resposta", resposta);
			//request.getRequestDispatcher("usuario/messages.jsp").forward(request, response);
			//response.sendRedirect("usuario/messages.jsp");
			
			System.out.println("Passou aki1");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
private void cadastrarMensagem(HttpServletRequest request,HttpServletResponse response)throws Exception {
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		Pessoa pessoa = (Pessoa)session.getAttribute("pessoa");
		
		try {
			
		int idSala = Integer.parseInt(request.getParameter("idSala"));
		String msg = request.getParameter("texto");
		
//		Pessoa     pessoa = new Pessoa();
//		pessoa.setIdPessoa(idPessoa);
		
		Sala sala = new Sala();
		sala.setIdSala(idSala);
		
		Mensagem mensagem = new Mensagem();

		mensagem.setPessoa(pessoa);
		mensagem.setSala(sala);
		mensagem.setMensagem(msg);
		mensagem.setDataMensagem(new Date( ));
		
		ChatDao chatDao = new ChatDao();
		chatDao.cadastrarMensagem(mensagem);
		chatDao.alteraStatusMsg(true, mensagem);
		
		resposta.put("respostaNomeUsuario", mensagem.getPessoa().getNomeUsuario() );
		resposta.put("resposta", "sucesso");
		response.getWriter().print(resposta);
		

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			resposta.put("resposta", "fracasso");
			response.getWriter().print(resposta);
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void uploadFotoPerfil(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		try {
			
			String fileUpload = request.getParameter("fileUpload");
			System.out.println(fileUpload);
			
			//SerialBlob blob = new SerialBlob(fileUpload.getBytes());
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setFoto(fileUpload);
			pessoa.setIdPessoa(idPessoa);
			
			PessoaDao pd = new PessoaDao();
			
			pd.updateFotoPerfil(pessoa);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	private void validaJogos(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		JogosDao jd = new JogosDao();
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		int idJogo = new Integer(request.getParameter("idJogo"));
		
		if( jd.isJogoCadastrado(idJogo, idPessoa)==true ){
			System.out.println("Jogo já existe");
			resposta.put("resposta", "sucesso");
			response.getWriter().print(resposta);
		}else{
			resposta.put("resposta", "não existe");
			response.getWriter().print(resposta);
			System.out.println("jogo não existe");
		}
		
		
	}

	private void alterarJogos(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
		
		Integer id = new Integer(request.getParameter("idJogos") );
		
		JogosDao jd = new JogosDao();
		
		List<Jogos> jogos = jd.buscarJogosCadastradosPessoasJogos(idPessoa, id);
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//resposta.put("resposta", "true");
		resposta.put("jogos", jogos);
		
		
		System.out.println(jogos.toString());
		request.setAttribute("jogos", jogos);
		
		request.getRequestDispatcher("usuario/editarJogos.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void alterarPlataformaRoles(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		try {
			 PessoaDao pd = new PessoaDao();
			 
			 Jogos jogos = new Jogos();
			 Roles roles = new Roles();
			 Plataformas plataforma = new Plataformas();
			 Pessoa pessoa = new Pessoa();
			 
			 Integer id = new Integer(request.getParameter("jogos"));
			 jogos.setIdJogos(id);
			System.out.println("-------------->"+id);
			 roles.setIdRoles(new Integer(request.getParameter("funcao")));
			
			 plataforma.setIdPlataforma(new Integer(request.getParameter("plataforma")));
			 
			 pessoa.setIdPessoa(idPessoa);
			 
			 pd.alterarPessoaJogoPlataforma(pessoa, jogos, roles, plataforma);
			 
			 response.sendRedirect("usuario/jogosCadastrados.jsp");
			 request.setAttribute("msg", "Pessoa alocada com sucesso!!!");
			 System.out.println("Dados alterados");
		} catch (Exception e) {
			System.out.println("Deu merda!!!!");
			request.setAttribute("msg", "ERRO: Pessoa jï¿½ esta alocada nas devidas roles, plataformas e jogo!!!");
			response.sendRedirect("usuario/escolherJogos.jsp");
		}
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws JSONException 
	 */
	private void desativarJogos(HttpServletRequest request, HttpServletResponse response) throws JSONException {
		
		JSONObject resposta =  new JSONObject();
		
		try {

			int     idJogo = new Integer(request.getParameter("idNumero"));
			boolean status = new Boolean(request.getParameter("situacao"));
			boolean bStatus;

			if ( status == false )
				 bStatus = true;
			else
				 bStatus = false;

			JogosDao jd = new JogosDao( );

			jd.desativarJogos(idJogo, bStatus, idPessoa);

			resposta.put("resposta", "sucesso");
			System.out.println(resposta.toString());
			response.getWriter().print(resposta);

		} catch (Exception e) {
			
			resposta.put("resposta", "false");
			
			throw new IllegalArgumentException("Deu Merda aki!!!");
			
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void buscarNomeJogo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int idJogo = new Integer(request.getParameter("idJogo"));
		
		JogosDao jd = new JogosDao();
		
		String nomeJogo = jd.buscarNomeJogo(idJogo);
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		resposta.put("resposta", "true");
		resposta.put("nomeJogo", nomeJogo);

		System.out.println(resposta.toString());
		
		response.getWriter().print(resposta);
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void montarTabelaJgCadastrados(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		JogosDao jd = new JogosDao();
		
		List<Jogos>jogoscadastrados = jd.buscarJogosCadastradosPessoas(idPessoa);
		
		JSONObject resposta = new JSONObject();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		resposta.put("resposta", "true");
		resposta.put("listaJogosCadastrados", jogoscadastrados);

		System.out.println(resposta.toString());
		
		response.getWriter().print(resposta);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void buscarJogosCadastrados(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		JogosDao jd = new JogosDao();
		
		if (request.getParameter("idJogos") == null) {
			jd.buscarJogosCadastradosPessoas(idPessoa);
			System.out.println("Passou aki");
		} else {
			int idJogos = new Integer(request.getParameter("idJogos"));
			jd.buscarJogosCadastradosPessoasJogos(idPessoa, idJogos);
			System.out.println("Passou ali");
		}

	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void filtrarJogos(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(idPessoa);
			JogosDao jd = new JogosDao();
			
			List<Jogos> listaJogos = jd.listarJogosPessoas(pessoa);
			
			JSONObject resposta = new JSONObject();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			resposta.put("resposta", "true");
			resposta.put("listaJg", listaJogos);

			response.getWriter().print(resposta);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	/**
	 * Resposï¿½vel por alocar as pessoas nas plataformas, roles e jogos
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void alocarPessoaPlataformaRoles(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			 PessoaDao pd = new PessoaDao();
			 
			 Jogos jogos = new Jogos();
			 jogos.setIdJogos(new Integer(request.getParameter("jogo")));
			 System.out.println(new Integer(request.getParameter("jogo")));
			
			 Roles roles = new Roles();
			 roles.setIdRoles(new Integer(request.getParameter("funcao")));
			 System.out.println(new Integer(request.getParameter("funcao")));
			
			 Plataformas plataforma = new Plataformas();
			 plataforma.setIdPlataforma(new Integer(request.getParameter("plataforma")));
			 System.out.println(new Integer(request.getParameter("plataforma")));
			 
			 Pessoa pessoa = new Pessoa();
			 pessoa.setIdPessoa(idPessoa);
			 
			 pd.alocarPessoaJogoPlataforma(pessoa, jogos, roles, plataforma);
		
			 response.sendRedirect("usuario/escolherJogos.jsp");
			 request.setAttribute("msg", "Pessoa alocada com sucesso!!!");
		} catch (Exception e) {
			System.out.println("Deu merda!!!!");
			request.setAttribute("msg", "ERRO: Pessoa jï¿½ esta alocada nas devidas roles, plataformas e jogo!!!");
			response.sendRedirect("usuario/escolherJogos.jsp");
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void consultaJogo(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Jogos jogos = new Jogos();
			JogosDao jd = new JogosDao();
			RolesDao rd = new RolesDao();

			jogos.setIdJogos(new Integer(request.getParameter("idJogo")));

			System.out.println("IdJogos: " + jogos.getIdJogos());

			List<Plataformas> listaJogosPlataformas = jd.findAllJogo(jogos
					.getIdJogos());
		
			List<Roles> listaJogosRoles = rd.findAllJogoRoles(jogos
					.getIdJogos());

			for (int i = 0; i < listaJogosPlataformas.size(); i++) {
				System.out.println("listaJogosPlataformas[" + i + "] = " + listaJogosPlataformas.get(i));
			}
			
			for (int i = 0; i < listaJogosRoles.size(); i++) {
				System.out.println("listaJogosRoles[" + i + "] = " + listaJogosRoles.get(i));
			}
			
			JSONObject resposta = new JSONObject();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			resposta.put("resposta", "true");
			resposta.put("listaJR", listaJogosRoles);
			resposta.put("listaJP", listaJogosPlataformas);

			System.out.println(resposta.toString());
			
			response.getWriter().print(resposta);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void validaNomeUsuario(HttpServletRequest request,
			HttpServletResponse response) {

		CadastroUsuario validaCad = new CadastroUsuario();
		
		try {
			
			String nomeUsuario = request.getParameter("nomeUsuario");

			JSONObject resposta = new JSONObject();

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			if (validaCad.ifExistsNomeUsuario(nomeUsuario) == true) {
				resposta.put("existe", "sim");
			} else {
				resposta.put("existe", "nao");
			}
			
			response.getWriter().print(resposta);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void validaEmail(HttpServletRequest request,
			HttpServletResponse response) {

		CadastroUsuario validaCad = new CadastroUsuario();
		
		try {
			
			String email = request.getParameter("email");

			JSONObject resposta = new JSONObject();

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			if (validaCad.ifExistsEmail(email) == true) {
				resposta.put("existe", "sim");
			} else {
				resposta.put("existe", "nao");
			}
			
			response.getWriter().print(resposta);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listarPessoasJogando(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		PessoaDao pessoaDao = new PessoaDao();

		try {

			// List<Pessoa> pessoa = pessoaDao.findAllPessoasJogando();

			// response.setContentType("application/json");

			int plataforma = Integer.parseInt( request.getParameter("plataforma") );
			System.out.println("Plataforma = " + plataforma);
			int jogo       = Integer.parseInt( request.getParameter("jogo")       );
			System.out.println("Jogo = " + jogo);
			int role       = Integer.parseInt( request.getParameter("funcao")     );
			System.out.println("Role = " + role);
			
			JSONObject resposta = new JSONObject();
			
			resposta.put("pessoas", pessoaDao.findAllPessoasJogando(role, jogo, plataforma) );

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			System.out.println(resposta.toString());
			
			response.getWriter().print(resposta);
			
		} catch (Exception e) {
			System.out.println("Erro = " + e);
		}
	}

	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void mudarSenha(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Login login = new Login();
			LoginDao ld = new LoginDao();

			login.setSenha(request.getParameter("senha"));
			login.setPalavraChave(request.getParameter("chave"));

			ld.updateSenha(login);

			request.setAttribute("msg", "senha alterada com sucesso!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void lembrarSenha(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			EnviarEmail em = new EnviarEmail();
			LoginDao ld = new LoginDao();
			String email = request.getParameter("email");

			if (ld.findByEmail(email) == true) {
				em.enviarGmail(email);
				request.setAttribute("msg", "Email enviado com sucesso!!!");
				request.getRequestDispatcher("lembrarSenha.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Email inválido!!!");
				request.getRequestDispatcher("lembrarSenha.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void cadastrarPessoas(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			Login        login        = new Login();
			Pessoa      pessoa        = new Pessoa();
			PessoaDao       pd        = new PessoaDao();
			LoginDao        ld        = new LoginDao();
			DataFormate     df        = new DataFormate();
			EnviarEmail     em        = new EnviarEmail();
			
			String  fotoPadrao = "data:image/jpeg;base64,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";
			// Resgata os atributos da pessoa
			String nomeUsuario = request.getParameter("nomeUsuario");
			
			//Valida se nome do usuário existe no sistema
			pessoa.setNomeUsuario(nomeUsuario);
			
			Date data = df.converte(request.getParameter("dataNascimento"));
			
			pessoa.setDataNascimento(data);
			
			pessoa.setSexo(request.getParameter("sexo"));
			pessoa.setFoto(fotoPadrao);
			
			pessoa.setLogin(login);

			// Resgata os atributos do login
			String email = request.getParameter("email");
			
			//Valida se o email existe no sistema
			login.setEmail(email);
			
			login.setSenha(request.getParameter("senha"));
			login.setPalavraChave(em.gerarPalavraChave());

			ld.createLogin(login);
			pd.gravarPessoa(pessoa);
			
			response.getWriter().print("Servlet ...Dados Gravados ...");
			
			request.setAttribute("msg", "true");
			
			response.sendRedirect("index.html");

		} catch (Exception e) {
			request.setAttribute("msg", "false");
		}
	}

	/**
	 * Método Resposável por resgatar os dados da página referentes ao login do usuário ou administrador
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void logar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		HttpSession session = null; // sessão nula

		try {
			Login l = new Login();

			l.setEmail(email);
			l.setSenha(senha);

			session = request.getSession(true);

			Login resp = new LoginDao().findByLogin(l);
			LoginDao ld = new LoginDao();
			
			if (resp == null) {

				JSONObject resposta = new JSONObject();
				
				resposta.put("resposta", "true");
				
				response.getWriter().print(resposta);
				
				request.getRequestDispatcher("index.html").forward(request, response);
				
			} else if (resp != null) {
				if (resp.getPerfil().equalsIgnoreCase("usuario")) {
					
					session.setAttribute("usuario", resp);
					
					Pessoa pessoa = ld.findAllLogin(resp.getIdLogin( ));
					
					idPessoa  = pessoa.getIdPessoa();
					
					session.setAttribute("pessoa", pessoa);
					
					System.out.println(pessoa);
							
					response.sendRedirect("usuario/logadoUsuario.jsp");
					
					byte[] foto = Base64.decodeBase64(pessoa.getFoto());
					
					session.setAttribute("foto", foto);
					
					System.out.println("DataCadastro = " + pessoa.getDataCadastro());
					System.out.println("DataNascimento = " + pessoa.getDataNascimento());
					
				} else if ( resp.getPerfil().equalsIgnoreCase("administrador") ) {

					session.setAttribute("usuario", resp);
					
					Pessoa pessoa = ld.findAllLogin( resp.getIdLogin( ) );
					
					idPessoa   = pessoa.getIdPessoa();
				
					session.setAttribute("pessoa", pessoa);
					
					response.sendRedirect("administrador/logadoAdministrador.jsp");
					
					byte[] foto = Base64.decodeBase64(pessoa.getFoto());
					
					session.setAttribute("foto", foto);	
					
				} else {

					session.setAttribute("usuario", null);

					request.setAttribute("msg", "Usuario inválido!!!");
				
					request.getRequestDispatcher("index.html").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
