package com.cesed.jatic.dao;

import com.cesed.jatic.entity.User;

public class UserDAOImpl extends GenericDAO implements UserDAO {

	public User buscarUserPorId(Long id) {
		try {
			return (User) super.em.createQuery("SELECT u FROM User u WHERE u.id =:id").setParameter("id", id)
					.getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}
}
