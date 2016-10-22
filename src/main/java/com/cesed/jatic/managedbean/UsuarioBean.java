package com.cesed.jatic.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.cesed.jatic.entity.PerfilEnum;
import com.cesed.jatic.entity.Telefone;
import com.cesed.jatic.entity.User;
import com.cesed.jatic.service.TelefoneService;
import com.cesed.jatic.service.UserService;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private User usuario;
	private String codigoDeArea;
	private String numero;
	private String operadora;

	private UserService userService;
	private TelefoneService telefoneService;

	public UsuarioBean() {
		this.usuario = new User();
		this.userService = new UserService();
		this.telefoneService = new TelefoneService();
	}

	public void salvar() {
		try {
			this.userService.salvar(usuario);
			this.usuario = new User();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio salvo com sucesso!", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public void adicionarTelefone() {
		Telefone telefone = new Telefone();
		telefone.setOperadora(this.operadora);
		this.codigoDeArea = this.codigoDeArea.replace("(", "").replace(")", "").replace(" ", "");
		telefone.setCodigoDeArea(Integer.parseInt(this.codigoDeArea));
		telefone.setNumero(this.numero);

		this.telefoneService.salvar(telefone);
		this.usuario.getTelefones().add(telefone);

		this.operadora = "";
		this.codigoDeArea = "";
		this.numero = "";

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Telefone adicionado com sucesso!", ""));
	}

	public void validarCPF() {
		User usuario = this.userService.pesquisarUsuarioPorCPF(this.usuario.getCpf());
		if (usuario != null) {
			this.usuario.setCpf("");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "J� existe usu�rio cadastrado com o mesmo CPF!", ""));
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

	public String getCodigoDeArea() {
		return codigoDeArea;
	}

	public void setCodigoDeArea(String codigoDeArea) {
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
