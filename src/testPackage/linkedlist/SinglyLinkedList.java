package testPackage.linkedlist;

/**
 * Created by bajmd on 20/12/16.
 * Problem Statement: Write implementation of linkedlist ADT.
 */

class Node {
    int data;
    Node next;

    /*  Constructor  */
    public Node()
    {
        data = 0;
        next = null;
    }
    /*  Constructor  */
    public Node(int d, Node n)
    {
        data = d;
        next = n;
    }

    /*  Function to set next to next Node  */
    public void setNext(Node n)
    {
        next = n;
    }
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }
    /*  Function to get next to next node  */
    public Node getNext()
    {
        return next;
    }
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }

}

class LinkedList {
    int data;
    LinkedList head;
    LinkedList end;

}

public class SinglyLinkedList {

}
