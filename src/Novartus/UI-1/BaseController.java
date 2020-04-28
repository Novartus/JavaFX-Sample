package Novartus;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

    @FXML
    private Label img_label;

    protected void add(Node node) {
        pane.getChildren().add(node);
    }

    protected void add(Node... nodes) {
        pane.getChildren().addAll(nodes);
    }

    protected void log(Object line) {
        log.appendText((line.toString() + System.lineSeparator()));
    }

    protected String getRandomFont() {
        return fonts.get(random.nextInt(fonts.size()));
    }

    protected Label getImage() {
        return img_label;
    }
}
