package view;

import java.io.FileInputStream;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class NewUser extends GridPane {

	private Label title;
	private Label emailLabel;
	private Label passLabel;

	private TextField email;
	private TextField pass;

	private Button create;// botón del menú de creación
	private Button back;// botón para volver atras

	Alert welcome = new Alert(AlertType.INFORMATION, "SUCCESSFUL CREATION");
	Alert notwelcome = new Alert(AlertType.INFORMATION, "THIS ACCOUNT ALREADY EXISTS");
	Alert empty = new Alert(AlertType.INFORMATION, "YOU MUST WRITE THE DATA");

	public NewUser() throws Exception {

		this.setVgap(15);
		this.setHgap(15);

		this.setAlignment(Pos.BASELINE_CENTER);

		this.title = new Label("CREATE NEW ACCOUNT");
		this.emailLabel = new Label("Create email:");
		this.passLabel = new Label("Create password:");

		this.email = new TextField();
		this.pass = new TextField();

		this.create = new Button("CREATE");
		this.back = new Button("BACK");

		title.setFont(new Font("Impact", 40));
		title.setTextFill(Color.PURPLE);

		this.add(this.title, 1, 1);
		this.add(this.emailLabel, 1, 2);
		this.add(this.email, 1, 3);
		this.add(this.passLabel, 1, 4);
		this.add(this.pass, 1, 5);
		this.add(this.back, 1, 8);
		this.add(this.create, 1, 7);

		// this.add(this.result, 1, 10);

		FileInputStream f = new FileInputStream("images/fondomenu.jpg");
		Image bgImage = new Image(f);
		BackgroundImage bg = new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(800, 500, false, false, false, false));
		this.setBackground(new Background(bg));

		emailLabel.setFont(new Font("Lucida Sans Unicode", 15));
		emailLabel.setTextFill(Color.PURPLE);
		passLabel.setFont(new Font("Lucida Sans Unicode", 15));
		passLabel.setTextFill(Color.PURPLE);
		create.setStyle(
				"-fx-border-color: CADETBLUE; -fx-text-fill: PURPLE; -fx-border- width: 5px; -fx-background-color: white; -fx-font-size: 20px;");
		back.setStyle(
				"-fx-border-color: CADETBLUE; -fx-text-fill: PURPLE; -fx-border- width: 5px; -fx-background-color: white; -fx-font-size: 20px;");

	}

	public Button getBack() {
		return back;
	}

	public void setBack(Button back) {
		this.back = back;
	}

	public Button getCreate() {
		return create;
	}

	public void setCreate(Button create) {
		this.create = create;
	}

	public Alert getWelcome() {
		return welcome;
	}

	public void setWelcome(Alert welcome) {
		this.welcome = welcome;
	}

	public Label getEmailLabel() {
		return emailLabel;
	}

	public void setEmailLabel(Label emailLabel) {
		this.emailLabel = emailLabel;
	}

	public Label getPassLabel() {
		return passLabel;
	}

	public void setPassLabel(Label passLabel) {
		this.passLabel = passLabel;
	}

	public TextField getEmail() {
		return email;
	}

	public void setEmail(TextField email) {
		this.email = email;
	}

	public TextField getPass() {
		return pass;
	}

	public void setPass(TextField pass) {
		this.pass = pass;
	}

	public Alert getNotwelcome() {
		return notwelcome;
	}

	public void setNotwelcome(Alert notwelcome) {
		this.notwelcome = notwelcome;
	}

	public Alert getEmpty() {
		return empty;
	}

	public void setEmpty(Alert empty) {
		this.empty = empty;
	}

}
