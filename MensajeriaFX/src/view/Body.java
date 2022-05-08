package view;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Login;

public class Body extends GridPane {

	private Login login;

	private Label title;
	private Label emailLabel;
	private Label passLabel;

	private TextField email;
	private PasswordField pass;

	private Button loginButton;
	private Button newAccount;
	Alert welcome = new Alert(AlertType.INFORMATION, "WELCOME");
	Alert notwelcome = new Alert(AlertType.INFORMATION, "INCORRECT EMAIL OR PASSWORD, PLEASE TRY AGAIN");
	Alert empty = new Alert(AlertType.INFORMATION, "YOU MUST WRITE THE DATA");

	public Body() throws Exception {

		this.setVgap(15);
		this.setHgap(15);

		this.setAlignment(Pos.BASELINE_CENTER);

		this.title = new Label("WELCOME TO HESPERIDES");
		this.emailLabel = new Label("Email:");
		this.passLabel = new Label("Password:");

		this.email = new TextField();
		this.pass = new PasswordField();

		loginButton = new Button("ENTER");
		newAccount = new Button("NEW ACCOUNT");

		title.setFont(new Font("Impact", 40));
		title.setTextFill(Color.PURPLE);

		this.add(this.title, 1, 1);
		this.add(this.emailLabel, 1, 3);
		this.add(this.email, 1, 4);
		this.add(this.passLabel, 1, 5);
		this.add(this.pass, 1, 6);
		this.add(this.loginButton, 1, 8);
		this.add(this.newAccount, 1, 9);

		emailLabel.setFont(new Font("Lucida Sans Unicode", 15));
		emailLabel.setTextFill(Color.PURPLE);
		passLabel.setFont(new Font("Lucida Sans Unicode", 15));
		passLabel.setTextFill(Color.PURPLE);
		loginButton.setStyle(
				"-fx-border-color: CADETBLUE; -fx-text-fill: PURPLE; -fx-border- width: 5px; -fx-background-color: white; -fx-font-size: 20px;");
		newAccount.setStyle(
				"-fx-border-color: CADETBLUE; -fx-text-fill: PURPLE; -fx-border- width: 5px; -fx-background-color: white; -fx-font-size: 20px;");

	}

	public Button getNewAccount() {
		return newAccount;
	}

	public void setNewAccount(Button newAccount) {
		this.newAccount = newAccount;
	}

	public Alert getWelcome() {
		return welcome;
	}

	public void setWelcome(Alert welcome) {
		this.welcome = welcome;
	}

	public Alert getNotwelcome() {
		return notwelcome;
	}

	public void setNotwelcome(Alert notwelcome) {
		this.notwelcome = notwelcome;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
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

	public PasswordField getPass() {
		return pass;
	}

	public void setPass(PasswordField pass) {
		this.pass = pass;
	}

	public Button getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(Button loginButton) {
		this.loginButton = loginButton;
	}

	public Alert getEmpty() {
		return empty;
	}

	public void setEmpty(Alert empty) {
		this.empty = empty;
	}

}
