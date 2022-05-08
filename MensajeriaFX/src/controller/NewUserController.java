package controller;

import java.io.FileInputStream;
import database.MensajeriaBD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Login;
import view.Body;
import view.NewUser;

public class NewUserController {

	private NewUser vista;
	private MensajeriaBD modelo;
	private Stage primaryStage;
	private Login login;

	private Button createAccount;
	private Button back;// para volver al panel de login

	public NewUserController(NewUser vista, MensajeriaBD modelo, Stage primaryStage, Login login) {
		this.vista = vista;
		this.modelo = modelo;
		this.primaryStage = primaryStage;
		this.login = login;

		createAccount = vista.getCreate();
		createAccount.setOnAction(new Manejador());

		back = vista.getBack();
		back.setOnAction(new Manejador2());// necesito ayuda
	}

// creamos la cuenta:
	class Manejador implements EventHandler<ActionEvent> {
		public void handle(ActionEvent arg0) {
			String email = vista.getEmail().getText();
			login.setEmail(email);
			String pass = vista.getPass().getText();
			login.setPass(pass);

			String a = "";

			if (a.equals(email) || a.equals(pass)) {
				vista.getEmpty().show();
			} else {
				try {
					if (login.isNotUser(email, pass) == true) {
						modelo.addUser(email, pass);
						vista.getWelcome().show();
					} else {
						vista.getNotwelcome().show();// la cuenta ya existe
					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		}
	}

	// botón para volver hacia atrás, al panel anterior
	class Manejador2 implements EventHandler<ActionEvent> {
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

				// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle("MESSENGER <3");
				primaryStage.setResizable(false);
				root.getChildren().add(vista);
				layout.getChildren().add(vista);

				// Music music = new Music();
				// music.music("music/music.mp3");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
