import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MainPane extends BorderPane {
    Button btnClear = new Button("Clear");
    Button btnCalc = new Button("Calculate");
    CalcGridPane calcGridPane;

    public MainPane() {
        calcGridPane = new CalcGridPane();

        this.setCenter(calcGridPane);
        this.setBottom( createCommandPane());
        this.setPadding(new Insets(10, 10, 10, 10));

    }

    public HBox createCommandPane() {
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll( btnClear, btnCalc);

        btnCalc.setOnAction(new EventHandler<ActionEvent>() {
            public void handle( ActionEvent e) {
                calcGridPane.calculatePayment();
            }});

        btnClear.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent e) {
                calcGridPane.clearFields();
            }});

        return hBox;
    }


}
