package testPackage.queue;

/**
 * Created by bjena on 1/17/2017.
 * Problem Statement: Given a queue of integers, rearrange the elements by interleaving the first half of the list with
 * second half of the list.
 */
class Rearrange {
    Queue tempQueue = new Queue(5);
    public void rearrangeQueue(Queue queue) {
        int m = queue.getRear() + 1;
        for (int i=0; i<m / 2; i++) {
            tempQueue.enqueue(queue.dequeue());
        }
        int count1 = tempQueue.getRear()+1;
        int count2 = m - count1;
        int i=0, j=0;
        while (i < count1 && j < count2) {
            queue.enqueue(tempQueue.dequeue());
            queue.enqueue(queue.dequeue());
            i++; j++;
        }
        while (j<count2) {
            queue.enqueue(queue.dequeue());
            j++;
        }
        queue.print();
    }
}
public class QueueRearrange {
    public static void main (String args[]) {
        Queue queue = new Queue(10);
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        queue.enqueue(16);
        queue.enqueue(17);
        queue.enqueue(18);
        queue.enqueue(19);
        queue.enqueue(20);
        Rearrange rearranger = new Rearrange();
        rearranger.rearrangeQueue(queue);
    }
}
