
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

public class SendMessage extends GridPane {

	private Label title;
	private Label email1Label;
	private Label email2Label;
	private Label writeTextLabel;

	private TextField email1;// el que lo envia
	private TextField email2;// el que lo recibe
	private TextField writeText;

	private Button sendMessage;// botón que envia el mensaje
	private Button back;// botón para volver atras

	Alert msent = new Alert(AlertType.INFORMATION, "YOUR MESSAGE HAS BEEN SENT");
	Alert mnotsent = new Alert(AlertType.INFORMATION, "PLEASE TRY AGAIN");

	public SendMessage() throws Exception {

		this.setVgap(15);
		this.setHgap(15);

		this.setAlignment(Pos.BASELINE_CENTER);

		this.title = new Label("SEND MESSAGES");
		this.email1Label = new Label("Your email:");
		this.email2Label = new Label("To:");
		this.writeTextLabel = new Label("Write your message:");

		this.email1 = new TextField();
		this.email2 = new TextField();
		this.writeText = new TextField();

		sendMessage = new Button("SEND MESSAGE");
		back = new Button("BACK");

		title.setFont(new Font("Impact", 40));
		title.setTextFill(Color.PURPLE);
		
		writeText.setPrefWidth(80);

		this.add(this.title, 1, 1);
		this.add(this.email1Label, 1, 2);
		this.add(this.email1, 1, 3);
		this.add(this.email2Label, 1, 4);
		this.add(this.email2, 1, 5);
		this.add(this.writeTextLabel, 1, 6);
		this.add(this.writeText, 1, 7);
		this.add(this.back, 1, 9);
		this.add(this.sendMessage, 1, 8);

		email1Label.setFont(new Font("Lucida Sans Unicode", 15));
		email1Label.setTextFill(Color.PURPLE);
		email2Label.setFont(new Font("Lucida Sans Unicode", 15));
		email2Label.setTextFill(Color.PURPLE);
		writeTextLabel.setFont(new Font("Lucida Sans Unicode", 15));
		writeTextLabel.setTextFill(Color.PURPLE);

		sendMessage.setStyle("-fx-border-color: CADETBLUE; -fx-text-fill: PURPLE; -fx-border- width: 5px; -fx-background-color: white; -fx-font-size: 20px;");
		back.setStyle("-fx-border-color: CADETBLUE; -fx-text-fill: PURPLE; -fx-border- width: 5px; -fx-background-color: white; -fx-font-size: 20px;");

		FileInputStream f = new FileInputStream("images/fondomenu.jpg");
		Image bgImage = new Image(f);
		BackgroundImage bg = new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(800, 500, false, false, false, false));
		this.setBackground(new Background(bg));
	}

	public Button getBack() {
		return back;
	}

	public void setBack(Button back) {
		this.back = back;
	}

	public Label getEmail1Label() {
		return email1Label;
	}

	public void setEmail1Label(Label email1Label) {
		this.email1Label = email1Label;
	}

	public Label getEmail2Label() {
		return email2Label;
	}

	public void setEmail2Label(Label email2Label) {
		this.email2Label = email2Label;
	}

	public Label getWriteTextLabel() {
		return writeTextLabel;
	}

	public void setWriteTextLabel(Label writeTextLabel) {
		this.writeTextLabel = writeTextLabel;
	}

	public TextField getEmail1() {
		return email1;
	}

	public void setEmail1(TextField email1) {
		this.email1 = email1;
	}

	public TextField getEmail2() {
		return email2;
	}

	public void setEmail2(TextField email2) {
		this.email2 = email2;
	}

	public TextField getWriteText() {
		return writeText;
	}

	public void setWriteText(TextField writeText) {
		this.writeText = writeText;
	}

	public Button getSendMessage() {
		return sendMessage;
	}

	public void setSendMessage(Button sendMessage) {
		this.sendMessage = sendMessage;
	}

	public Alert getMsent() {
		return msent;
	}

	public void setMsent(Alert msent) {
		this.msent = msent;
	}

	public Alert getMnotsent() {
		return mnotsent;
	}

	public void setMnotsent(Alert mnotsent) {
		this.mnotsent = mnotsent;
	}

}
