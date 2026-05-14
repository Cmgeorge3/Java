import java.util.Scanner;


public class Main {

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);

        System.out.println("I need a noun");
        String noun = scnr.nextLine();

        System.out.println("Give me an adjective");
        String adjective = scnr.nextLine();


        System.out.println("I need a verb");
        String verb = scnr.nextLine();


        System.out.println("Adverb?");
        String Adverb = scnr.nextLine();

        System.out.println("Celebrity name?");
        String cName = scnr.nextLine();

        System.out.println("think of a random object");
        String ranOb = scnr.nextLine();

        System.out.println("Place");
        String place = scnr.nextLine();

        System.out.println("First animal that comes to mind");
        String animal = scnr.nextLine();

        System.out.println("One day, a " + noun + " was walking through " + place +
                " when it suddenly saw a " + adjective + " " + animal + " dancing in the street." +
                " Without warning, the animal began to " + verb + " " + Adverb + " while holding" +
                " a mysterious " + ranOb +" above its head." +
                "People everywhere stopped and stared as " + cName + " appeared out of " +
                "nowhere and shouted, “This is the greatest thing I’ve ever seen!" +
                " From that day on, the " + noun + " and the " + animal +" became legends of " + place + "," +
                " and nobody could look at a " + ranOb + " the same way ever again.");







        scnr.close();

    }
}


