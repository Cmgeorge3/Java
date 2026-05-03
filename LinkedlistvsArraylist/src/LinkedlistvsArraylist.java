import java.util.ArrayList;
import java.util.LinkedList;
//Computer are fast enough nowadays to where small lists won't be affect by the ty[ing
public class LinkedlistvsArraylist {
    public static void main(String[] args) {
//ideal for adding/removing
//must go through linked to find specific element
// When adding items only a small piece of the list is shifted(pointers and prev addresses

        LinkedList<String> namesLinkedList = new LinkedList<>();
        namesLinkedList.add("John");
        namesLinkedList.add("Cj");
        namesLinkedList.add("Gerald");
        namesLinkedList.add("Javi");

        System.out.println(namesLinkedList.get(2));
        namesLinkedList.add(1, "Craig");
        namesLinkedList.push("Ben");//push and pop to mimic a Stack
        namesLinkedList.pop();

        //offer and poll to mimic a Que
        namesLinkedList.offer("womp");//appends to the end
        namesLinkedList.poll();//deletes first element

        System.out.println(namesLinkedList.indexOf("Javi"));
        System.out.println(namesLinkedList.peekFirst());//.addFirst("A") and .addLast("A")
        System.out.println(namesLinkedList.peekLast());
        String last = namesLinkedList.removeLast();//can be assigned to a variable(removes womp)
        System.out.println(namesLinkedList);
//perfect for getting data
//Dynamic resizing takes time and resources
        //random access point and can immedietly get the element (faster than Linked list)
        //must create a new larger array then insert new element when adding things
        ArrayList<String> namesArrayList = new ArrayList<>();
        namesArrayList.add("John");
        namesArrayList.add("Cj");
        namesArrayList.add("Gerald");
        namesArrayList.add("Javi");
        System.out.println(namesArrayList.get(2));
        namesArrayList.add(1, "Craig");


    }
}
