import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class SpriteSheetViewer extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load your sprite sheet
            Image spriteSheet = new Image(new FileInputStream("images/alienspritesheet.png"));
            ImageView imageView = new ImageView(spriteSheet);

            // Display the entire image
            imageView.setFitWidth(spriteSheet.getWidth() * 2); // Zoom 2x
            imageView.setFitHeight(spriteSheet.getHeight() * 2);
            imageView.setPreserveRatio(false);

            StackPane root = new StackPane();
            root.getChildren().add(imageView);

            Scene scene = new Scene(root, spriteSheet.getWidth() * 2, spriteSheet.getHeight() * 2);
            primaryStage.setTitle("Sprite Sheet Viewer - Click to get coordinates");
            primaryStage.setScene(scene);

            // Click to get coordinates
            imageView.setOnMouseClicked(event -> {
                double x = event.getX() / 2; // Divide by zoom factor
                double y = event.getY() / 2;
                System.out.printf("Clicked at: X=%.0f, Y=%.0f%n", x, y);
                System.out.printf("Rectangle2D: new Rectangle2D(%.0f, %.0f, width, height)%n", x, y);
            });

            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}