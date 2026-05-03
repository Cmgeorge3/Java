//Christopher George
//11/19/2025
//Comp 167-02
//GamePane class for space Invaders
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.HBox;

import java.util.Random;

public class GamePane extends BorderPane {
    private ActionPane actionPane;
    private StatusPane statusPane;
    private ControlPane controlPane;
    private CmdCenter cmdCenter;
    private SpaceShip spaceShip;
    private AnimationTimer gameTimer;
    private AnimationTimer spaceShipTimer;
    private Random random;
    private long lastSpaceShipLaunch;
   // private Alien alien;
    //private TheHord hord;

    public GamePane() {
        this.random = new Random();
        this.lastSpaceShipLaunch = System.currentTimeMillis();
        //initializeGame();
        setupEventHandlers();
        startGameLoop();
        startSpaceShipTimer();
        controlPane = new ControlPane();
        controlPane.setPrefHeight(20.0);
        this.setBottom(controlPane);

    }
//adds elements to Pane/sets location
    private void initializeGame() {
        actionPane = new ActionPane();
        this.setCenter(actionPane);
        statusPane = new StatusPane();
        this.setTop(statusPane);

        controlPane = new ControlPane();
        controlPane.setPrefHeight(20.0);
        this.setBottom(controlPane);


        cmdCenter = new CmdCenter(actionPane);
        actionPane.getChildren().add(cmdCenter);
       // actionPane.getChildren().add(alien);

        spaceShip = new SpaceShip(actionPane);
        actionPane.getChildren().add(spaceShip);

        System.out.println("Game initialized");
    }

