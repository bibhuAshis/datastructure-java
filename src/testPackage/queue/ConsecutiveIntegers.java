package testPackage.queue;

import testPackage.stack.Stack;

/**
 * Created by bjena on 1/17/2017.
 */
class ConsecutiveChecker {
    Queue queue = new Queue();
    boolean consecutive = true;
    public void checkConsecutiveness(Stack stack) {
        while (stack.top != -1) {
            queue.enqueue(stack.pop());
        }
        queue.print();
        while (queue.front <= queue.rear) {
            stack.push(queue.dequeue());
        }
        stack.print();
        while (stack.top != -1) {
            int m = stack.pop();
            if (stack.top != -1) {
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
        Stack stack = new Stack();
        stack.push(4);
        stack.push(5);
        stack.push(-2);
        stack.push(-3);
        stack.push(11);
        stack.print();
        ConsecutiveChecker checker = new ConsecutiveChecker();
        checker.checkConsecutiveness(stack);
    }
}
