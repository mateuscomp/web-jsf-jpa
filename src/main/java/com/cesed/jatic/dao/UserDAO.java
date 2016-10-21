package com.cesed.jatic.dao;

import com.cesed.jatic.entity.User;

public interface UserDAO {

	User buscarUserPorId(Long id);

	void create(User user);

	void update(User user);

	User buscarUserPorCPF(String cpf);
}
