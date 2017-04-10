package testPackage.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by bajmd on 04/04/17.
 * Problem Statement: Remove duplicates from an unordered linkedlist.
 */
public class RemoveDuplicates {
    void removeDuplicates (LinkedList list) {
        // With Hashmap
       /* Map<Integer, Boolean> listMap = new HashMap<Integer, Boolean>();
        Node current = list.head;
        Node next;
        listMap.put(current.data, true);
        while (current.getNext() != null) {
            next = current.getNext();
            if (listMap.containsKey(next.data)) {
                current.setNext(next.getNext());
            }
            else {
                listMap.put(next.data, true);
                current = current.getNext();
            }
        }
        list.display();*/

        // Without Hashmap
        Node prev = list.head;
        Node current = prev.getNext();
        while (current != null) {
            Node runner = list.head;
            while (runner != current) {
                if (runner.data == current.data) {
                    prev.setNext(current.getNext());
                    current = current.next;
                    break;
                }
                runner = runner.next;
            }
            if(runner == current) {
                current = current.next;
            }
        }
        list.display();
    }
    public static void main (String args[]) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(4);
        list.insertAtEnd(4);
        list.insertAtEnd(4);
        list.insertAtEnd(4);
        list.insertAtEnd(4);
        list.display();

        RemoveDuplicates duplicates = new RemoveDuplicates();
        duplicates.removeDuplicates(list);
    }
}
