package br.com.agenda.max.bd;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.agenda.max.modelo.Contato;

public class TestaBd {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Max");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setEndereco("rua da mariola");
		contato.setEmail("maxdenner@gmail.com");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("agenda-pu");
		EntityManager manager = fabrica.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		manager.close();
		fabrica.close();
	}
}
