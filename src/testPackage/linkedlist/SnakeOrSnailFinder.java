package testPackage.linkedlist;

/**
 * Created by bajmd on 12/02/17.
 * Problem Statement: Check if the given linked list is a snake (it is null terminated) or a snail (it has a loop).
 */
class LoopCreator {
    public void createLoop (LinkedList list, int n) {
        Node pTemp = list.head;
        for (int i=0; i<n; i++) {
            pTemp = pTemp.getNext();
        }
        list.end.next = pTemp;
    }
}
class LoopFinder {
    public void findLoop (LinkedList loopedList) {
        Node pSlow = loopedList.head;
        Node pFast = loopedList.head;
        boolean snake = true;
        while (pFast != null && pFast.getNext() != null) {
            pSlow = pSlow.getNext();
            pFast = pFast.getNext().getNext();
            if (pSlow == pFast){
                System.out.println("The list is a snail");
                snake = false;
                break;
            }
        }
        if (snake) {
            System.out.println("The list is a snake");
        }
    }
}
public class SnakeOrSnailFinder {
    public static void main (String args[]) {
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
        //LoopCreator loopingList = new LoopCreator();
        //loopingList.createLoop(list, 2);

        // Find if the list has loop
        LoopFinder loopedList = new LoopFinder();
        loopedList.findLoop(list);
    }
}
