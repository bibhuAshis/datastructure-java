package testPackage.linkedlist;

/**
 * Created by bajmd on 27/03/17.
 */
public class ReverseInPairs {
    void reversePairs(LinkedList list) {
        Node tmp1 = null;
        Node tmp2 = null;
        while(list.head != null || list.head.next != null) {
            if (tmp1 != null) {
                tmp1.next.next = list.head.next;
            }
            tmp1 = list.head.next;
            list.head.next = tmp1.next.next;
            tmp1.next = list.head;
            if (tmp2 == null) {
                tmp2 = tmp1;
            }
            list.head = list.head.next;
        }
        list.head = tmp2;
    }
    public static void main (String args[]) {
        LinkedList list = new LinkedList();
        list.insertAtStart(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        //list.insertAtEnd(5);
        //list.insertAtEnd(6);
        list.display();

        ReverseInPairs reverse = new ReverseInPairs();
        reverse.reversePairs(list);
        list.display();
    }
}
