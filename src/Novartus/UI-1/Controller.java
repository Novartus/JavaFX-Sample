package Novartus;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        log("Initialization Started");
        log("Initialization Done");
*/
        Label label = new Label("Dynamic Label Added");
        label.setFont(new Font(getRandomFont(), 25));
        /*label.setStyle("-fx-underline: true");
        label.setTextFill(Paint.valueOf("#0000FF"));*/
        Button button = new Button("Dynamic Button");

        TextField textField = new TextField();
        textField.setPromptText("Dynamic Text Field");

        Image image = new Image(getClass().getResourceAsStream("Img.png"), 30, 30, true, true);
        ImageView view = new ImageView(image);
        getImage().setGraphic(view);
        getImage().setContentDisplay(ContentDisplay.BOTTOM);

        label.setLayoutX(10);
        button.setLayoutY(40);
        button.setLayoutX(10);
        textField.setLayoutY(80);
        textField.setLayoutX(10);

        add(label, button, textField);
    }

}
