package testPackage.queue;

import testPackage.stack.Stack;

/**
 * Created by bajmd on 1/12/2017.
 * Problem Statement: How can you implement a queue using two stacks?
 */
class TwoStacks {
    Stack stack1 = new Stack(5);
    Stack stack2 = new Stack(5);

    // Enqueue
    public void enqueue(int input) {
        if (stack1.getTop() >= stack1.array.length-1) {
            System.out.println("Queue is Full");
        }
        else {
            System.out.println("Enqueued element to queue is " + input);
            stack1.push(input);
        }
    }

    // Dequeue
    public int dequeue() {
        if (stack1.isEmpty() && !stack2.isEmpty()) {
            int temp = stack2.pop();
            System.out.println("Dequeued element from queue is " +temp);
            return (temp);
        }
        else if (!stack1.isEmpty() && stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int temp = stack2.pop();
            System.out.println("Dequeued element from queue is " +temp);
            return (temp);
        }
        else if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is Empty");
        }
        return -1;
    }

    // Print
    public void print () {
        if (!stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("The queue is:");
            for (int i = 0; i < stack1.array.length; i++) {
                System.out.print(" " + stack1.array[i]);
            }
            System.out.println();
        }
        else {
            System.out.println("The queue is:");
            for (int i = stack2.array.length-1; i >= 0 ; i--) {
                System.out.print(" " + stack2.array[i]);
            }
            System.out.println();
        }
    }
}
public class QueueWithStacks {
    public static void main (String args[]) {
        TwoStacks queue = new TwoStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
    }
}
