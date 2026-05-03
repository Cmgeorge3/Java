import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CalcPane extends BorderPane {
    private GridPane buttonPane;
    private HBox functionPane;
    private TextField textDisplay;
    private Button btnSquareRoot;
    private Button btnSquare;
    private Button btnClear;

    public CalcPane() {
        // Initialize the top text field
        textDisplay = new TextField();
        textDisplay.setAlignment(Pos.CENTER);
        setTop(textDisplay);

        // Initialize the grid pane for circle buttons
        buttonPane = new GridPane();
        setupNumberButtons();
        setCenter(buttonPane);

        // Initialize the function buttons at the bottom
        setupFunctionButtons();
    }

    private void setupNumberButtons() {
        // Create the event handler for circle buttons
        CircleButtonHandler handler = new CircleButtonHandler();

        int counter = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                CircleButton button = new CircleButton(String.valueOf(counter));
                button.setPrefSize(100, 100);

                // Register mouse event handlers
                button.setOnMousePressed(handler);
                button.setOnMouseReleased(handler);

                buttonPane.add(button, col, row);
                counter++;
            }
        }
    }

    private void setupFunctionButtons() {
        functionPane = new HBox();
        functionPane.setSpacing(10);
        functionPane.setAlignment(Pos.CENTER);

        btnSquareRoot = new Button("sqrt");
        btnSquare = new Button("x^2");
        btnClear = new Button("Clear");

        // Set minimum widths for buttons
        btnSquareRoot.setMinWidth(75);
        btnSquare.setMinWidth(75);
        btnClear.setMinWidth(75);

        // Add lambda expressions for button actions
        btnSquareRoot.setOnAction(e -> {
            String currentText = textDisplay.getText();
            if (!currentText.isEmpty()) {
                double value = Double.parseDouble(currentText);
                double result = Math.sqrt(value);
                textDisplay.setText(String.valueOf(result));
            }
        });

        btnSquare.setOnAction(e -> {
            String currentText = textDisplay.getText();
            if (!currentText.isEmpty()) {
                double value = Double.parseDouble(currentText);
                double result = Math.pow(value, 2);
                textDisplay.setText(String.valueOf(result));
            }
        });

        btnClear.setOnAction(e -> {
            textDisplay.setText("");
        });

        functionPane.getChildren().addAll(btnSquareRoot, btnSquare, btnClear);
        setBottom(functionPane);
    }

    // Inner class for handling circle button mouse events
    private class CircleButtonHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            CircleButton button = (CircleButton) event.getSource();

            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                // Mouse pressed - change to yellow and append value
                if (button.getColor().equals(Color.WHITE)) {
                    button.setColor(Color.YELLOW);
                    String currentText = textDisplay.getText();
                    textDisplay.setText(currentText + button.getValue());
                }
            } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                // Mouse released - change back to white
                button.setColor(Color.WHITE);
            }
        }
    }
}