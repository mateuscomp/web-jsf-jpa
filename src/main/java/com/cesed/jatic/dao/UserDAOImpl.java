package com.cesed.jatic.dao;

import javax.persistence.EntityManager;

import com.cesed.jatic.entity.User;

public class UserDAOImpl extends GenericDAO implements UserDAO {

	public User buscarUserPorId(Long id) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			User user = (User) factory.createEntityManager().createQuery("SELECT u FROM User u WHERE u.id =:id")
					.setParameter("id", id).getSingleResult();
			em.getTransaction().commit();
			em.close();

			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public void create(User user) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public void update(User user) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}
}
