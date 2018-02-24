package com.yanghao.bean;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements Serializable,HttpSessionBindingListener{
	
	private static final long serialVersionUID = 1L;
	public String username;
	public String password;
	public String description;
	
	
	
	public User() {
		
	}
	
	public User(String username, String password, String description) {
		super();
		this.username = username;
		this.password = password;
		this.description = description;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", description=" + description + "]";
	}

	
	@Override
	public void valueBound(HttpSessionBindingEvent hsbe) {
		System.out.println("绑定了Session");
		ServletContext servletContext = hsbe.getSession().getServletContext();
		int count = (int)servletContext.getAttribute("loginUsers");
		servletContext.setAttribute("loginUsers", ++count);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent hsbe) {
		System.out.println("解绑了Session");
		ServletContext servletContext = hsbe.getSession().getServletContext();
		int	count = (int)servletContext.getAttribute("loginUsers");
		servletContext.setAttribute("loginUsers", --count);
		
	}
}
