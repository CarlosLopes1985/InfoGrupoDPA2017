package br.com.projetofinal.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import br.com.projetofinal.validacoes.CadastroUsuario;

@WebServlet("/ControleValidacoes")
public class ControleValidacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request,HttpServletResponse response) {

		String cmd = request.getParameter("cmd");
		
		if (cmd.equalsIgnoreCase("validaJogosIfExist")) 
			validaJogosIfExist(request, response);
		if (cmd.equalsIgnoreCase("validaRolesIfExist")) 
			validaRolesIfExist(request, response);
		if (cmd.equalsIgnoreCase("validaPlataformasIfExist")) 
			validaPlataformasIfExist(request, response);
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void validaPlataformasIfExist(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			CadastroUsuario validaCad = new CadastroUsuario();
			
			String nomePlataforma = request.getParameter("nomePlataforma");

			JSONObject resposta = new JSONObject();

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			if (validaCad.ifExistsNomePlataformas(nomePlataforma) == true) {
				resposta.put("existe", "sim");
			} else {
				resposta.put("existe", "nao");
			}
			
			response.getWriter().print(resposta);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
		
	}

	private void validaRolesIfExist(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			CadastroUsuario validaCad = new CadastroUsuario();
			
			String nomeRoles = request.getParameter("nomeRoles");

			JSONObject resposta = new JSONObject();

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			if (validaCad.ifExistsNomeRoles(nomeRoles) == true) {
				resposta.put("existe", "sim");
			} else {
				resposta.put("existe", "nao");
			}
			
			response.getWriter().print(resposta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void validaJogosIfExist(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			
			CadastroUsuario validaCad = new CadastroUsuario();
			
			String nomeJogo = request.getParameter("nomeJogo");

			JSONObject resposta = new JSONObject();

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			if (validaCad.ifExistsNomeJogos(nomeJogo) == true) {
				resposta.put("existe", "sim");
			} else {
				resposta.put("existe", "nao");
			}
			
			response.getWriter().print(resposta);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
	}

	

	// private void validaJogos(HttpServletRequest request,
	// HttpServletResponse response) {
	//
	// CadastroUsuario validaCad = new CadastroUsuario();
	//
	// try {
	//
	// String email = request.getParameter("email");
	//
	// JSONObject resposta = new JSONObject();
	//
	// response.setContentType("application/json");
	// response.setCharacterEncoding("UTF-8");
	//
	// if (validaCad.ifExistsEmail(email) == true) {
	// resposta.put("existe", "sim");
	// } else {
	// resposta.put("existe", "nao");
	// }
	//
	// response.getWriter().print(resposta);
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	//
	// }
}
