import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXDriver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMainPane root = new FXMainPane();
        Scene scene = new Scene(root, 600, 350); // Instantiate Scene here
        stage.setScene(scene);
        stage.setTitle("Hello World GUI");
        stage.show();
    }
}