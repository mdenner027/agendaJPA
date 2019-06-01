package br.com.agenda.max.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.max.bd.ContatoDAO;
import br.com.agenda.max.modelo.Contato;

public class GetContato implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Contato contato = new ContatoDAO().getContato(Integer.parseInt(id));
		request.setAttribute("contato", contato);
		return "/altera-contato.jsp";
	}

}
