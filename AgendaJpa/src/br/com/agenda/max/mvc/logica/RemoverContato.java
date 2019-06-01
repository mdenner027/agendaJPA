package br.com.agenda.max.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.max.bd.ContatoDAO;

public class RemoverContato implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		ContatoDAO dao = new ContatoDAO();
		dao.removerContato(request.getParameter("id"));
		return "/controlador?logica=ListaContatos";
	}

}
