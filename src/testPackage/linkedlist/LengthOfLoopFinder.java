package testPackage.linkedlist;

/**
 * Created by bajmd on 12/02/17.
 * Problem Statement: Find the start node of the loop.
 */
class LengthFinder {
    public void findLength (LinkedList list) {
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
            pSlow = pSlow.next;
            int count = 1;
            while (pSlow != pFast) {
                pSlow = pSlow.next;
                count++;
            }
            System.out.println("The length of the loop is: " +count);
        }
    }

}
public class LengthOfLoopFinder {
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
        loopingList.createLoop(list, 2);

        // Find if the list has loop
        LengthFinder loopedList = new LengthFinder();
        loopedList.findLength(list);
    }
}
