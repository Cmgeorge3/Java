import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class TicTacToePane extends GridPane {
    private char turn = 'X';

    public TicTacToePane() {
        this.setGridLinesVisible(true);//show grid outlines
        BoardPane bp;
        BoardPaneHandler boardPaneHandler = new BoardPaneHandler();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bp = new BoardPane();
                bp.setPrefSize(100, 100);
                bp.setOnMouseClicked(boardPaneHandler);
                this.add(bp, j, i);//add coloumn before Rows
            }
        }
    }

    public char getTurn() {
        return this.turn;
    }

    public void setTurn(char turn) {
        this.turn = turn;
    }

    //conditional statements look off
    public void toggleTurn() {
        if (turn == 'X')
            turn = 'O';
        else
            turn = 'X';
    }
//inner class that is private so it only happens
    private class BoardPaneHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            BoardPane bp = (BoardPane) event.getSource();//identify which pane was clicked
//only affects empty squares
            if (bp.getValue() == ' ') {
                bp.setValue(turn);
                toggleTurn();
            }
        }
    }
}


