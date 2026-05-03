public class ListNode {
    private int data;
    private ListNode next; //node

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
    public void insertAfter(ListNode node) {
        ListNode tmp = this.next; //pointing at what is being referenced
        this.next = node; // referencing the new node
        node.next = tmp;//old node to
    }

    }
}
