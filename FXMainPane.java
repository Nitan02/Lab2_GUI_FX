import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.Scene;

public class FXMainPane extends VBox {

    // Task #1: Declare an instance of DataManager and instantiate it in the constructor
    private DataManager dataManager;

    // Task #2: Create an inner class ButtonHandler to handle button actions
    private class ButtonHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            Object source = event.getSource();
            if (source == buttonHello) {
                textFieldInput.setText(dataManager.getHello());
            } else if (source == buttonHowdy) {
                textFieldInput.setText(dataManager.getHowdy());
            } else if (source == buttonChinese) {
                textFieldInput.setText(dataManager.getChinese());
            } else if (source == buttonClear) {
                textFieldInput.setText("");
            } else if (source == buttonExit) {
                Platform.exit();
                System.exit(0);
            } else if (source == buttonJustForFun) {
                textFieldInput.setText(dataManager.getJustForFun());
            }
        }
    }

    // Task #3: Declare buttons, label, and textfield
    private Button buttonHello, buttonHowdy, buttonChinese, buttonClear, buttonExit;
    private Label labelFeedback;
    private TextField textFieldInput;

    // Task #3: Declare HBoxes
    private HBox hboxButtons, hboxLabelAndTextField;
	private Node buttonJustForFun;

    FXMainPane() {
        // Task #1: Instantiate DataManager
        dataManager = new DataManager();

        // Task #3: Instantiate buttons, label, and textfield
        buttonHello = new Button("Hello");
        buttonHowdy = new Button("Howdy");
        buttonChinese = new Button("Chinese");
        buttonClear = new Button("Clear");
        buttonExit = new Button("Exit");
        buttonJustForFun = new Button("Just For Fun");
        labelFeedback = new Label("Feedback:");
        textFieldInput = new TextField();

        // Task #3: Instantiate HBoxes
        hboxButtons = new HBox(10);
        hboxLabelAndTextField = new HBox(10);

        // Task #2: Set button actions
        buttonHello.setOnAction(new ButtonHandler());
        buttonHowdy.setOnAction(new ButtonHandler());
        buttonChinese.setOnAction(new ButtonHandler());
        buttonClear.setOnAction(new ButtonHandler());
        buttonExit.setOnAction(new ButtonHandler());
        ((ButtonBase) buttonJustForFun).setOnAction(new ButtonHandler());

        // Task #3: Add buttons to buttons HBox
        hboxButtons.getChildren().addAll(buttonHello, buttonHowdy, buttonChinese, buttonClear, buttonExit,buttonJustForFun);

        // Task #3: Add label and textfield to labelAndTextField HBox
        hboxLabelAndTextField.getChildren().addAll(labelFeedback, textFieldInput);

        // Task #3: Add HBoxes to FXMainPane (VBox)
        getChildren().addAll(hboxButtons, hboxLabelAndTextField);

        // Task #3: Set alignment and spacing for FXMainPane
        setAlignment(Pos.CENTER);
        setSpacing(10);

        // Task #4: Set margins for components
        Insets inset = new Insets(10);
        HBox.setMargin(buttonHello, inset);
        HBox.setMargin(buttonHowdy, inset);
        HBox.setMargin(buttonChinese, inset);
        HBox.setMargin(buttonClear, inset);
        HBox.setMargin(buttonExit, inset);
        HBox.setMargin(buttonJustForFun, inset);
    }
}