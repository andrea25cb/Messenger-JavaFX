package database;

import java.sql.Date;
import java.sql.SQLException;

public class Mensaje {

	public int num_mensaje; // id_mensaje // auto_increment
	private String email1; // (to)
	private String email2; // (from)
	private String texto;

	public Mensaje() throws SQLException {
	}

	public Mensaje(int num_mensaje, String texto, String email1, String email2) throws SQLException {
		this.num_mensaje = num_mensaje;
		this.texto = texto;
		this.email1 = email1;
		this.email2 = email2;

	}

	// enviar mensaje
	public Mensaje(String texto, String email1, String email2) throws SQLException {
		this.texto = texto;
		this.email1 = email1;
		this.email2 = email2;

	}
//ver mensajes
	public Mensaje(String texto, String email1) {
		this.texto = texto;
		this.email1 = email1;
	}

	public int getNum_mensaje() {
		return num_mensaje;
	}

	public void setNum_mensaje(int num_mensaje) {
		this.num_mensaje = num_mensaje;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String toString() {
		return "Mensaje: [ Num_men: "+num_mensaje+" texto: " + texto + " email1: "+ email1+ " email2: "+ email2 +"]";
		
	}
}