    private void startGameLoop() {
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                cmdCenter.move();
                checkCollisions();
            }
        };
        gameTimer.start();
    }

    private void startSpaceShipTimer() {
        spaceShipTimer = new AnimationTimer() {
            private long lastLaunchTime = System.currentTimeMillis();

            @Override
            public void handle(long now) {
                long currentTime = System.currentTimeMillis();
                long elapsed = currentTime - lastLaunchTime;
                long launchInterval = (random.nextInt(6) + 5) * 1000;

                if (elapsed > launchInterval && !spaceShip.isActive()) {
                    spaceShip.launch();
                    lastLaunchTime = currentTime;
                }
            }
        };
        spaceShipTimer.start();
    }

    private void checkCollisions() {
        // If no projectile or no active spaceship, skip
        if (cmdCenter.getProjectile() == null || !spaceShip.isActive()) {
            return;
        }

        Projectile projectile = cmdCenter.getProjectile();

        // SIMPLE COLLISION: Check if projectile Y position is near spaceship Y position
        double projBottom = projectile.getY() + projectile.getHeight();
        double shipTop = spaceShip.getY();
        double shipBottom = spaceShip.getY() + (spaceShip.getBoundsInLocal().getHeight() * spaceShip.getScaleY());

        // If projectile bottom is between spaceship top and bottom
        if (projBottom >= shipTop && projBottom <= shipBottom) {
            // Check if projectile is within spaceship width
            double projCenterX = projectile.getX() + projectile.getWidth() / 2;
            double shipLeft = spaceShip.getX();
            double shipRight = spaceShip.getX() + (spaceShip.getBoundsInLocal().getWidth() * spaceShip.getScaleX());

            if (projCenterX >= shipLeft && projCenterX <= shipRight) {
                handleCollision();
                return;
            }
        }

        // ALTERNATIVE: Check if any part of projectile overlaps with spaceship
        double projTop = projectile.getY();
        double projLeft = projectile.getX();
        double projRight = projectile.getX() + projectile.getWidth();
        double shipLeft = spaceShip.getX();
        double shipRight = spaceShip.getX() + (spaceShip.getBoundsInLocal().getWidth() * spaceShip.getScaleX());


        // Simple overlap check
        boolean overlapX = projRight >= shipLeft && projLeft <= shipRight;
        boolean overlapY = projBottom >= shipTop && projTop <= shipBottom;

        if (overlapX && overlapY) {
            handleCollision();
        }
    }

    private void handleCollision() {
        System.out.println("💥 COLLISION DETECTED! 💥");
        System.out.println("Points: " + spaceShip.getPointValue());
        statusPane.updateScore(spaceShip.setRandomPointValue());

        // Get references before reset
        Projectile projectile = cmdCenter.getProjectile();

        // 1. Remove projectile from scene
        if (projectile != null && actionPane.getChildren().contains(projectile)) {
            actionPane.getChildren().remove(projectile);
        }

        // 2. Hide spaceship
        spaceShip.destroy();

        // 3. Clear projectile reference in cmdCenter (CRITICAL - allows shooting again)
        clearProjectileReference();

        // 4. Reset spaceship launch timer so it appears again soon
        lastSpaceShipLaunch = System.currentTimeMillis();

        System.out.println("Collision handled - ready for next shot");
    }

    private void clearProjectileReference() {
        // clear the projectile reference in cmdCenter to shoot again
        try {
            // Using reflection to clear the private projectile field
            java.lang.reflect.Field projectileField = CmdCenter.class.getDeclaredField("projectile");
            projectileField.setAccessible(true);
            projectileField.set(cmdCenter, null);
            System.out.println("Projectile reference cleared");
        } catch (Exception e) {
            System.out.println("Could not clear projectile reference: " + e.getMessage());
        }
    }

    private void setupEventHandlers() {
        this.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            switch (keyCode) {
                case LEFT:
                    cmdCenter.startMovingLeft();
                    break;
                case RIGHT:
                    cmdCenter.startMovingRight();
                    break;
                case SPACE:
                    cmdCenter.fireProjectile();
                    break;
            }
        });

        this.setOnKeyReleased(event -> {
            KeyCode keyCode = event.getCode();
            if (keyCode == KeyCode.LEFT || keyCode == KeyCode.RIGHT) {
                cmdCenter.stopMoving();
            }
        });

        this.setFocusTraversable(true);
        this.requestFocus();
        this.setOnMouseClicked(event -> this.requestFocus());
    }

    public void addGameObject(GameObject go) {
        actionPane.getChildren().add(go);
    }

    public ActionPane getActionPane() {
        return actionPane;
    }

    public CmdCenter getCmdCenter() {
        return cmdCenter;
    }



    public class ControlPane extends HBox {
        private Button startButton;
        private Button restartButton;
        private Button exitButton;

        public ControlPane() {
            initializeComponents();
            setupLayout();
            setupEventHandlers();
        }

        private void initializeComponents() {
            startButton = new Button("Start Game");
            restartButton = new Button("Restart");
            exitButton = new Button("Exit");

            // Style buttons
            String buttonStyle = "-fx-font-size: 14px; -fx-padding: 8px 16px;";
            startButton.setStyle(buttonStyle);
            restartButton.setStyle(buttonStyle);
            exitButton.setStyle(buttonStyle);
        }

        private void setupLayout() {
            this.setStyle("-fx-background-color: #444; -fx-padding: 10px; -fx-alignment: center;");
            this.setSpacing(10);

            this.getChildren().addAll(startButton, restartButton, exitButton);
        }

        //lamdon listeners
        private void setupEventHandlers() {
            startButton.setOnAction(event -> {
                System.out.println("Start game clicked");
                initializeGame();
            });

            restartButton.setOnAction(event -> {
                System.out.println("Restart game clicked");
                //void startSpaceShipTimer();
                spaceShipTimer.stop();
                gameTimer.stop();
                gameTimer.start();
                spaceShipTimer.start();
                statusPane.updateScore(0);
                initializeGame();


            });

            exitButton.setOnAction(event -> {
                System.out.println("Exit game clicked");
                System.exit(0);
            });
        }
    }


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
}