import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {
    BouncePane bp;

    public MainPane(){
        bp = new BouncePane();
        setCenter(bp);
    }
}
