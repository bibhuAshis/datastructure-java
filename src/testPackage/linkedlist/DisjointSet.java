package testPackage.linkedlist;

/**
 * Created by bajmd on 08/05/17.
 */
public class DisjointSet {
    public static void main(String args[]) {
        DisjointSet obj = new DisjointSet();
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(4);
        list.insertAtEnd(3);
        list.insertAtEnd(6);
        list.insertAtEnd(7);

        list.display();
        list = obj.joinSets(list.head);
        list.display();
    }

    LinkedList joinSets(Node head) {
        LinkedList newList = new LinkedList();
        Node l1 = head;
        while (l1.getNext() != null && l1.getData() < l1.next.getData()) {
            l1 = l1.getNext();
        }
        Node l2 = l1.getNext();
        while (head != null && l2 != null ) {
            if (head == l1.getNext()) {
                newList.insertAtEnd(l2.data);
                l2 = l2.getNext();
            }
            else if (l2 == null) {
                newList.insertAtEnd(head.data);
                head = head.getNext();
            }
            else if (head.getData() <= l2.getData()) {
                newList.insertAtEnd(head.data);
                head = head.getNext();
            }
            else {
                newList.insertAtEnd(l2.getData());
                l2 = l2.getNext();
            }
        }
        return newList;
    }
}
