package com.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MailController {
	private String fromMail = "Zinetsu00@gmail.com";
	private String username = "Zinetsu00@gmail.com";
	private String password = "gftw pbao iulj rwtg";
	private String toMail;
	private String subject;
	private String massage;
	public String getFromMail() {
		return fromMail;
	}
	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
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
	public String getToMail() {
		return toMail;
	}
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public void send() {
		try {
			MailSender mailSender = new MailSender();
			mailSender.sendMail(fromMail, username, password, toMail, subject, massage);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
