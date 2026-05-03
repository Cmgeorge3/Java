//Christopher George
//11/19/2025
//Comp 167-02
//CMDcenter class for space Invaders
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class CmdCenter extends GameObject {
    private Projectile projectile;
    private ActionPane actionPane;
    private boolean movingLeft = false;
    private boolean movingRight = false;

    public CmdCenter(ActionPane actionPane) {
        super();
        this.actionPane = actionPane;

        // Load sprite sheet
        try {
            Image image = new Image(new FileInputStream("images/alienspritesheet.png"));
            this.setImage(image);
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }

        // Set viewport for CmdCenter (coordinates from assignment)
        javafx.geometry.Rectangle2D viewportRect = new javafx.geometry.Rectangle2D(217, 16, 21, 15);
        this.setViewport(viewportRect);

        // Scale as specified
        this.setScaleX(1.5);
        this.setScaleY(1.5);

        // Set parent dimensions
        setParentWidth(actionPane.getPrefWidth());
        setParentHeight(actionPane.getPrefHeight());

        // Initial position (center bottom)
        this.setX(getParentWidth() / 2 - this.getBoundsInLocal().getWidth() / 2);
        this.setY(getParentHeight() + 500);

        // Set initial speed and direction
        setSpeed(8.0);
        setDirection(DirectionConstants.EAST);
    }

    public void fireProjectile() {
        //CmdCenter checks if projectile is actually in the scene before deciding if it can fire
        if (projectile == null || !actionPane.getChildren().contains(projectile)) {
            double projectileX = this.getX() + this.getBoundsInLocal().getWidth() / 2 - 1.5;
            double projectileY = this.getY() - 15;

            projectile = new Projectile(actionPane, projectileX, projectileY);
            actionPane.getChildren().add(projectile);
          //  System.out.println("Projectile fired!");
        }
    }

    public Projectile getProjectile() {
        return projectile;
    }

    @Override
    public void move() {
        if (!movingLeft && !movingRight) {
            return;
        }

        double newX = this.getX();

        if (movingLeft) {
            newX -= getSpeed();
            setDirection(DirectionConstants.WEST);
        } else if (movingRight) {
            newX += getSpeed();
            setDirection(DirectionConstants.EAST);
        }

        // Boundary checking
        if (newX < 0) {
            newX = 0;
        } else if (newX + this.getBoundsInLocal().getWidth() > getParentWidth()) {
            newX = getParentWidth() - this.getBoundsInLocal().getWidth();
        }

        this.setX(newX);
    }

    // Movement control methods
    public void startMovingLeft() {
        movingLeft = true;
        movingRight = false;
    }

    public void startMovingRight() {
        movingRight = true;
        movingLeft = false;
    }

    public void stopMoving() {
        movingLeft = false;
        movingRight = false;
    }
}