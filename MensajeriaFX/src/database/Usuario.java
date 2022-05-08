package database;

public class Usuario {

	private String name;
	private String dni;
	private String email;
	private String pass;

	/*
	 * public Usuario(String dni, String name, String email, String pass) {
	 * this.name = name; this.dni = dni; this.email = email; this.pass=pass; }
	 */

//para que el usuario inicie sesion
	public Usuario(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}

//para verificar el login del usuario	
	public boolean equals(String email, String pass) {
		if (email.equals(this.email) && pass.equals(this.pass))
			;
		return true;
	}

	public String toString() {
		return "[DNI=" + dni + " name= " + name + ", email= " + email + " , Pass= " + pass + "]\n ";
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
