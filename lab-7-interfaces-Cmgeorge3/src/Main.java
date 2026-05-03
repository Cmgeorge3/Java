import javax.swing.JOptionPane;
public class Main {
    public static void main(String args[]) {
        Deck deck = new Deck();

        // Shuffle the cards
        deck.shuffle();

        // Output the shuffled cards to a JOptionPane
        JOptionPane.showMessageDialog(null,
                "SHUFFLED DECK:\n" + deck.toString(),
                "Shuffled Uno Cards",
                JOptionPane.INFORMATION_MESSAGE);

        // Sort the cards by color first then value
        deck.sort();

        // Output the sorted cards to a JOptionPane
        JOptionPane.showMessageDialog(null,
                "SORTED DECK:\n" + deck.toString(),
                "Sorted Uno Cards",
                JOptionPane.INFORMATION_MESSAGE);

        // Sort cards by value only
        deck.valueSort();

        //Output the cards sorted by value to a JOptionPane
        JOptionPane.showMessageDialog(null,
                "Value Sorted Deck:\n" + deck.toString(),
                "Value sorted Uno cards",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
