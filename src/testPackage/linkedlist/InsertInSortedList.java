package testPackage.linkedlist;

/**
 * Created by bajmd on 23/03/17.
 * Problem Statement: Insert a node in a sorted linkedlist.
 */
public class InsertInSortedList {
    void insertInSortedList (LinkedList list, Node newNode) {
        Node current = list.head;
        if (current.getData() > newNode.data) {
            list.insertAtStart(newNode.data);
        }
        else {
            while (current.getNext() != null && current.next.getData() < newNode.data) {
                current = current.getNext();
            }
            Node temp = current.getNext();
            current.setNext(newNode);
            newNode.setNext(temp);
        }
    }
    public static void main (String args[]) {
        InsertInSortedList insertedList = new InsertInSortedList();

        Node insertNode = new Node(2,null);

        LinkedList sortedList = new LinkedList();
        sortedList.insertAtStart(1);
        sortedList.insertAtEnd(3);
        sortedList.insertAtEnd(4);
        sortedList.insertAtEnd(5);
        sortedList.display();

        insertedList.insertInSortedList(sortedList, insertNode);
        sortedList.display();
    }
}
