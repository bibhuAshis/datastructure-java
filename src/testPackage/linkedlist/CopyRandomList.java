package testPackage.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajmd on 29/03/17.
 */
class RandomNode {
    protected int data;
    protected RandomNode next;
    protected RandomNode random;

    // Constructor
    public RandomNode (int value, RandomNode ptr1, RandomNode ptr2) {
        data = value;
        next = ptr1;
        random = ptr2;
    }

    // Set data
    public void setData(int data) {
        this.data = data;
    }

    // Set next
    public void setNext (RandomNode next) {
        this.next = next;
    }

    // Set random
    public void setRandom (RandomNode random) {
        this.random = random;
    }

    // Get data
    public int getData() {
        return this.data;
    }

    // Get next
    public RandomNode getNext() {
        return this.next;
    }

    // Get random
    public RandomNode getRandom() {
        return this.random;
    }
}

class RandomList {
    RandomNode head=null;
    RandomNode end = null;
    int size = 0;

    // Insert at start
    public void insertAtStart(int value) {
        RandomNode newptr = new RandomNode(value, null, null);
        size++;
        if (head == null) {
            head = newptr;
            end = head;
        }
        else {
            newptr.setNext(head);
            head = newptr;
        }
    }

    // Insert at end
    public void insertAtEnd(int value) {
        RandomNode newptr = new RandomNode(value, null, null);
        size++;
        if (head == null) {
            head = newptr;
            end = head;
        }
        else {
            end.setNext(newptr);
            end = newptr;
        }
    }

    // Insert at position
    public void insertAtPosition(int value, int pos) {
        if (pos == 1) {
            insertAtStart(value);
        }
        else if(pos > size+1 || pos < 1) {
            System.out.println("Invalid Position");
        }
        else {
            RandomNode newptr = new RandomNode(value, null, null);
            RandomNode tmp = head;
            size++;
            for (int i=1; i<pos-1; i++) {
                tmp = tmp.getNext();
            }
            newptr.setNext(tmp.getNext());
            tmp.setNext(newptr);
        }
    }

    // Delete from start
    public void deleteFromStart() {
        head = head.next;
        size--;
    }

    // Delete from end
    public void deleteFromEnd() {
        RandomNode tmp = head;
        while (tmp.getNext() != end) {
            tmp = tmp.next;
        }
        end = tmp;
        tmp.setNext(null);
        size--;
    }

    // Delete from position
    public void deleteFromPosition(int pos) {
        if (pos == 1) {
            deleteFromStart();
        }
        else if(pos == size) {
            deleteFromEnd();
        }
        else if(pos > size || pos < 1) {
            System.out.println("Invalid Position");
        }
        else {
            RandomNode tmp = head;
            for (int i=1; i<pos-1; i++) {
                tmp = tmp.next;
            }
            tmp.setNext(tmp.next.getNext());
            size--;
        }
    }

    // Set random
    public void setRandom(int pos1, int pos2) {
        RandomNode tmp1 = head;
        RandomNode tmp2 = head;
        for (int i=1; i<pos1; i++) {
            tmp1 = tmp1.next;
        }
        for (int j=1; j<pos2; j++) {
            tmp2 = tmp2.next;
        }
        tmp1.setRandom(tmp2);
    }

    // Display
    public void display() {
        System.out.println("The Singly Linked List: ");
        if (size == 0)
        {
            System.out.println("Empty");
            return;
        }
        else if (head.getNext() == null)
        {
            System.out.println(head.getData());
            return;
        }
        else {
            System.out.println("Next Pointers: ");
            RandomNode ptr = head;
            System.out.print(head.getData()+ "->");
            ptr = head.getNext();
            while (ptr.getNext() != null)
            {
                System.out.print(ptr.getData()+ "->");
                ptr = ptr.getNext();
            }
            System.out.print(ptr.getData());

            System.out.print("\n");
            System.out.println("Random Pointers: ");
            RandomNode ptr1 = head;
            while (ptr1 != null) {
                System.out.println(ptr1.getData()+ "->" +ptr1.random.getData());
                ptr1 = ptr1.getNext();
            }
        }
    }
}

public class CopyRandomList {
    void copyRandom(RandomList randomList) {
        Map<RandomNode, RandomNode> listMap = new HashMap<RandomNode,RandomNode>();
        RandomNode newptr = randomList.head;
        RandomNode copyptr;

        // Create hash table entries
        while(newptr != null) {
            copyptr = new RandomNode(newptr.data, null, null);
            listMap.put(newptr, copyptr);
            newptr = newptr.next;
        }

        // Set next and random pointers for copied node
        newptr = randomList.head;
        while (newptr != null) {
            copyptr = listMap.get(newptr);
            copyptr.setNext(listMap.get(newptr.getNext()));
            copyptr.setRandom(listMap.get(newptr.getRandom()));
            newptr = newptr.next;
        }

        // Print the copied list
        System.out.println("The Singly Linked List: ");
        System.out.println("Next Pointers: ");
        RandomNode ptr = listMap.get(randomList.head);
        System.out.print(ptr.getData()+ "->");
        ptr = ptr.next;
        while (ptr.getNext() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData());

        System.out.print("\n");
        System.out.println("Random Pointers: ");
        RandomNode ptr1 = listMap.get(randomList.head);
        while (ptr1 != null) {
            System.out.println(ptr1.getData() + "->" + ptr1.random.getData());
            ptr1 = ptr1.getNext();
        }
        //return listMap.get(randomList.head);
    }
    public static void main (String args[]) {
        RandomList randomList = new RandomList();
        randomList.insertAtStart(1);
        randomList.insertAtEnd(2);
        randomList.insertAtEnd(3);
        randomList.insertAtEnd(4);
        randomList.setRandom(1,3);
        randomList.setRandom(2,1);
        randomList.setRandom(3,4);
        randomList.setRandom(4,2);
        randomList.display();

        CopyRandomList list = new CopyRandomList();
        list.copyRandom(randomList);
    }
}
