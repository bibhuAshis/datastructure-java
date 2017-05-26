package testPackage.queue;

import testPackage.stack.Stack;

/**
 * Created by bjena on 1/17/2017.
 * Problem Statement: Given a stack of integers, how to check whether each successive pair of numbers in the stack is
 * consecutive or not. If the stack has odd number of elements, the element at the top is left out of a pair.
 */
class ConsecutiveChecker {
    Queue queue = new Queue(5);
    Stack stack1 = new Stack(5);
    boolean consecutive = true;
    public void checkConsecutiveness(Stack stack) {
        while (!stack.isEmpty()) {
            //queue.enqueue(stack.pop());
            stack1.push(stack.pop());
        }
        /*while (queue.getFront() <= queue.getRear()) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()) {
            int m = stack.pop();
            if (!stack.isEmpty()) {
                int n = stack.pop();
                if (Math.abs(m-n) != 1) {
                    consecutive = false;
                    break;
                }
            }
        }*/
        while (!stack1.isEmpty()) {
            int m = stack1.pop();
            if (!stack1.isEmpty()) {
                int n = stack1.pop();
                if (Math.abs(m-n) != 1) {
                    consecutive = false;
                    break;
                }
            }
        }
        if (consecutive) {
            System.out.println("Element Pairs are consecutive");
        }
        else {
            System.out.println("Element Pairs are not consecutive");
        }
    }
}
public class ConsecutiveIntegers {
    public static void main (String args[]) {
        Stack stack = new Stack(5);
        stack.push(4);
        stack.push(5);
        stack.push(-2);
        stack.push(-3);
        stack.push(-5);
        stack.print();
        ConsecutiveChecker checker = new ConsecutiveChecker();
        checker.checkConsecutiveness(stack);
    }
}
