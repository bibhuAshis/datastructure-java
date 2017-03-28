package testPackage.linkedlist;

/**
 * Created by bajmd on 28/03/17.
 */
public class PalindromeList {
    void findPalindrome (LinkedList list) {
        boolean palindrome = true;

        // Find middle of linkedlist
        MiddleofLinkedList middleList = new MiddleofLinkedList();
        Node middle = middleList.findMiddle(list);

        // Reverse the list after middle
        Node current = middle.next;
        Node prev = null;
        while (current != null) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        // Check whether first half is equal to second half
        while(list.head != middle.next && prev != null) {
            if (list.head.data != prev.data) {
                palindrome = false;
            }
            list.head = list.head.next;
            prev = prev.next;
        }

        if (palindrome) {
            System.out.println("The list is palindrome");
        }
        else {
            System.out.println("The list is not palindrome");
        }
    }
    public static void main (String args[]) {
        LinkedList list = new LinkedList();
        list.insertAtStart(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(2);
        list.insertAtEnd(1);
        //list.insertAtEnd(2);

        PalindromeList palindrome = new PalindromeList();
        palindrome.findPalindrome(list);
    }
}
