package com.cesed.jatic.managedbean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloWorldBean {

	private String sayHello;

	public HelloWorldBean() {
		this.sayHello = "Hello World!!!";
	}

	public String getSayHello() {
		return sayHello;
	}

	public void setSayHello(String sayHello) {
		this.sayHello = sayHello;
	}

}
