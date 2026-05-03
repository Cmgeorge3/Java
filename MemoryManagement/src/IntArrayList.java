
public class IntArrayList {
    ListNode head;
    ListNode tail;
    private int count;


    public IntArrayList() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(int value) {

        ListNode node = new ListNode();
        node.setData(value);
        node.setNext(null);

        //check for empty list
        if (tail == null){
            head = node;
            tail = node;
        }
        else {//add to end of a populated list
            tail.setNext(node);
            tail = node;
        }
        count++;
    }

    public void add(int index, int value) {
        ListNode node = new ListNode();
        node.setData(value);
        if (index == 0) {
            node.setNext(head);
            head = node;


        } else {
            ListNode ptr = locate(index - 1);
            node = new ListNode();
            node.setData(value);
            ptr.insertAfter(node);
        }
        count++;
        if (count == 1){
            tail = head;
        }
    }

    private ListNode locate(int index){
        ListNode ptr = head;
        if (index >= count) {
            return null;
        }
        else {
            for (int i=0; i<index; i++) {
                ptr = ptr.getNext();

            }
        }
        return ptr;
    }
    public int size(){
        return count;
    }
    //Trading in the value of an ArrayList's for
    public int get(int index) {
        ListNode pointer = head;
        for (int i=0; i < index; i++){
            pointer = pointer.getNext();
        }
        return pointer.getData();//returns data at this locations
    }
}
