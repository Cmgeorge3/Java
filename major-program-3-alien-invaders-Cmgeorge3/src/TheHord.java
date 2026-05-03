//Christopher George
//11/19/2025
//Comp 167-02
//Hord class for space Invaders
import javafx.scene.image.Image;

/*public class TheHord {
    private Alien[][] aliens = new Alien[5][11];
    private double direction;
    private double lastDirection;
    private int numLiving;
    private boolean atEdge;
    private ActionPane actionPane;
    private Image alienSprites;

    public TheHord(ActionPane actionPane, Image sprites) {
        this.setActionPane(actionPane);
        this.setAlienSprites(sprites);
        this.setDirection(Movable.DirectionConstants.EAST);
        this.setNumLiving(55);
        this.setAtEdge(false);


        initTheHord();

    }

    private void initTheHord() {
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 11; col++) {
                int alienType = determineAlienType(row);
                Alien alien = new Alien(getActionPane(), getAlienSprites(), alienType);
                getAliens()[row][col] = alien;



                positionAlien(alien, row, col);


                getActionPane().getChildren().add(alien);
            }
        }
    }

    private int determineAlienType(int row) {
        if (row == 0) return 2;
        if (row <= 2) return 1;
        return 0;
    }

    private void positionAlien(Alien alien, int row, int col) {
        // Calculate position based on row/col
        double x = col * 50 + 50;
        double y = row * 40 + 50;
        alien.setX(x);
        alien.setY(y);
    }
    // Movement & Gameplay
    public void move() {
        if (!isActive) return;

        // Use the trigonometric movement from GameObject
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
        this.setX(newX);

        // Check if off screen
        if ((getDirection() == Movable.DirectionConstants.WEST && this.getX() + this.getBoundsInLocal().getWidth() < 0) ||
                (getDirection() == Movable.DirectionConstants.EAST && this.getX() > getParentWidth())) {
            destroy();
        }
    }                 // Move entire hord
    public void changeDirection()       // Switch left/right
    private void dropDown()            // Move hord downward
    public void increaseSpeed()        // Progressive difficulty

    // State Management
    public boolean isGameOver()        // Check if aliens reached bottom
    public void alienDestroyed(int row, int col) // Handle alien death

    // Collision & Targeting
    public Alien getLowestAlienInColumn(int col) // For projectile targeting

    // Wave Management
    public void resetTheHord()         // New wave, lower position
    public boolean allAliensDestroyed() // Check if wave complete

    // Animation
    public void animateAliens()        // Call toggleImage() on all

    public Alien[][] getAliens() {
        return aliens;
    }

    public void setAliens(Alien[][] aliens) {
        this.aliens = aliens;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getLastDirection() {
        return lastDirection;
    }

    public void setLastDirection(double lastDirection) {
        this.lastDirection = lastDirection;
    }

    public int getNumLiving() {
        return numLiving;
    }

    public void setNumLiving(int numLiving) {
        this.numLiving = numLiving;
    }

    public boolean isAtEdge() {
        return atEdge;
    }

    public void setAtEdge(boolean atEdge) {
        this.atEdge = atEdge;
    }

    public ActionPane getActionPane() {
        return actionPane;
    }

    public void setActionPane(ActionPane actionPane) {
        this.actionPane = actionPane;
    }

    public Image getAlienSprites() {
        return alienSprites;
    }

    public void setAlienSprites(Image alienSprites) {
        this.alienSprites = alienSprites;
    }
}

 */