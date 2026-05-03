import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Connect4Pane extends Pane {
    private char color;

    public Connect4Pane(){
        setColor('w');


    }
    public Connect4Pane(char color){
        this.setColor(color);

    }


    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
        changeColor();
    }

    private void changeColor() {
        if (color == 'w'){
            Circle circle = new Circle(90);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            this.getChildren().add(circle);
            color = 'r';
        }
        else if (color == 'r'){
            Circle circle = new Circle(45);
            circle.setFill(Color.RED);
            circle.setStroke(Color.BLACK);
            this.getChildren().add(circle);
            color = 'y';
        }
        else if (color == 'y'){
            Circle circle = new Circle(45);
            circle.setFill(Color.RED);
            circle.setStroke(Color.BLACK);
            this.getChildren().add(circle);
            color = 'r';
        }
    }
}
