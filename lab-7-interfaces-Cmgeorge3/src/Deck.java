import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

public class Deck{
    private ArrayList<Card> unoDeck;
    private Random random;

public Deck(){
    unoDeck = new ArrayList<>(76);
    random = new Random();
    createDeck();
}
public void createDeck(){
    unoDeck.add( new Card( "green", "0" ));
    for (int i=1; i<=9; i++) {
        unoDeck.add( new Card( "green", i+""));
        unoDeck.add( new Card( "green", i+""));
    }
    unoDeck.add( new Card( "red", "0" ));
    for (int i=1; i<=9; i++) {
        unoDeck.add( new Card( "red", i+"") );
        unoDeck.add( new Card( "red", i+"") );
    }
    unoDeck.add( new Card( "blue", "0" ));
    for (int i=1; i<=9; i++) {
        unoDeck.add( new Card( "blue", i+"") );
        unoDeck.add( new Card( "blue", i+"") );
    }
    unoDeck.add( new Card( "yellow", "0" ));
    for (int i=1; i<=9; i++) {
        unoDeck.add( new Card( "yellow", i+"") );
        unoDeck.add( new Card( "yellow", i+"") );
    }
}
    public void shuffle() {
        // Outer loop: repeat 7 times
        for (int outer = 0; outer < 7; outer++) {
            // Inner loop: go through all 76 cards
            for (int i = 0; i < unoDeck.size(); i++) {
                // Generate random index between 0 and 75
                int randomIndex = random.nextInt(unoDeck.size());

                // Swap current card with card at random position
                Card temp = unoDeck.get(i);
                unoDeck.set(i, unoDeck.get(randomIndex));
                unoDeck.set(randomIndex, temp);
            }
        }
    }
    public void sort(){
    Collections.sort(unoDeck);
}
    public void valueSort(){
    ValueComparator valueComparator = new ValueComparator();
        Collections.sort(unoDeck, valueComparator);
    }
@Override
public String toString(){
    String result = "";
    for (int i = 0; i < unoDeck.size(); i++) {
        result += unoDeck.get(i);

        if (i < unoDeck.size() - 1) {
            result += "|";
        }
        if ((i + 1) % 15 == 0) {
            result += "\n";
        }
    }
    return result;
    }
}

