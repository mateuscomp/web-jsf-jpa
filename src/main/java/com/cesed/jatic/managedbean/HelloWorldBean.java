package com.cesed.jatic.managedbean;

import javax.faces.bean.ManagedBean;

import com.cesed.jatic.service.UserService;

@ManagedBean
public class HelloWorldBean {

	private UserService userService;

	public HelloWorldBean() {
		this.userService = new UserService();
	}

	public String getHello() {
		return "Hello World " + this.userService.pesquisarUserPorId(2L).getName();
	}
}
