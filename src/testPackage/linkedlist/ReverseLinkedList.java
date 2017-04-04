package testPackage.linkedlist;

/**
 * Created by bajmd on 23/03/17.
 * Problem Statement: Reverse a linkedlist.
 */
public class ReverseLinkedList {
    public Node reverseList(LinkedList list) {
        Node current = list.head;
        Node prev = null;

        while (current != null) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        list.head = prev;
        return prev;
    }
    public static void main (String args[]) {
        ReverseLinkedList reversedlist = new ReverseLinkedList();

        LinkedList list = new LinkedList();
        list.insertAtStart(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.display();

        reversedlist.reverseList(list);
        list.display();
    }
}
