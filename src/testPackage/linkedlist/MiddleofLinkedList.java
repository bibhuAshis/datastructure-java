package testPackage.linkedlist;

/**
 * Created by bajmd on 23/03/17.
 */
public class MiddleofLinkedList {
    void findMiddle (LinkedList list) {
        Node slow = list.head;
        Node fast = list.head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle of the list is: " +slow.data);
    }
    public static void main (String args[]) {
        MiddleofLinkedList middle = new MiddleofLinkedList();

        LinkedList list = new LinkedList();
        list.insertAtStart(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        //list.insertAtEnd(5);
        //list.insertAtEnd(6);

        middle.findMiddle(list);
    }
}
