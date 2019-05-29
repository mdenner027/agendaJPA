package br.com.agenda.max.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.max.mvc.logica.Logica;

@WebServlet("/controlador")
public class Controller extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nomeClasse = "br.com.agenda.max.mvc.logica." + request.getParameter("logica");

		try {
			Class<?> classe = Class.forName(nomeClasse);
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
