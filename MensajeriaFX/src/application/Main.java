package application;

import javafx.stage.Stage;
import model.Login;
import model.Music;
import view.Body;
import java.io.FileInputStream;
import controller.Controlador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FileInputStream stream = new FileInputStream("images/fondo3.jfif");
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

			Music music = new Music();
			music.music("music/music.mp3");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
