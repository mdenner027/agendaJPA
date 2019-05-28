package br.com.agenda.max.bd;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaBd {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("agenda-pu");
		fabrica.close();
	}
}
