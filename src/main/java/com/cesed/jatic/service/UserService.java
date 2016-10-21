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

	public void salvar(User user) throws UserJaticException {
		this.validate(user);
		if (user.getId() == null) {
			userDAO.create(user);
		} else {
			userDAO.update(user);
		}
	}

	private void validate(User user) throws UserJaticException {
		if (user == null) {
			throw new UserJaticException("Usuário não pode ser nulo!");
		}

		if (user.getCpf() == null) {
			throw new UserJaticException("CPF é obrigatório!");
		} else {
			String cpf = user.getCpf();
			cpf = cpf.replace(".", "").replace("-", "").replace(" ", "");
			user.setCpf(cpf);
			if (cpf.length() < 11) {
				throw new UserJaticException("CPF deve ter 11 caracteres!");
			}
		}
	}

	public User pesquisarUsuarioPorCPF(String cpf) {
		cpf = cpf.replace(".", "").replace("-", "").replace(" ", "");
		return this.userDAO.buscarUserPorCPF(cpf);
	}
}
