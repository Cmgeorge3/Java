import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.GridPane;


public class Connect4Grid extends GridPane {
    private char turn = 'r';


    public void ConnectFourGrid() {
        CFListener cfl = new CFListener();
        for (int i = 0; i<6; i++){
            for (int j=0; j<7; j++){
                Connect4Pane cfp = new Connect4Pane();
                this.add(cfp, j, i);
            }
        }
    }

    private class CFListener implements EventHandler<MouseEvent> {
    public void handle(MouseEvent event){
        Connect4Pane cfp = (Connect4Pane) event.getSource();
        //returns Object; must explicitly call it
        cfp.setColor(turn);
        if (turn == 'r') {
            turn = 'y';
        }
        }
    }
}
