package com.cesed.jatic.service;

import com.cesed.jatic.dao.UserDAO;
import com.cesed.jatic.dao.UserDAOImpl;
import com.cesed.jatic.entity.User;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAOImpl();
	}

	public User pesquisarUserPorId(Long id) {
		return this.userDAO.buscarUserPorId(id);
	}
}
