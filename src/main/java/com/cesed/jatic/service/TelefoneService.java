package com.cesed.jatic.service;

import com.cesed.jatic.dao.TelefoneDAO;
import com.cesed.jatic.dao.TelefoneDAOImpl;
import com.cesed.jatic.entity.Telefone;

public class TelefoneService {

	private TelefoneDAO telefoneDAO;

	public TelefoneService() {
		this.telefoneDAO = new TelefoneDAOImpl();
	}

	public void salvar(Telefone telefone) {
		String numero = telefone.getNumero().replace("-", "").replace(" ", "");
		telefone.setNumero(numero);

		this.telefoneDAO.create(telefone);
	}

}
