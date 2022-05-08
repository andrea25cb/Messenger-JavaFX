package controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Mensaje;
import database.MensajeriaBD;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Login;
import view.Body;
import view.IntroPane;
import view.MenuUser;
import view.NewUser;

public class Controlador {

	private Body vista;
	private Login modelo;
	private Button enter;
	private Stage primaryStage;
	private Button newAccount;


	public Controlador(Body vista2, Login modelo3, Stage primaryStage) {
		this.vista = vista2;
		this.modelo = modelo3;
		this.primaryStage = primaryStage;

		enter = vista2.getLoginButton();
		enter.setOnAction(new Manejador());

		newAccount = vista.getNewAccount();
		newAccount.setOnAction(new Manejador2());

	}

	class Manejador implements EventHandler<ActionEvent> {

		public void handle(ActionEvent arg0) {

			String email = vista.getEmail().getText();
			modelo.setEmail(email);

			String pass = vista.getPass().getText();
			modelo.setPass(pass);
			String a = "";

			if (a.equals(email) || a.equals(pass)) {
				vista.getEmpty().show();
			} else {
			try {
				if (modelo.isNotUser(email, pass) == false) {
					IntroPane intro = new IntroPane();

					Scene scene = new Scene(intro, 800, 450);

					primaryStage.setScene(scene);
					primaryStage.setTitle("MENU USER");
					primaryStage.show();
					primaryStage.setResizable(false);

					delay(5500, () -> {
						try {
							vista.getWelcome().show();

							MenuUser body = new MenuUser();// vista
							Scene scene2 = new Scene(body, 500, 390);
							MensajeriaBD mensajeriabd = new MensajeriaBD();
							
							ArrayList<Mensaje> mensajes = mensajeriabd.getMensajes2(email);
							System.out.println(email);

							primaryStage.setScene(scene2);

							MenuUserController menuUser = new MenuUserController(body, modelo, mensajeriabd,
									primaryStage, mensajes);

						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
				} else {
					vista.getNotwelcome().show();
				}
			}
			 catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
}
	}

	class Manejador2 implements EventHandler<ActionEvent> {
//lleva al menu que crea una nueva cuenta

		@Override
		public void handle(ActionEvent arg0) {
			try {

				NewUser body = new NewUser();// vista
				MensajeriaBD mensajeriabd = new MensajeriaBD();
				Login login = new Login();
				Scene scene = new Scene(body, 500, 390);

				NewUserController newUser = new NewUserController(body, mensajeriabd, primaryStage, login);

				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("CREATE NEW ACCOUNT");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void delay(long millis, Runnable continuation) {
		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(millis);
				} catch (InterruptedException e) {
				}
				return null;
			}
		};
		sleeper.setOnSucceeded(event -> continuation.run());
		new Thread(sleeper).start();
	}
}
