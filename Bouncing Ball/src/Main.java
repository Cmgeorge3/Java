import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    @Override
    public void start( Stage appStage ) {
        BouncePane bouncePane = new BouncePane();
        Scene scene = new Scene( bouncePane, 500,500);//size of screen
        appStage.setScene(scene);
        appStage.setTitle("Bouncing Ball Demo");
        appStage.show();
    }
    public static void main(String[] args) {

        launch(args);
    }
}