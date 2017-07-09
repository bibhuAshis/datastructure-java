package testPackage.linkedlist;

/**
 * Created by bajmd on 04/04/17.
 * Problem Statement: Given two linkedlists representing two non negative numbers, add the two numbers an return as a linkedlist.
 */
public class AddNumbers {
    void addNumbers(LinkedList list1, LinkedList list2) {
        Node num1 = list1.head;
        Node num2 = list2.head;
        LinkedList list3 = new LinkedList();
        int sum =0, carry = 0;
        while (num1 != null && num2 != null) {
            sum = num1.data + num2.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            list3.insertAtEnd(sum);
            num1 = num1.next;
            num2 = num2.next;
        }
        while (num1 != null)
        {
            sum = num1.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            list3.insertAtEnd(sum);
            num1 = num1.next;
        }
        while (num2 != null)
        {
            sum = num2.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            list3.insertAtEnd(sum);
            num2 = num2.next;
        }
        if (carry != 0) {
            list3.insertAtEnd(carry);
        }
        list3.display();
    }
    public static void main (String args[]) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.insertAtEnd(1);
        //list1.insertAtEnd(1);
        //list1.insertAtEnd(5);
        list1.display();
        list2.insertAtEnd(9);
        list2.insertAtEnd(9);
        //list2.insertAtEnd(2);
        list2.display();

        AddNumbers numbers = new AddNumbers();
        numbers.addNumbers(list1, list2);
    }
}
