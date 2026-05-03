import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class MazeBuilder extends Application {

    // Properties
    private Button[][] maze;
    private int numRows, numCols;

    @Override
    public void start(Stage appStage) {
        // Get maze dimensions from user
        getMazeDimensions();

        // Initialize the maze UI
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 800, 600);

        // Create the maze grid
        GridPane gridPane = createMazeGrid();
        bp.setCenter(gridPane);

        // Create control buttons
        HBox controlBox = createControlButtons();
        bp.setBottom(controlBox);

        appStage.setTitle("Maze Builder");
        appStage.setScene(scene);
        appStage.show();
    }

    private void getMazeDimensions() {
        try {
            String rowsInput = JOptionPane.showInputDialog("Enter number of rows:");
            String colsInput = JOptionPane.showInputDialog("Enter number of columns:");

            //converts string to int
            numRows = Integer.parseInt(rowsInput);
            numCols = Integer.parseInt(colsInput);

            //event handling
            if (numRows <= 0 || numCols <= 0) {
                JOptionPane.showMessageDialog(null, "Dimensions must be positive integers!");
                Platform.exit();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid integers.");
            Platform.exit();
        }
    }

    private GridPane createMazeGrid() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(2); //horizontal gap between columns
        gridPane.setVgap(2);//vertical gap between rows

        maze = new Button[numRows][numCols];
        MyHandler handler = new MyHandler();

        // Create buttons for the maze
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Button button = new Button();
                button.setPrefSize(30, 30);
                button.setStyle("-fx-background-color: blue;"); // Start as wall
                button.setOnAction(handler);



                gridPane.add(button, col, row);//adds button with column and row
                maze[row][col] = button;
            }
        }

        return gridPane;
    }

    private HBox createControlButtons() {
        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);

        Button saveButton = new Button("Save");
        Button exitButton = new Button("Exit");

        MyHandler handler = new MyHandler();
        saveButton.setOnAction(handler);
        exitButton.setOnAction(handler);

        hbox.getChildren().addAll(saveButton, exitButton);
        return hbox;
    }

    // Returns the Maze character associated with the given button
    private char getColorChar(Button b) {
        if (b.getStyle().indexOf("blue") > -1) {
            return '0';
        }
        else if (b.getStyle().indexOf("white") > -1) {
            return '1';
        }
        else if (b.getStyle().indexOf("green") > -1) {
            return 'S';
        }
        else {
            return 'E';
        }
    }

    // Inner class listener for buttons
    public class MyHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            // e.getSource() returns the button that was clicked.
            Button b = (Button) e.getSource();

            if (b.getText().equals("Save")) {
                // Create output file
                saveMaze();
            }
            else if (b.getText().equals("Exit")) {
                // Exit the application
                exitApplication();
            }
            else {
                // A maze button was clicked - toggle through states
                char val = getColorChar(b);
                if (val == '0') {  // The button is currently blue so change it to white
                    b.setStyle("-fx-background-color: white;");
                }
                else if (val == '1') {  // Currently white, change to green (Entry)
                    b.setStyle("-fx-background-color: green;");
                }
                else if (val == 'S') {  // Currently green, change to red (Exit)
                    b.setStyle("-fx-background-color: red;");
                }
                else {  // Currently red, change back to blue (Wall)
                    b.setStyle("-fx-background-color: blue;");
                }
            }
        }
    }

    private void saveMaze() {
        try {
            File file = new File("maze.txt");
            FileWriter writer = new FileWriter(file);

            // Write dimensions
            writer.write(numRows + " " + numCols + "\n");

            // Write maze data
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    Button button = maze[row][col];
                    char tileChar = getColorChar(button);
                    writer.write(tileChar);
                }
                writer.write("\n");
            }

            writer.close();
            JOptionPane.showMessageDialog(null, "Maze saved successfully to " + file.getAbsolutePath());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving maze: " + ex.getMessage());
        }
    }

    private void exitApplication() {
        int response = JOptionPane.showConfirmDialog(
                null,
                "Would you like to save the maze before exiting?",
                "Exit Maze Builder",
                JOptionPane.YES_NO_CANCEL_OPTION
        );

        if (response == JOptionPane.YES_OPTION) {
            saveMaze();
            Platform.exit();
        } else if (response == JOptionPane.NO_OPTION) {
            Platform.exit();
        }
        // If CANCEL, do nothing
    }

    public static void main(String[] args) {
        launch(args);
    }
}