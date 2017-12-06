package br.com.projetofinal.controle;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebFilter({"/usuario/*","/administrador/*"})
public class Filtro implements Filter {
	
//bloqueia dois diretórios, usuario e administrador
	
    public Filtro() {
        
    }

	 
	public void destroy() {
		 
	}
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	 
		  HttpServletRequest req= (HttpServletRequest) request;
		  HttpServletResponse resp= (HttpServletResponse) response;
		  HttpSession session= req.getSession(); //ativa  sessão

		     //se a sessão foi destruída (logout.jsp)
		    //se foi igual a vazio volta para o login.jsp
		  if (session.getAttribute("usuario")!=null){
			    //entra nas pastas
			  chain.doFilter(request, response);	  
		  }
		  else{
			  //deu logout volta ...
			  
			  resp.sendRedirect("../index.html");
		  }
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
