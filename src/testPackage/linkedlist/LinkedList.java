package testPackage.linkedlist;

/**
 * Created by bajmd on 20/12/16.
 * Problem Statement: Write implementation of linkedlist ADT.
 */

class Node {
    protected int data;
    protected Node next;

    // Constructor
    public Node(int d, Node n)
    {
        this.data = d;
        this.next = n;
    }

    public Node()
    {
        this.data = 0;
        this.next = null;
    }

    // Function to set next to next Node
    public void setNext(Node n)
    {
        this.next = n;
    }

    // Function to set data to current Node
    public void setData(int d)
    {
        this.data = d;
    }

    // Function to get next to next node
    public Node getNext()
    {
        return this.next;
    }

    // Function to get data from current Node
    public int getData()
    {
        return this.data;
    }

}

class LinkedList {
    public int size;
    protected Node head;
    protected Node end;

    // Constructor
    public LinkedList()
    {
        head = null;
        end = null;
        size = 0;
    }

    // Function to insert an element at beginning
    public void insertAtStart(int val)
    {
        Node nptr = new Node(val, null);
        size++ ;
        if(head == null)
        {
            head = nptr;
            end = head;
        }
        else
        {
            nptr.setNext(head);
            head = nptr;
        }
    }

    // Function to insert an element at end
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val,null);
        size++ ;
        if(head == null)
        {
            head = nptr;
            end = head;
        }
        else
        {
            end.setNext(nptr);
            end = nptr;
        }
    }

    // Function to insert an element at position
    public void insertAtPos(int val , int pos)
    {
        /*Node nptr = new Node(val, null);
        Node ptr = head;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getNext() ;
                ptr.setNext(nptr);
                nptr.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size++ ;*/
        if (pos == 1) {
            insertAtStart(val);
        }
        else if(pos > size+1 || pos < 1) {
            System.out.println("Invalid Position");
        }
        else {
            Node newptr = new Node(val, null);
            Node tmp = head;
            size++;
            for (int i=1; i<pos-1; i++) {
                tmp = tmp.getNext();
            }
            newptr.setNext(tmp.getNext());
            tmp.setNext(newptr);
        }
    }

    // Function to delete an element at beginning
    public void deleteAtStart()
    {
        head = head.getNext();
        size--;
    }

    // Function to delete an element at end
    public void deleteAtEnd()
    {
        /*Node s = head;
        Node t = head;
        while (s != end)
        {
            t = s;
            s = s.getNext();
        }
        end = t;
        end.setNext(null);
        size --;*/
        Node tmp = head;
        while (tmp.getNext() != end) {
            tmp = tmp.next;
        }
        end = tmp;
        tmp.setNext(null);
        size--;
    }

    // Function to delete an element at position
    public void deleteAtPos(int pos)
    {
        /*Node ptr = head;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getNext();
                tmp = tmp.getNext();
                ptr.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size-- ;*/
        if (pos == 1) {
            deleteAtStart();
        }
        else if(pos == size) {
            deleteAtEnd();
        }
        else if(pos > size || pos < 1) {
            System.out.println("Invalid Position");
        }
        else {
            Node tmp = head;
            for (int i=1; i<pos-1; i++) {
                tmp = tmp.next;
            }
            tmp.setNext(tmp.next.getNext());
            size--;
        }
    }

    // Function to display elements
    public void display()
    {
        System.out.print("The Singly Linked List is: ");
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
            Node ptr = head;
            System.out.print(head.getData()+ "->");
            ptr = head.getNext();
            while (ptr.getNext() != null)
            {
                System.out.print(ptr.getData()+ "->");
                ptr = ptr.getNext();
            }
            System.out.print(ptr.getData()+ "\n");
        }
    }

    public static void main (String args[]) {
        LinkedList singlyLinkedList = new LinkedList();
        singlyLinkedList.display();
        singlyLinkedList.insertAtStart(2);
        singlyLinkedList.display();
        singlyLinkedList.insertAtEnd(5);
        singlyLinkedList.display();
        singlyLinkedList.insertAtPos(4,2);
        singlyLinkedList.display();
        singlyLinkedList.insertAtStart(1);
        singlyLinkedList.display();
        singlyLinkedList.insertAtPos(3, 3);
        singlyLinkedList.display();
        singlyLinkedList.deleteAtStart();
        singlyLinkedList.display();
        singlyLinkedList.deleteAtEnd();
        singlyLinkedList.display();
        singlyLinkedList.deleteAtPos(2);
        singlyLinkedList.display();
        singlyLinkedList.insertAtPos(3,4);
        singlyLinkedList.display();
    }
}
