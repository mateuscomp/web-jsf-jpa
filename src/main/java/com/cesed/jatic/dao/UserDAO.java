package com.cesed.jatic.dao;

import java.util.List;

import com.cesed.jatic.entity.User;

public interface UserDAO {

	void create(User user);

	void update(User user);

	User buscarUserPorId(Long id);

	User buscarUserPorCPF(String cpf);

	List<User> buscarUsuariosPorNomeECPF(String name, String cpf);

}
