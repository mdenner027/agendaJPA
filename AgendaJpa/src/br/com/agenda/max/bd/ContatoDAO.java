package br.com.agenda.max.bd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.agenda.max.modelo.Contato;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

public class ContatoDAO {
	private EntityManagerFactory fabrica;
	private EntityManager manager;

	public ContatoDAO() {
		fabrica = Persistence.createEntityManagerFactory("agenda-pu");
		manager = fabrica.createEntityManager();
	}

	public void adicionaContato(Contato contato) {
		manager.persist(contato);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		fabrica.close();
	}

	public List<Contato> listaContatos() {
		Query query = manager.createQuery("Select c from contatos c");
		List<Contato> contatos = query.getResultList();
		manager.close();
		fabrica.close();
		return contatos;
	}

	public Contato getContato(int id) {
		Contato contato = manager.find(Contato.class, id);
		return contato;
	}

	public void removerContato(String id) {
		Contato contato = getContato(Integer.parseInt(id));
		manager.getTransaction().begin();
		manager.remove(contato);
		manager.getTransaction().commit();
		manager.close();
		fabrica.close();
	}
	
	public void atualizarContato(Contato contato) {
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		manager.close();
		fabrica.close();
	}
}
