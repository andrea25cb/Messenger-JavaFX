
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
import view.SendMessage;

public class SendMessageController {

	private SendMessage vista;
	private Button sendMessage;
	private MensajeriaBD mensajeriabd;
	private Stage primaryStage;
	private Button back;// para volver al panel de login
	private Login log;

	public SendMessageController(SendMessage vista, MensajeriaBD mensajeriabd, Stage primaryStage, Login login) {
		this.vista = vista;
		this.mensajeriabd = mensajeriabd;
		this.primaryStage = primaryStage;
		this.log=login;
		
		sendMessage = vista.getSendMessage();
		sendMessage.setOnAction(new Manejador());

		back = vista.getBack();
		back.setOnAction(new Manejador2());

	}

//enviamos el mensaje
	class Manejador implements EventHandler<ActionEvent> {

		public void handle(ActionEvent arg0) {
//Cannot add or update a child row: a foreign key constraint fails (`mensajeriabd`.`mensaje`, CONSTRAINT `mensaje_ibfk_1` FOREIGN KEY (`email1`) REFERENCES `usuario` (`email`))

			try {
				String email1 = vista.getEmail1().getText();
				String email2 = vista.getEmail2().getText();
				String text = vista.getWriteText().getText();

				mensajeriabd.enviarMensaje(text, email1, email2);
				vista.getMsent().show();

				if (email1 == null || email2 == null)
					vista.getMnotsent().show();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	// botón para volver hacia atrás, al panel de MenuUser
	class Manejador2 implements EventHandler<ActionEvent> {
		public void handle(ActionEvent arg0) {
			try {
				Login modeloLogin = new Login();
				MenuUser body = new MenuUser();// vista
				MensajeriaBD mensajeriabd = new MensajeriaBD();
				Scene scene = new Scene(body, 500, 400);

				String email = log.getEmail();
				ArrayList<Mensaje> mensajes = mensajeriabd.getMensajes2(email);

				MenuUserController menuUser = new MenuUserController(body, modeloLogin, mensajeriabd, primaryStage,
						mensajes);
				System.out.println(email);//me da null
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
