public class Textbook {

    private String title;
    private String publisher;
    private int edition;

    // Default constructor
    public Textbook() {
        title = "";
        publisher = "";
        edition = 0;
    }

    public Textbook(String title, String publisher, int edition){
        this.title = title;
        this.publisher = publisher;
        this.edition = edition;
    }

    @Override
    public String toString() {
        String lineSeparator = System.getProperty("line.separator");
        return title + lineSeparator + publisher + lineSeparator + edition;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
    public static void main(String[] args) {
        Textbook t1 = new Textbook();
        Textbook t2 = new Textbook("unmasking AI", "Newyork Times", 3);

        System.out.println(t1);
        System.out.println(t2);
    }
}
