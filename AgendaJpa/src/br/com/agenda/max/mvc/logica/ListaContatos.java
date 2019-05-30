package br.com.agenda.max.mvc.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.max.bd.ContatoDAO;
import br.com.agenda.max.modelo.Contato;

public class ListaContatos implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		List<Contato> contatos = new ArrayList<>();
		contatos = new ContatoDAO().listaContatos();
		request.setAttribute("contatos", contatos);		
		return "/lista-contatos.jsp";
	}

}
