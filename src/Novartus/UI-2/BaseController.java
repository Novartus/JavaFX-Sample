package Novartus;

import javafx.fxml.FXML;
import javafx.scene.Node;
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

    @FXML
    private Label hovered_label;

    @FXML
    private Label DragTarget;

    @FXML
    private Label DragSource;

    @FXML
    private Label Draggable;

    private double init_x, init_y;

    @FXML
    void onDrag(MouseEvent event) {
        double x = event.getSceneX() - init_x;
        double y = event.getSceneY() - init_y;

        Draggable.setLayoutX(Draggable.getLayoutX() + x);
        Draggable.setLayoutY(Draggable.getLayoutY() + y);

        init_x = event.getSceneX();
        init_y = event.getSceneY();
    }

    @FXML
    void onPressed(MouseEvent event) {
        init_x = event.getSceneX();
        init_y = event.getSceneY();
    }



    protected void add(Node node) {
        pane.getChildren().add(node);
    }

    protected void add(Node... nodes) {
        pane.getChildren().addAll(nodes);
    }

    protected void log(Object line) {
        log.appendText((line.toString() + System.lineSeparator()));
    }

    protected void InitHoverImg() {
        Image like_img = new Image(getClass().getResourceAsStream("like.png"), 24, 25, true, true);
        Image dislike_img = new Image(getClass().getResourceAsStream("dislike.png"), 24, 25, true, true);

        ImageView likeview = new ImageView(like_img);
        ImageView dislikeview = new ImageView(dislike_img);

        hovered_label.setGraphic(dislikeview);

        hovered_label.setOnMouseEntered(mouseEvent -> {
            hovered_label.setGraphic(likeview);
        });

        hovered_label.setOnMouseExited(mouseEvent -> {
            hovered_label.setGraphic(dislikeview);
        });

        hovered_label.setOnMouseClicked(mouseEvent -> {
            log("Clicked On HoverLabel");
        });
    }

    protected void InitDrag() {
        DragSource.setOnDragDetected(event -> {
            Dragboard dragboard = DragSource.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            //Text of the label --> ClipBoard Content as String
            content.putString(DragSource.getText());
            dragboard.setContent(content);
            // Doesn't propagate to other controls
            event.consume();
        });

        DragTarget.setOnDragOver(event -> {
            Dragboard dragboard = event.getDragboard();
            if (event.getGestureSource() != DragTarget && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
                // Doesn't propagate to other controls
                event.consume();
            }
        });

        DragTarget.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();

            if (dragboard.hasString()) {
                DragTarget.setText(dragboard.getString());
                event.setDropCompleted(true);
            }
            event.consume();
        });

        DragTarget.setOnDragEntered(event -> {
            DragTarget.setStyle("-fx-background-color: brown");
        });

        DragTarget.setOnDragExited(event -> {
            DragTarget.setStyle("-fx-background-color: teal");
        });
    }
}
