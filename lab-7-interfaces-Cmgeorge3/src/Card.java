public class Card implements Comparable<Card>{
    private String color;
    private String value;

    public Card(){
        color = "";
        value = "";
    }

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return color + ", " + value;
    }
/* Color is compared alphabetical
if the colors are the same then the numbers are compared
 */
    @Override
    public int compareTo(Card o) {
        //compares color
        int colorComparison = this.color.compareTo(o.color);

        //if colors are the same then compare by values
        if (colorComparison == 0){
            return this.value.compareTo(o.value);
        }

        return colorComparison;
    }
}
