package testPackage.queue;
import testPackage.stack.Stack;

/**
 * Created by bajmd on 1/11/2017.
 * Problem Statement: Give an algorithm for reversing a queue.
 */
class ReversingQueue {
    Stack stack = new Stack();
    public void reverse(Queue inputQueue) {
        while (inputQueue.getFront() != inputQueue.getRear()) {
            stack.push(inputQueue.dequeue());
        }
        while (stack.getTop() != -1) {
            inputQueue.enqueue(stack.pop());
        }
    }
}
public class QueueReverser {
    public static void main (String args[]) {
        Queue inputQueue = new Queue();
        inputQueue.enqueue(1);
        inputQueue.enqueue(2);
        inputQueue.enqueue(3);
        inputQueue.enqueue(4);
        inputQueue.enqueue(5);
        inputQueue.print();
        ReversingQueue reverse = new ReversingQueue();
        reverse.reverse(inputQueue);
        inputQueue.print();
    }
}
