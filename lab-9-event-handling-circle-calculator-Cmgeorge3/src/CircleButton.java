import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleButton extends StackPane {
    private Label lblValue;
    private Circle circle;

    // No-arg constructor
    public CircleButton() {
        this(""); // Call the other constructor with empty string
    }

    // Constructor with String parameter
    public CircleButton(String val) {
        // Instantiate Label and Circle objects
        lblValue = new Label(val);
        circle = new Circle(45); // Radius of 45 pixels

        // Set circle colors using setStroke() and setFill()
        circle.setStroke(Color.BLACK); // Outline color
        circle.setFill(Color.WHITE);   // Interior color

        // Set text color
        lblValue.setTextFill(Color.BLACK);

        // Add both objects to the StackPane
        this.getChildren().addAll(circle, lblValue);

        // Set preferred size
        this.setPrefSize(100, 100);
    }

    // Set the background/fill color of the CircleButton
    public void setColor(Color color) {
        circle.setFill(color);
    }

    // Get the current fill color of the CircleButton
    public Color getColor() {
        return (Color) circle.getFill();
    }

    // Get the value currently displayed on the CircleButton
    public String getValue() {
        return lblValue.getText();
    }
}