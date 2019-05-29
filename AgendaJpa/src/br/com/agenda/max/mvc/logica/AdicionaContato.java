package br.com.agenda.max.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.max.bd.ContatoDAO;
import br.com.agenda.max.modelo.Contato;


public class AdicionaContato implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String nome = "";
		String endereco = "";
		String email = "";
		String dataTexto = "";
		try {
			nome = request.getParameter("nome");
			endereco = request.getParameter("endereco");
			email = request.getParameter("email");
			dataTexto = request.getParameter("dataNascimento");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		Calendar dataNascimento = Calendar.getInstance();

		try {
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataTexto);
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Contato contato = new Contato();
		contato.setDataNascimento(dataNascimento);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setNome(nome);

		ContatoDAO dao = new ContatoDAO();
		dao.adicionaContato(contato);
		return "/index.jsp";
	}

}
