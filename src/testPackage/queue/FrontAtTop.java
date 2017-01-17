package testPackage.queue;
import testPackage.stack.Stack;

/**
 * Created by bajmd on 1/16/2017.
 * Problem Statement: Given a queue containing n elements, transfer these items on to a stack so that front element of
 *  queue appears at the top of the stack and the order of all other items is preserved.
 */
class QueuetoStack {
    Stack stack = new Stack();
    public void movetoStack(Queue queue) {
        int temp = queue.dequeue();
        while (queue.front <= queue.rear) {
            stack.push(queue.dequeue());
        }
        stack.push(temp);
        stack.print();
    }
}
public class FrontAtTop {
    public static void main(String rgs[]) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        QueuetoStack transfer = new QueuetoStack();
        transfer.movetoStack(queue);
    }
}
