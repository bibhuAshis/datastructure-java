package testPackage.Practice;

import java.util.Stack;

/**
 * Created by bajmd on 08/07/17.
 */
public class StackSorter {
    public static void main (String args[]) {
        StackSorter sorter = new StackSorter();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        Stack<Integer> newStack = sorter.sortStack(stack);
        System.out.println(newStack.peek());
    }

    public Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            if (sortedStack.isEmpty())
                sortedStack.push(stack.pop());
            else {
                int temp = stack.pop();
                while (!sortedStack.isEmpty() && temp < sortedStack.peek()) {
                    stack.push(sortedStack.pop());
                }
                sortedStack.push(temp);
            }
        }
        return sortedStack;
    }
}
