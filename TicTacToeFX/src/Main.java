import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage myStage){
        TicTacToePane tttp = new TicTacToePane();
        BoardPane boardPane = new BoardPane('O');
        boardPane.setPrefSize(100,100);
        Scene scene = new Scene(tttp, 300,300);
        myStage.setScene(scene);

        myStage.setTitle("TicTacToe Board");
        myStage.show();

    }
    public static void main(String [] args){
        launch(args);

    }
}
