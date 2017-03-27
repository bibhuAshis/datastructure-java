package testPackage.linkedlist;

/**
 * Created by bajmd on 24/03/17.
 */
public class LinkedlistFromEnd {
    void printListfromEnd (Node head) {
        if (head == null)
            return;
        printListfromEnd(head.getNext());
        System.out.print(head.getData()+ "->");
    }
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insertAtStart(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.display();

        LinkedlistFromEnd printlist = new LinkedlistFromEnd();
        printlist.printListfromEnd(list.head);
    }
}
