package com.cesed.jatic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cesed.jatic.entity.User;

public class UserDAOImpl extends GenericDAO implements UserDAO {

	public User buscarUserPorId(Long id) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			User user = (User) em.createQuery("SELECT u FROM User u WHERE u.id =:id").setParameter("id", id)
					.getSingleResult();
			em.getTransaction().commit();
			em.close();

			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public List<User> buscarUsuariosPorNomeECPF(String name, String cpf) {
		String query = "SELECT u FROM User u";

		boolean hasWhere = false;
		boolean hasName = name != null && !name.isEmpty();
		boolean hasCPF = cpf != null && !cpf.isEmpty();
		if (hasName) {
			query += " WHERE u.name LIKE :name";
			hasWhere = true;
		}
		if (hasCPF) {
			if (hasWhere) {
				query += " AND u.cpf = :cpf";
			} else {
				query += " WHERE u.cpf = :cpf";
			}
		}

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> q = em.createQuery(query, User.class);
		if (hasName) {
			q.setParameter("name", "%" + name + "%");
		}
		if (hasCPF) {
			q.setParameter("cpf", cpf);
		}

		return q.getResultList();
	}

	public User buscarUserPorCPF(String cpf) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			User user = (User) factory.createEntityManager().createQuery("SELECT u FROM User u WHERE u.cpf =:cpf")
					.setParameter("cpf", cpf).getSingleResult();
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
