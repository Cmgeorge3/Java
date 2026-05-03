import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class StatusPane extends HBox {
    private Label scoreLabel;
    private Label livesLabel;
    private Label levelLabel;
    private ActionPane ap = new ActionPane();
    SpaceShip sp = new SpaceShip(ap);
    int sum = 0;
    //private int score = sp.setRandomPointValue();

    public StatusPane() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        scoreLabel = new Label("Score: 0");
        livesLabel = new Label("Lives: 3");
        levelLabel = new Label("Level: 1");

        // Style the labels
        scoreLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");
        livesLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");
        levelLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");
    }

    private void setupLayout() {
        this.setStyle("-fx-background-color: #333; -fx-padding: 10px;");
        this.setSpacing(20);

        // Add components to HBox
        this.getChildren().addAll(scoreLabel, livesLabel, levelLabel);
    }

    // Methods to update status
    public void updateScore(int score) {
        //score += sp.setRandomPointValue();

        sum += score;
        scoreLabel.setText("Score: " + sum);

    }

    public void updateLives(int lives) {
        livesLabel.setText("Lives: " + lives);
    }

    public void updateLevel(int level) {
        levelLabel.setText("Level: " + level);
    }
}