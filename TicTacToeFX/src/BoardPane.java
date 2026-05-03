import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;


public class BoardPane extends StackPane {
    private char value;

    public BoardPane(){
        setValue(' ');
    }
    public BoardPane(char value){
        this.setValue(value);
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
        drawMove();
    }
    public void drawMove(){
        if(this.value != ' ') {
            if(this.value == 'O'){
                Circle circle = new Circle(45);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLACK);
                this.getChildren().add(circle);
            }
            else{
                //drawing line between 2 points
                Line l1 = new Line(5.0f,5.0f,95.0f,95.0f);
                Line l2 = new Line(95.0,5.0,5.0f,95.0f);
                l1.setStroke(Color.BLACK);
                l2.setStroke(Color.BLACK);
                this.getChildren().addAll(l1,l2);//adding to the pane
            }
        }
    }
}
