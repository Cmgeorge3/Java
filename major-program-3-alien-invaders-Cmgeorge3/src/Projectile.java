//Christopher George
//11/19/2025
//Comp 167-02
//Projectile class for space Invaders

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;

public class Projectile extends Rectangle {
    private AnimationTimer movementTimer;
    private ActionPane actionPane;
    private double speed = 8.0;
    private boolean isActive;

    public Projectile(ActionPane actionPane, double startX, double startY) {
        super(3, 15, javafx.scene.paint.Color.LIME); // Width, Height, Color
        this.actionPane = actionPane;

        // Set position
        this.setX(startX);
        this.setY(startY);

        System.out.println("Projectile created at: " + startX + ", " + startY);

        // Start movement
        startMovement();
    }

    public void move() {
        // Simple upward movement
        double newY = this.getY() - speed;
        this.setY(newY);

        // Remove if off screen
        if (this.getY() + this.getHeight() < 0) {
            stopMovement();
            if (actionPane != null && actionPane.getChildren().contains(this)) {
                actionPane.getChildren().remove(this);
            }
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

    public void stopMovement() {
        if (movementTimer != null) {
            movementTimer.stop();
        }
    }
    public boolean isActive() {
        return isActive && this.isVisible();
    }
    public javafx.geometry.Bounds getCurrentBounds() {
        return this.getBoundsInParent();
    }
    public void destroy() {
        isActive = false;
        this.setVisible(false);
        if (movementTimer != null) {
            movementTimer.stop();
        }
    }
}