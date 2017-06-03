import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * Created by vlajko on 5/30/17.
 */
public class App extends Application {

    private Button button;

    public static void main(String args[]) {
        launch(args);
        System.out.println("Start App Here");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Semirnarski");

        button = new Button();
        button.setText("Click me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
