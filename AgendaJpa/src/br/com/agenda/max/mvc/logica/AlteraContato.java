package br.com.agenda.max.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.max.bd.ContatoDAO;
import br.com.agenda.max.modelo.Contato;

public class AlteraContato implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = Calendar.getInstance();
		try {
			java.util.Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataEmTexto);
			dataNascimento.setTime(data);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		Contato contato = new Contato();
		contato.setId(Integer.parseInt(id));
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setNome(nome);
		contato.setDataNascimento(dataNascimento);
		ContatoDAO dao = new ContatoDAO();
		dao.atualizarContato(contato);
		return "controlador?logica=ListaContatos";
	}

}
