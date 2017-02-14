package testPackage.linkedlist;

/**
 * Created by bajmd on 12/02/17.
 * Problem Statement: Find the n'th node from end of a linkedlist where n < size of the list.
 */
class NodefromEnd {
    public void calculateNode (LinkedList list, int n) {
        Node pTemp = list.head;
        Node pNthNode = list.head;
        for (int i=0; i<n; i++) {
            pTemp = pTemp.next;
        }
        while (pTemp != null) {
            pNthNode = pNthNode.next;
            pTemp = pTemp.next;
        }
        System.out.format("The position %d node from end is: %d",+n, +pNthNode.data);
    }
}
public class NodeFinder {
    public static void main (String args[]) {
        LinkedList list = new LinkedList();
        list.insertAtStart(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.display();
        NodefromEnd nodeFinder = new NodefromEnd();
        nodeFinder.calculateNode(list, 4);
    }
}
