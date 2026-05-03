//Christopher George
//11/19/2025
//Comp 167-02
//Main class for running space Invaders
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GamePane gamePane = new GamePane();
        Scene scene = new Scene(gamePane, 700, 700);//same size as actionPane

        primaryStage.setTitle("Space Invaders");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // Ensures GamePane has focus for keyboard events
        gamePane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}