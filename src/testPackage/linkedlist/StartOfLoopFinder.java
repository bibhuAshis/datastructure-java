package testPackage.linkedlist;

/**
 * Created by bajmd on 12/02/17.
 * Problem Statement: Find the start node of the loop.
 */
class StartNodeFinder {
    public void findStartNode (LinkedList list) {
        Node pSlow = list.head;
        Node pFast = list.head;
        boolean snake = true;
        while (pFast != null && pFast.getNext() != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if (pSlow == pFast){
                snake = false;
                break;
            }
        }
        if (!snake) {
            pSlow = list.head;
            while (pSlow != pFast) {
                pSlow = pSlow.next;
                pFast = pFast.next;
            }
            System.out.println("The start of loop is: " +pSlow.data);
        }
    }

}
public class StartOfLoopFinder {
    public static void main(String args[]) {
        // Create normal list
        LinkedList list = new LinkedList();
        list.insertAtStart(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtEnd(8);

        // Create looped list from normal list
        LoopCreator loopingList = new LoopCreator();
        loopingList.createLoop(list, 3);

        // Find if the list has loop
        StartNodeFinder loopedList = new StartNodeFinder();
        loopedList.findStartNode(list);
    }
}
