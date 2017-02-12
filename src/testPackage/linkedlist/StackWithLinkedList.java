package testPackage.linkedlist;

/**
 * Created by bajmd on 12/02/17.
 * Problem Statement: Implementation stack using linkedlist.
 */
class LinkedListforStack {
    LinkedList list = new LinkedList();

    // Push
    public void push (int data) {
        System.out.println("The pushed element to the stack is: " +data );
        list.insertAtStart(data);
    }

    // Pop
    public void pop () {
        System.out.println("The popped element from the stack is: " +list.head.data );
        list.deleteAtStart();
    }

    // Peek
    public void peek () {
        System.out.println("The peek of the stack is: " +list.head.data );
    }
}

public class StackWithLinkedList {
    public static void main (String args[]) {
        LinkedListforStack stackWithList = new LinkedListforStack();
        stackWithList.push(1);
        stackWithList.push(2);
        stackWithList.push(3);
        stackWithList.push(4);
        stackWithList.push(5);
        stackWithList.peek();
        stackWithList.pop();
        stackWithList.peek();
    }
}
