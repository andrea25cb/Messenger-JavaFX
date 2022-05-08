package controller;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import database.Mensaje;
import database.MensajeriaBD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Login;
import view.Body;
import view.MenuUser;
import view.SendMessage;
import view.ViewMessages;

public class MenuUserController implements Initializable {

	private MenuUser vista;
	private MensajeriaBD modelo;
	private Stage primaryStage;
	private Button sendMessage;
	private Button viewMessage;
	private Button recievedMessage;
	private String email;
	private String pass;
	private Button back;
	private ArrayList<Mensaje> mensajes;
	private Login modeloLogin;

	// botón de enviar mensajes lleva a otro panel
	public MenuUserController(MenuUser vista, Login modeloLogin, MensajeriaBD modelo, Stage primaryStage,
			ArrayList<Mensaje> mensajes) {
		this.modelo = modelo;
		this.vista = vista;
		this.primaryStage = primaryStage;
		this.mensajes = mensajes;
		this.modeloLogin = modeloLogin;
		this.email = modeloLogin.getEmail();
		sendMessage = vista.getSendMessage();
		sendMessage.setOnAction(new Manejador());

		// botón de visualizar mis mensajes

		// viewMessage = vista.getViewMessage();
		// viewMessage.setOnAction(new Manejador2());

// boton mensajes recibidos:
		recievedMessage = vista.getRecievedMessage();
		recievedMessage.setOnAction(new Manejador3());

		// boton back:
		back = vista.getBack();
		back.setOnAction(new Manejador4());// necesito ayuda

	}

//SENDMESSAGES
	class Manejador implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			try {
				SendMessage body = new SendMessage();// vista
				MensajeriaBD mensajeriabd = new MensajeriaBD();
				Scene scene = new Scene(body, 500, 500);

				ArrayList<Mensaje> mensajes = mensajeriabd.getMensajes2(email);

				SendMessageController sendMessage = new SendMessageController(body, mensajeriabd, primaryStage, modeloLogin);

				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("SEND MESSAGES");
				primaryStage.setResizable(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// ver mensajes enviados ESTE NO
	class Manejador2 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			try {

				ViewMessages body = new ViewMessages();// vista
				MensajeriaBD mensajeriabd = new MensajeriaBD();

				ArrayList<Mensaje> mensajes = mensajeriabd.getMensajes2(email);

				int c = 1;
				int r = 5;
				for (int i = 0; i < mensajes.size(); i++) {
					Label labelMensaje = new Label(mensajes.get(i).getTexto());
					Label labelFrom = new Label(mensajes.get(i).getEmail1());
					body.add(labelFrom, c++, r);
					body.add(labelMensaje, c, r);
					r++;
					c = 1;

					labelMensaje.setFont(new Font("Lucida Sans Unicode", 15));
					labelMensaje.setTextFill(Color.PURPLE);

					labelFrom.setFont(new Font("Lucida Sans Unicode", 15));
					labelFrom.setTextFill(Color.PURPLE);
				}

				Scene scene = new Scene(body, 500, 400);
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("VIEW MESSAGES");
				primaryStage.setResizable(false);

				ViewMessagesController viewMessages = new ViewMessagesController(body, primaryStage, mensajes, modeloLogin);
				System.out.println(email);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// ver mensajes recibidos
	class Manejador3 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			try {

				ViewMessages body = new ViewMessages();// vista
				MensajeriaBD mensajeriabd = new MensajeriaBD();

				ArrayList<Mensaje> mensajes = mensajeriabd.getMensajes2(email);
				System.out.println(email);

				int c = 1;
				int r = 5;
				for (int i = 0; i < mensajes.size(); i++) {
					Label labelMensaje = new Label(mensajes.get(i).getTexto());
					Label labelFrom = new Label(mensajes.get(i).getEmail1());
					body.add(labelFrom, c++, r);
					body.add(labelMensaje, c, r);
					r++;
					c = 1;

					labelMensaje.setFont(new Font("Lucida Sans Unicode", 15));
					labelMensaje.setTextFill(Color.PURPLE);

					labelFrom.setFont(new Font("Lucida Sans Unicode", 15));
					labelFrom.setTextFill(Color.PURPLE);
				}

				Scene scene = new Scene(body, 500, 400);
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("VIEW MESSAGES");
				primaryStage.setResizable(false);

				ViewMessagesController viewMessages = new ViewMessagesController(body, primaryStage, mensajes, modeloLogin);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// botón para volver hacia atrás, al panel anterior
	class Manejador4 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			try {

				FileInputStream stream = new FileInputStream("images/fondomenu.jpg");
				Image image = new Image(stream);
				ImageView imageview = new ImageView(image);
				StackPane layout = new StackPane(imageview);

				GridPane root = new GridPane();
				Scene scene = new Scene(layout, 500, 390);

				Body vista = new Body();// vista
				Login modelo = new Login();
				Controlador login = new Controlador(vista, modelo, primaryStage);

				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("MESSENGER <3");
				primaryStage.setResizable(false);
				root.getChildren().add(vista);
				layout.getChildren().add(vista);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
