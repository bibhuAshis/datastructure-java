package testPackage.queue;

/**
 * Created by bjena on 1/17/2017.
 * Problem Statement: Given a queue of integers, rearrange the elements by interleaving the first half of the list with
 * second half of the list.
 */
class Rearrange {
    Queue tempQueue = new Queue();
    public void rearrangeQueue(Queue queue) {
        int m = queue.getRear() + 1;
        for (int i=0; i<m / 2; i++) {
            tempQueue.enqueue(queue.dequeue());
        }
        while (queue.getFront() < m && tempQueue.getFront() < m/2) {
            queue.enqueue(tempQueue.dequeue());
            queue.enqueue(queue.dequeue());
        }
        queue.print();
    }
}
public class QueueRearrange {
    public static void main (String args[]) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        Rearrange rearranger = new Rearrange();
        rearranger.rearrangeQueue(queue);
    }
}
