package view;

import java.io.FileInputStream;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class MenuUser extends GridPane {

	private Label title;
	private Button sendMessage;
	//private Button viewMessage;
	private Button recievedMessage;
	// private Button deleteAccount;
	private Button back;// botón para volver atras

	private Label text2;

	Alert deleteAlert = new Alert(AlertType.INFORMATION, "ACCOUNT DELETED");
	Alert errorAlert = new Alert(AlertType.INFORMATION, "ERROR");

	public MenuUser() throws Exception {

		this.setVgap(10);
		this.setHgap(10);

		this.setAlignment(Pos.BASELINE_CENTER);

		this.title = new Label("WELCOME USER");

		this.text2 = new Label("What do you want to do?:");
		this.sendMessage = new Button("Send a message");
		//this.viewMessage = new Button("Sent messages");
		this.recievedMessage = new Button("Recieved messages");

		this.back = new Button("BACK");

		title.setFont(new Font("Impact", 40));
		title.setTextFill(Color.PURPLE);

		this.add(this.title, 1, 1);

		this.add(this.text2, 1, 4);

		this.add(this.sendMessage, 1, 5);
	//	this.add(this.viewMessage, 1, 6);
		this.add(this.recievedMessage, 1, 7);
		this.add(this.back, 1, 9);

		FileInputStream f = new FileInputStream("images/fondomenu.jpg");
		Image bgImage = new Image(f);
		BackgroundImage bg = new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(800, 500, false, false, false, false));
		this.setBackground(new Background(bg));

		text2.setFont(new Font("Lucida Sans Unicode", 15));
		text2.setTextFill(Color.PURPLE);

		sendMessage.setStyle(
				"-fx-border-color: CADETBLUE; -fx-text-fill: PURPLE; -fx-border- width: 5px; -fx-background-color: white; -fx-font-size: 20px;");
	//	viewMessage.setStyle(
		//		"-fx-border-color: CADETBLUE; -fx-text-fill: PURPLE; -fx-border- width: 5px; -fx-background-color: white; -fx-font-size: 20px;");
		recievedMessage.setStyle(
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

	public Alert getErrorAlert() {
		return errorAlert;
	}

	public void setErrorAlert(Alert errorAlert) {
		this.errorAlert = errorAlert;
	}

	public Button getSendMessage() {
		return sendMessage;
	}

	public void setSendMessage(Button sendMessage) {
		this.sendMessage = sendMessage;
	}

	/*public Button getViewMessage() {
		return viewMessage;
	}

	public void setViewMessage(Button viewMessage) {
		this.viewMessage = viewMessage;
	}*/

	public Button getRecievedMessage() {
		return recievedMessage;
	}

	public void setRecievedMessage(Button recievedMessage) {
		this.recievedMessage = recievedMessage;
	}

	public Alert getDeleteAlert() {
		return deleteAlert;
	}

	public void setDeleteAlert(Alert deleteAlert) {
		this.deleteAlert = deleteAlert;
	}

}
