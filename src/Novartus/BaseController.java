package Novartus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import java.util.List;
import java.util.Random;

public class BaseController {
    private List<String> fonts = Font.getFontNames();
    private Random random = new Random();

    @FXML
    private TextArea log;

    @FXML
    private AnchorPane pane;

    protected void add(Node node) {
        pane.getChildren().add(node);
    }

    protected void add(Node... nodes) {
        pane.getChildren().addAll(nodes);
    }

    protected void log(Object line) {
        log.appendText((line.toString() + System.lineSeparator()));
    }

}
