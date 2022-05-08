package model;

import java.sql.SQLException;

import database.MensajeriaBD;

public class Login {

	private String email;
	private String pass;
	private MensajeriaBD db;

	public Login(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}

	public boolean isNotUser(String email, String pass) throws SQLException {
		db = new MensajeriaBD();
		db.conectar();
		if (db.getUser(email, pass) == null)
			return true;
		return false;
	}

	public Login() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
