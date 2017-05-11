package testPackage.linkedlist;

import java.util.ArrayList;

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
        Node newHead = obj.joinSets(list.head);
        while (newHead != null) {
            System.out.println(newHead.getData());
            newHead = newHead.getNext();
        }
    }

    Node joinSets(Node head) {
        //LinkedList newList = new LinkedList();
        Node l1 = head, l2 = head;
        Node l4 = new Node();
        while (l2.getNext() != null && l2.getData() < l2.next.getData()) {
            l2 = l2.getNext();
        }
        l2 = l2.getNext();
        Node l3 = l2;

        if (l2 == null || l1.getData() <= l2.getData()){
            head = l1;
            l4 = head;
            l1 = l1.getNext();
        }
        else {
            head = l2;
            l4 = head;
            l2 = l2.getNext();
        }

        while (l1 != null && l2 != null ) {
            if (l1 == l3) {
                head.setNext(l2);
                head = head.getNext();
                l2 = l2.getNext();
            }
            else if (l2 == null) {
                head.setNext(l1);
                head = head.getNext();
                l1 = l1.getNext();
            }
            else if (l1.getData() <= l2.getData()) {
                head.setNext(l1);
                head = head.getNext();
                l1 = l1.getNext();
            }
            else {
                head.setNext(l2);
                head = head.getNext();
                l2 = l2.getNext();
            }
        }
        head.setNext(null);
        return l4;
    }
}
