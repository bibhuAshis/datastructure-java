package testPackage.queue;

import testPackage.stack.Stack;

/**
 * Created by bjena on 1/18/2017.
 * Problem Statement: Given a queue and an integer k, how do you reverse the order of the first k elements of the queue,
 * leaving the other elements in the same relative order?
 */
class Shuffle {
    Stack stack = new Stack();
    public void shuffleQueue(Queue queue, int k) {
        for (int i=0; i<k; i++) {
            stack.push(queue.dequeue());
        }
        while (stack.top != -1) {
            queue.enqueue(stack.pop());
        }
        while (queue.front != 0) {
            queue.enqueue(queue.dequeue());
        }
        queue.print();
    }
}
public class QueueShuffle {
    public static void main (String args[]) {
        Queue queue = new Queue();
        int k = 3;
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Shuffle shuffler = new Shuffle();
        shuffler.shuffleQueue(queue, k);
    }
}
