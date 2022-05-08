package view;

import java.io.FileInputStream;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ViewMessages extends GridPane {

	//private Label title;
	private Button back;

	public ViewMessages() throws Exception {

		this.setVgap(15);
		this.setHgap(15);

		this.setAlignment(Pos.BASELINE_CENTER);	 

		//this.title = new Label("VIEW MESSAGES:");
		this.back = new Button("BACK");

	//	title.setFont(new Font("Impact", 40));
	//	title.setTextFill(Color.PURPLE);

		//this.add(this.title, 1, 1);
		this.add(this.back, 3, 10);
	
		FileInputStream f = new FileInputStream("images/fondo2.jpg");
		Image bgImage = new Image(f);
		BackgroundImage bg = new BackgroundImage(bgImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(500, 800, false, false, false, false));
		this.setBackground(new Background(bg));

		back.setStyle(
				"-fx-border-color: CADETBLUE; -fx-text-fill: PURPLE; -fx-border- width: 5px; -fx-background-color: white; -fx-font-size: 20px;");

	}

	public Button getBack() {
		return back;
	}

	public void setBack(Button back) {
		this.back = back;
	}
}
