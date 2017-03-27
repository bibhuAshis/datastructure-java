package testPackage.linkedlist;

/**
 * Created by bajmd on 27/03/17.
 */
public class MergeSortedLists {
    void mergeLists (LinkedList list1, LinkedList list2) {
        Node head1 = list1.head;
        Node head2 = list2.head;
        LinkedList mergedList = new LinkedList();
        while (head1 != null || head2!= null) {
            if (head1 == null) {
                mergedList.insertAtEnd(head2.data);
                head2 = head2.next;
            }
            else if(head2 == null) {
                mergedList.insertAtEnd(head1.data);
                head1 = head1.next;
            }
            else if (head1.data <= head2.data) {
                mergedList.insertAtEnd(head1.data);
                head1 = head1.next;
            }
            else {
                mergedList.insertAtEnd(head2.data);
                head2= head2.next;
            }
        }
        System.out.println("Merged list:");
        mergedList.display();
    }
    public static void main (String args[]) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.insertAtStart(1);
        list1.insertAtEnd(3);
        list1.insertAtEnd(5);
        list2.insertAtStart(2);
        list2.insertAtEnd(4);
        list2.insertAtEnd(6);

        list1.display();
        list2.display();

        MergeSortedLists sortedLists = new MergeSortedLists();
        sortedLists.mergeLists(list1, list2);
    }
 }
