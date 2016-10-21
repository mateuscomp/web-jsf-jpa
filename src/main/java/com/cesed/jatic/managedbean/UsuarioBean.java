package com.cesed.jatic.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cesed.jatic.entity.PerfilEnum;
import com.cesed.jatic.entity.User;
import com.cesed.jatic.service.UserService;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private User usuario;
	private int codigoDeArea;
	private String numero;
	private String operadora;

	private UserService userService;

	public UsuarioBean() {
		this.usuario = new User();
		this.userService = new UserService();
	}

	public void salvar() {
		try {
			this.userService.salvar(usuario);
			this.usuario = new User();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário salvo com sucesso!", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public void validarCPF() {
		User usuario = this.userService.pesquisarUsuarioPorCPF(this.usuario.getCpf());
		if (usuario != null) {
			this.usuario.setCpf("");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Já existe usuário cadastrado com o mesmo CPF", ""));
		}
	}

	public List<PerfilEnum> getPerfis() {
		List<PerfilEnum> perfis = new ArrayList<PerfilEnum>();
		for (int i = 0; i < PerfilEnum.values().length; i++) {
			perfis.add(PerfilEnum.values()[i]);
		}
		return perfis;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public int getCodigoDeArea() {
		return codigoDeArea;
	}

	public void setCodigoDeArea(int codigoDeArea) {
		this.codigoDeArea = codigoDeArea;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
}
