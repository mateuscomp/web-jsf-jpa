package com.cesed.jatic.managedbean;

import javax.faces.bean.ManagedBean;

import com.cesed.jatic.entity.User;
import com.cesed.jatic.service.UserService;

@ManagedBean
public class HelloWorldBean {

	private UserService userService;

	public HelloWorldBean() {
		this.userService = new UserService();
	}

	public String getHello() {
		String hello = "Hello World";
		User user = this.userService.pesquisarUserPorId(1L);
		if (user != null) {
			hello += " " + user.getName();
		}
		return hello;
	}
}
