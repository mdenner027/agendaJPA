package br.com.agenda.max.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.agenda.max.modelo.Contato;

public class ContatoDAO {

	public ContatoDAO() {
		
	}

	public void adicionaContato(Contato contato) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("agenda-pu");
		EntityManager manager = fabrica.createEntityManager();
		manager.persist(contato);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		fabrica.close();
	}
}
