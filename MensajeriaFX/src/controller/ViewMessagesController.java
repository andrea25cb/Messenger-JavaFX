
package controller;

import java.util.ArrayList;

import database.Mensaje;
import database.MensajeriaBD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Login;
import view.MenuUser;
import view.ViewMessages;

public class ViewMessagesController {
	private ViewMessages vista;
	private MensajeriaBD mensajeriabd;
	private Button back;// para volver al panel de login
	private Stage primaryStage;
	private ArrayList<Mensaje> mensajes;

	private Login login;

	public ViewMessagesController(ViewMessages vista, Stage primaryStage, ArrayList<Mensaje> mensajes, Login login) {
		this.vista = vista;
		this.mensajes = mensajes;
		this.primaryStage = primaryStage;
		this.mensajes = mensajes;
		this.login=login;
		
		back = vista.getBack();
		back.setOnAction(new Manejador());// necesito ayuda
	}

	// botón para volver hacia atrás, al panel de MenuUser
	class Manejador implements EventHandler<ActionEvent> {

		public void handle(ActionEvent arg0) {

			try {
				MenuUser body = new MenuUser();// vista
				MensajeriaBD mensajeriabd = new MensajeriaBD();
				Scene scene = new Scene(body, 500, 400);

				String email = login.getEmail();
				ArrayList<Mensaje> mensajes = mensajeriabd.getMensajes2(email);
				System.out.println(email);// me da null al volver atrás
				MenuUserController menuUser = new MenuUserController(body, login, mensajeriabd, primaryStage,
						mensajes);

				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("MENU USER");
				primaryStage.setResizable(false);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
