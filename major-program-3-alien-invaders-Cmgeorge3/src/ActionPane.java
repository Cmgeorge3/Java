//Christopher George
//11/19/2025
//Comp 167-02
//ActionPane class for space Invaders
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ActionPane extends Pane {
    private ImageView imageView;
    private Rectangle2D viewport;

    public ActionPane() {
        this.setPrefSize(550, 60);
       // this.setStyle("-fx-background-color: black;");

        try {
            Image image = new Image(new FileInputStream("images/space4.jpg"));
            imageView = new ImageView(image);
                    this.getChildren().add(imageView);
        }
        catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }

        viewport = new Rectangle2D(19,17, 20, 30);
        this.setViewport(viewport);
    }

    public void setViewport(Rectangle2D viewport) {
        this.viewport = viewport;
    }

    public Rectangle2D getViewport() {
        return viewport;
    }
}