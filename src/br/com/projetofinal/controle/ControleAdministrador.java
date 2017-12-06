package br.com.projetofinal.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import br.com.projetofinal.modelo.Jogos;
import br.com.projetofinal.modelo.Pessoa;
import br.com.projetofinal.modelo.Plataformas;
import br.com.projetofinal.modelo.Roles;
import br.com.projetofinal.persistence.JogosDao;
import br.com.projetofinal.persistence.PessoaDao;
import br.com.projetofinal.persistence.PlataformaDao;
import br.com.projetofinal.persistence.RolesDao;

/**
 * Servlet implementation class ControleAdministrador
 */
@WebServlet("/ControleAdministrador")
public class ControleAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleAdministrador() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String cmd = request.getParameter("cmd");

		if (cmd.equalsIgnoreCase("cadastrarJogos")) 
			cadastrarJogos(request, response);
		if (cmd.equalsIgnoreCase("cadastrarPlataformas")) 
			cadastrarPlataformas(request, response);
		if (cmd.equalsIgnoreCase("cadastrarRoles")) 
			cadastrarRoles(request, response);
		if (cmd.equalsIgnoreCase("alocarJogoRole")) 
			alocarJogoRoles(request, response);
		if (cmd.equalsIgnoreCase("alocarPlataformaJogo")) 
			alocarPlataformaJogos(request, response);
		if (cmd.equalsIgnoreCase("alterarJogos"))
			alterarJogos(request,response);
		if (cmd.equalsIgnoreCase("alterarPlataformas"))
			alterarPlataformas(request,response);
		if (cmd.equalsIgnoreCase("alterarRoles"))
			alterarRoles(request,response);
		if (cmd.equalsIgnoreCase("consultaJogadoresSistema"))
			consultaJogadoresSistema(request,response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void consultaJogadoresSistema(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			PessoaDao pd = new PessoaDao();
			
			List<Pessoa>pessoas = pd.findAllPessoaLogin();
			
			JSONObject resposta = new JSONObject();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			resposta.put("pessoasLogin", pessoas );
			response.getWriter().print(resposta);
			
			System.out.println(resposta);
			System.out.println(pessoas);
			
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
	private void alterarRoles(HttpServletRequest request, HttpServletResponse response) {
		
		try {

			int    idRoles   = new Integer(request.getParameter("idRoles"));
			String nomeRoles = request.getParameter("nomeRoles");
		
			RolesDao pd = new RolesDao();
			
			pd.alterarRoles(idRoles, nomeRoles );
			
			request.setAttribute("msg", "Role Alterado com Sucesso!!!");

			response.sendRedirect("administrador/adminRoles.jsp");
			
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
	private void alterarPlataformas(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			int    idPlataforma   = new Integer(request.getParameter("idPlataforma"));
			String nomePlataforma = request.getParameter("nomePlataformas");
		
			PlataformaDao pd = new PlataformaDao();
			
			pd.alterarPlataforma(idPlataforma, nomePlataforma );
			
			request.setAttribute("msg", "Jogo Alterado com Sucesso!!!");

			response.sendRedirect("administrador/adminPlataformas.jsp");
			
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
	private void alterarJogos(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			int idJogos = new Integer(request.getParameter("idJogo"));
			String nome = request.getParameter("nomeJogos");
			JogosDao jd = new JogosDao();
			
			jd.updateJogos(idJogos, nome);
			
			request.setAttribute("msg", "Jogo Alterado com Sucesso!!!");

			response.sendRedirect("administrador/logadoAdministrador.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void alocarPlataformaJogos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			Plataformas plataformas = new Plataformas();
			Jogos jogos             = new Jogos();
			JogosDao jd             = new JogosDao();
			
			jogos.setIdJogos(new Integer(request.getParameter("idJogos") ) );
			plataformas.setIdPlataforma(new Integer(request.getParameter("idPlataformas") ) );
			
			jd.alocarJogosPlataformas(plataformas, jogos);
			
			request.setAttribute("msg", "Plataforma alocada!!!");
		
			response.sendRedirect("administrador/adminPlataformas.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("msg", "Plataforma nï¿½o alocada: ERRO!!!");
			response.sendRedirect("administrador/adminPlataformas");
		}
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void alocarJogoRoles(HttpServletRequest request, HttpServletResponse response) {
		try {
			Jogos jogos = new Jogos();
			Roles roles = new Roles();
			JogosDao jd = new JogosDao();

			jogos.setIdJogos(new Integer(request.getParameter("idJogos")));
			roles.setIdRoles(new Integer(request.getParameter("idRoles")));

			jd.alocarJogosRoles(jogos, roles);

			request.setAttribute("msg", "Jogo Alocado com Sucesso!!!");

			response.sendRedirect("administrador/logadoAdministrador.jsp");

		} catch (Exception e) {
			request.setAttribute("msg", "Jogo já foi alocado!!!");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Cadastrar Roles
	 * @param request
	 * @param response
	 */
	private void cadastrarRoles(HttpServletRequest request, HttpServletResponse response) {
		try {
			Roles roles = new Roles();
			RolesDao rd = new RolesDao();
			
			roles.setNome(request.getParameter("nomeRoles") );
			
			rd.gravarRoles(roles);
			
			request.setAttribute("msg", "Role Cadastrado com Sucesso!!!");
			
			response.sendRedirect("administrador/adminRoles.jsp");
			
		} catch (Exception e) {
			request.setAttribute("msg", "Deu merda animal!!!");
			
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void cadastrarPlataformas(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Plataformas plataformas = new Plataformas();
			PlataformaDao        pd = new PlataformaDao();
			
			plataformas.setNomePlataforma(request.getParameter("plataformas") );
			
			pd.gravarPlataforma(plataformas);
			
			request.setAttribute("msg", "Plataforma Cadastrado com Sucesso!!!");
			
			response.sendRedirect("administrador/adminPlataformas.jsp");
		} catch ( Exception e ) {
			
			request.setAttribute("msg", "Deu merda animal!!!");
			
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void cadastrarJogos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
		Jogos jogos = new Jogos();
		JogosDao jd = new JogosDao();
		
		jogos.setNomeJogos(request.getParameter("nomeJogo"));
		
		jd.gravarJogos(jogos);
		
		request.setAttribute("msg", "true!!!");
		response.sendRedirect("administrador/logadoAdministrador.jsp");
		
		} catch (Exception e) {
			request.setAttribute("msg", "false!!!");
			request.getRequestDispatcher("administrador/logadoAdministrador.jsp").forward(request, response);
			
			e.printStackTrace();
		}
	}

}
