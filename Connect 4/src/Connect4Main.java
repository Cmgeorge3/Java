import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Connect4Main extends Application {
    @Override
    public void start(Stage stage){
        Pane pane = new Pane();
        Connect4Pane c4p = new Connect4Pane();
        Scene scene = new Scene(c4p);
        stage.setScene(scene);
        stage.setTitle("Connect 4");
        stage.show();
    }
    public static void main(String [] args){
        launch(args);
    }
}
