package testPackage.stack;
import java.util.*;


/**
 * Created by bajmd on 12/31/16.
 * Problem Statement: Give an algorithm for sorting a stack in ascending order.
 */

// Sorting Class
class AscendingSorter{
    Stack sortedStack = new Stack(5);
    public void sortStack(Stack inputStack) {
        while (!inputStack.isEmpty()) {
            int temp = inputStack.pop();
            while (!sortedStack.isEmpty() && temp < sortedStack.peek())
                inputStack.push(sortedStack.pop());
            sortedStack.push(temp);
        }
        sortedStack.print();
    }
}

// Main Class
public class Ascending {
    public static void main(String args[]) {
        Stack inputStack = new Stack(5);
        inputStack.push(5);
        inputStack.push(1);
        inputStack.push(3);
        inputStack.push(2);
        inputStack.push(4);
        AscendingSorter sort = new AscendingSorter();
        sort.sortStack(inputStack);

    }
}
