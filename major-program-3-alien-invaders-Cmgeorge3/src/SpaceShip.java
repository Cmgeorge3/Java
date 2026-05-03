//Christopher George
//11/19/2025
//Comp 167-02
//SpaceShip class for space Invaders

import javafx.animation.AnimationTimer;
import java.util.Random;

public class SpaceShip extends Invader {
    private ActionPane actionPane;
    private AnimationTimer movementTimer;
    private static Random random;
    private boolean isActive;

    public SpaceShip(ActionPane actionPane) {
        super();
        this.actionPane = actionPane;
        this.random = new Random();
        this.isActive = false;

        // Load spaceship sprite from the sprite sheet
        try {
            javafx.scene.image.Image image = new javafx.scene.image.Image(
                    new java.io.FileInputStream("images/alienspritesheet.png"));
            this.setImage(image);
        }
        catch (java.io.FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }

        // Set viewport for SpaceShip with the correct coordinates
        javafx.geometry.Rectangle2D viewportRect = new javafx.geometry.Rectangle2D(166, 11, 45, 19);
        this.setViewport(viewportRect);

        // Scale if needed
        this.setScaleX(1.5);
        this.setScaleY(1.5);

        // Set parent dimensions
        setParentWidth(actionPane.getPrefWidth());
        setParentHeight(actionPane.getPrefHeight());

        setSpeed(3.0);

        // Set initial point value (will be randomized when launched)
        setPointValue(0);

        // Initially hidden
        this.setVisible(false);
    }

    public void launch() {
        if (isActive) {
            System.out.println("Spaceship already active, cannot launch");
            return;
        }

        isActive = true;
        this.setVisible(true);

        // Set random point value
        setRandomPointValue();

        // Set random direction
        if (random.nextBoolean()) {
            setDirection(DirectionConstants.WEST);
            this.setX(getParentWidth());
            System.out.println("Launching spaceship from RIGHT to LEFT");
        } else {
            setDirection(DirectionConstants.EAST);
            this.setX(-this.getBoundsInLocal().getWidth());
            System.out.println("Launching spaceship from LEFT to RIGHT");
        }

        // Set Y position
        this.setY(50);
        System.out.println("Spaceship position: " + this.getX() + ", " + this.getY());
        System.out.println("Spaceship visible: " + this.isVisible());
        System.out.println("Spaceship active: " + isActive);

        startMovement();
    }

    @Override
    public void move() {
        if (!isActive) return;

        // Use the trigonometric movement from GameObject
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
        this.setX(newX);

        // Check if off screen
        if ((getDirection() == DirectionConstants.WEST && this.getX() + this.getBoundsInLocal().getWidth() < 0) ||
                (getDirection() == DirectionConstants.EAST && this.getX() > getParentWidth())) {
            destroy();
        }
    }

    private void startMovement() {
        movementTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                move();
            }
        };
        movementTimer.start();
    }

    // This method matches the requirement from the assignment
    public int setRandomPointValue() {
        int[] possiblePoints = {100, 200, 300};
        int pointValue = possiblePoints[random.nextInt(possiblePoints.length)];
        setPointValue(pointValue); // Use the inherited setter from Invader
        System.out.println("Spaceship point value: " + pointValue);
        return pointValue;
    }

    public boolean isActive() {
        return isActive;
    }

    public void destroy() {
        isActive = false;
        this.setVisible(false);
        if (movementTimer != null) {
            movementTimer.stop();
        }
    }

    public void reset() {
        destroy();
    }
}