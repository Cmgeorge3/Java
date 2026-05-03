import java.util.Comparator;

public class ValueComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        //compares by value
        return card1.getValue().compareTo(card2.getValue());
    }


}
