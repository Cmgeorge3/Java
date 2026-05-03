import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start( Stage stage) {
        MainPane mainPane = new MainPane();
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);

        stage.setTitle("Loan Calculator");
        stage.show();
    }

    public static void main( String [] args) {
        launch( args );
    }

}
