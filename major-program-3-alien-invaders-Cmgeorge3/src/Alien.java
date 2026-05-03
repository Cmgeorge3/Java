//Christopher George
//11/19/2025
//Comp 167-02
//Alien class for space Invaders
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import java.io.FileInputStream;

public class Alien extends Invader {
    private int alienType; // which alien is displayed (0, 1, or 2)
    private Rectangle2D[] viewportRects; // Two rectangles for animation
    private int currentImage; // index into viewportRects (0 or 1)
    private ActionPane actionPane;
    AnimationTimer toggleTimer;

    public Alien(ActionPane actionPane, Image sprites, int alienType) {
        super();
        this.actionPane = actionPane;
        this.alienType = alienType;
        this.viewportRects = new Rectangle2D[2]; // Initialize the array
        this.currentImage = 0;

        try {

            this.setImage(sprites);
        } catch (Exception e) {
            System.err.println("Error setting alien image: " + e.getMessage());
            System.exit(-1);
        }

        // Set up the alien based on type
        setupAlienType();

        // Common settings for all aliens
        this.setScaleX(1.5);
        this.setScaleY(1.5);
        this.setSpeed(3.0);
        this.setVisible(true);
        setParentWidth(actionPane.getPrefWidth());
        setParentHeight(actionPane.getPrefHeight());

        // Initial position (center bottom)
        this.setX(getParentWidth() / 2 - this.getBoundsInLocal().getWidth() / 2);
        this.setY(getParentHeight() + 60);
    }

    private void setupAlienType() {
        switch (alienType) {
            case 0: // Bottom rows - 10 points
                super.setPointValue(10);
                viewportRects[0] = new Rectangle2D(1, 19, 50, 19);
                viewportRects[1] = new Rectangle2D(28, 20, 50, 19);
                break;

            case 1: // Middle rows - 20 points
                super.setPointValue(20);
                viewportRects[0] = new Rectangle2D(55, 21, 50, 19);
                viewportRects[1] = new Rectangle2D(80, 18, 50, 19);
                break;

            case 2: // Top row - 40 points (NOT 30)
                super.setPointValue(40);
                viewportRects[0] = new Rectangle2D(112, 19, 50, 19);
                viewportRects[1] = new Rectangle2D(138, 18, 50, 19);
                break;
        }

        // Set initial viewport
        this.setViewport(viewportRects[currentImage]);
    }

    // Toggle between the two images
    public void toggleImage() {
        currentImage = (currentImage + 1) % 2; // Switch between 0 and 1
        this.setViewport(viewportRects[currentImage]);
    }

    // Getters and setters
    public int getAlienType() {
        return alienType;
    }

    public void setAlienType(int alienType) {
        this.alienType = alienType;
        setupAlienType(); // Reconfigure when type changes
    }

    public Rectangle2D[] getViewportRects() {
        return viewportRects;
    }

    public int getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(int currentImage) {
        this.currentImage = currentImage;
        if (viewportRects != null && currentImage >= 0 && currentImage < 2) {
            this.setViewport(viewportRects[currentImage]);
        }
    }

    public ActionPane getActionPane() {
        return actionPane;
    }

    public void setActionPane(ActionPane actionPane) {
        this.actionPane = actionPane;
    }
    private void startToggle() {
        toggleTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                toggleImage();
            }

        };
        toggleTimer.start();
    }
    public void destroy() {
        this.setVisible(false);
        if (toggleTimer != null) {
            toggleTimer.stop();
        }
    }
}