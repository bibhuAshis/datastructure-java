package testPackage.queue;

import testPackage.stack.Stack;

/**
 * Created by bjena on 1/17/2017.
 * Problem Statement: Given a stack of integers, how to check whether each successive pair of numbers in the stack is
 * consecutive or not. If the stack has odd number of elements, the element at the top is left out of a pair.
 */
class ConsecutiveChecker {
    Queue queue = new Queue(5);
    boolean consecutive = true;
    public void checkConsecutiveness(Stack stack) {
        while (stack.getTop() != -1) {
            queue.enqueue(stack.pop());
        }
        queue.print();
        while (queue.getFront() <= queue.getRear()) {
            stack.push(queue.dequeue());
        }
        stack.print();
        while (stack.getTop() != -1) {
            int m = stack.pop();
            if (stack.getTop() != -1) {
                int n = stack.pop();
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
        stack.push(-4);
        stack.print();
        ConsecutiveChecker checker = new ConsecutiveChecker();
        checker.checkConsecutiveness(stack);
    }
}
