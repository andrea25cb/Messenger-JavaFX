package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MensajeriaBD extends Conexion {

	private Statement stm = null; // da la orden de comunicarse con la base de datos//se pone en cada m�todo
									// para
									// que se comunique
	Usuario usuario;// objetos
	Mensaje mensaje;

	// constructor:
	public MensajeriaBD() throws SQLException {
		this.conectar();
	}

	// OPERACIONES ADMIN:
	// para crear un usuario
	public boolean addUser(String email, String pass) throws Exception {
		boolean ok = false;
		String valores = "'" + email + "','" + pass + "'";
		// insert into clientes
		String sql = "insert into usuario values(" + valores + ")";

		stm = this.con.createStatement();
		ok = stm.execute(sql);
		return ok;
	}
	/*
	 * // para mostrar todos los usuarios public ArrayList<Usuario> getAllUsers()
	 * throws Exception { ArrayList<Usuario> list = new ArrayList<Usuario>(); //
	 * devuelvo esto
	 * 
	 * String sql = "SELECT * FROM usuario";// todos los datos de todos los clientes
	 * stm = this.con.createStatement(); ResultSet rs = stm.executeQuery(sql); while
	 * (rs.next()) {// el next coge la siguiente tupla String email =
	 * rs.getString(1); String pass = rs.getString(2); list.add(new Usuario(email,
	 * pass)); } return list; }
	 */

	// para eliminar una cuenta con el email
	public boolean dropUser(String email) throws Exception {
		boolean drop = false;
		String valores = "'" + email + "'";
		String sql = "DELETE FROM usuario WHERE email =" + valores;
		stm = this.con.createStatement();
		stm.execute(sql);
		return drop;
	}

	// mostrar todos los mensajes enviados del email que inicie
	public ArrayList<Mensaje> getMensajes(String email1) throws Exception {
		ArrayList<Mensaje> list = new ArrayList<Mensaje>();
		String sql = "SELECT * FROM mensaje WHERE email1='" + email1 + "'";
		stm = this.con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			String texto = rs.getString(1);
			String email11 = rs.getString(2);
			String email12 = rs.getString(3);
			list.add(new Mensaje(texto, email11, email12));
		}
		return list;
	}
	// mostrar todos los mensajes recibidos del email que inicie
		public ArrayList<Mensaje> getMensajes2(String email2) throws Exception {
			ArrayList<Mensaje> list = new ArrayList<Mensaje>();
			String sql = "SELECT * FROM mensaje WHERE email2='" + email2 + "'";
			stm = this.con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String texto = rs.getString(1);
				String email11 = rs.getString(2);
				String email12 = rs.getString(3);
				list.add(new Mensaje(texto, email11, email12));
			}
			return list;
		}

	// para que el usuario entre con email y su contraseña
	public Usuario getUser(String email, String pass) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE email ='" + email + "' and pass= '" + pass + "'";
		stm = this.con.createStatement(); //
		ResultSet rs = stm.executeQuery(sql);
		if (rs.next()) {
			String email1 = rs.getString(1);
			String pass1 = rs.getString(2);
			return new Usuario(email1, pass1);
		}
		return null;
	}

	// para obtener los datos del usuario
	public Usuario getDatos(String email) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE email ='" + email + "'";
		stm = this.con.createStatement(); //
		ResultSet rs = stm.executeQuery(sql);
		if (rs.next()) {
			String emaill = rs.getString(1);
			String pass1 = rs.getString(2);
			return new Usuario(emaill, pass1);
		}
		return null;
	}

//para que el usuario modifique mensajes
	/*
	 * public boolean updateMensaje(String email1, String email2) throws
	 * SQLException { String values = "'" + mensaje.getTexto() + "'"; String sql =
	 * "UPDATE mensaje SET texto=" + values + "WHERE email1='" + mensaje.getEmail1()
	 * + "' AND email2='" + mensaje.getEmail2() + "'"; stm =
	 * this.con.createStatement(); return stm.execute(sql); }
	 */

	// para que el usuario envie mensajes
	public boolean enviarMensaje(String texto, String email1, String email2) throws SQLException {
		String valores = "'" + texto + "','" + email1 + "','" + email2 + "'";
		String sql = "INSERT INTO mensaje values(" + valores + ")";

		stm = this.con.createStatement();
		return stm.execute(sql);

	}

}
