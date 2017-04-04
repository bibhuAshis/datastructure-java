package testPackage.linkedlist;

/**
 * Created by bajmd on 23/03/17.
 * Problem Statement: Given two linkedlists which intersect at a point, find the intersection node.
 */
public class IntersectionofList {
    void findIntersection (LinkedList list1, LinkedList list2) {
        Node l1 = list1.head;
        Node l2 = list2.head;
        int length1 = 0;
        int length2 = 0;
        int diff;

        while (l1 != null) {
            l1 = l1.getNext();
            length1++;
        }

        while (l2 != null) {
            l2 = l2.getNext();
            length2++;
        }

        if (length1 > length2) {
            l1 = list1.head;
            l2 = list2.head;
            diff = length1 - length2;
        }
        else {
            l1 = list2.head;
            l2 = list1.head;
            diff = length2 - length1;
        }
        for (int i=0; i<diff; i++) {
            l1 = l1.getNext();
        }
        while (l1.data != l2.data) {
            l1 = l1.getNext();
            l2 = l2.getNext();
        }
        System.out.println("Merging point is: " +l1.getData());
    }
    public static void main(String args[]) {
        IntersectionofList intersection = new IntersectionofList();

        LinkedList list1 = new LinkedList();
        list1.insertAtStart(1);
        list1.insertAtEnd(2);
        //list1.insertAtEnd(5);
        list1.insertAtEnd(6);

        LinkedList list2 = new LinkedList();
        list2.insertAtStart(3);
        list2.insertAtEnd(4);
        list2.insertAtEnd(5);
        list2.end.next = list1.end;

        list1.insertAtEnd(7);
        list1.insertAtEnd(8);

        list1.display();
        list2.display();

        intersection.findIntersection(list1, list2);
    }
}
