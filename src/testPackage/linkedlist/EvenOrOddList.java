package testPackage.linkedlist;

/**
 * Created by bajmd on 27/03/17. Problem Statement: Find the given linkedlist length is even or odd.
 */
public class EvenOrOddList {
	void findEvenorOdd(LinkedList list) {
		Node fast = list.head;
		if(fast.next == null) {
			System.out.println("The list is odd");
		}
		else {
			while(fast.next != null) {
				fast = fast.next.next;
				if(fast == null) {
					System.out.println("The list is even");
					return;
				}
				else if(fast.next == null) {
					System.out.println("The list is odd");
					return;
				}
			}
		}
	}

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.insertAtStart(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		// list.insertAtEnd(5);

		EvenOrOddList finder = new EvenOrOddList();
		finder.findEvenorOdd(list);
	}
}
