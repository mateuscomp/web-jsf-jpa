package com.cesed.jatic.dao;

import javax.persistence.EntityManager;

import com.cesed.jatic.entity.Telefone;

public class TelefoneDAOImpl extends GenericDAO implements TelefoneDAO {

	public void create(Telefone telefone) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(telefone);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(Telefone telefone) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Telefone telRem = em.find(Telefone.class, telefone.getId());
		em.remove(telRem);
		em.getTransaction().commit();
		em.close();
	}

}
