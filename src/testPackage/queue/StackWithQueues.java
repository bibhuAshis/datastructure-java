package testPackage.queue;

/**
 * Created by bajmd on 1/12/2017.
 * Problem Statement: How can you implement a stack using two queues?
 */
class TwoQueues {
    Queue queue1 = new Queue();
    Queue queue2 = new Queue();

    // Push
    public void push(int data) {
        if (queue2.rear == -1) {
            System.out.println("Pushed element to stack is " + data);
            queue1.enqueue(data);
        }
        else if (queue2.rear != -1) {
            queue2.enqueue(data);
            System.out.println("Pushed element to stack is " +data);
        }
    }

    // Pop
    public int pop() {
        if (queue2.front == -1 || queue2.front > queue2.rear) {
            queue2.front = -1;
            queue2.rear = -1;
            while (queue1.front != queue1.rear) {
                queue2.enqueue(queue1.dequeue());
            }
            int temp = queue1.dequeue();
            System.out.println("Popped element from stack is " +temp);
            return (temp);
        }
        else if (queue1.front == -1 || queue1.front > queue1.rear) {
            queue1.front = -1;
            queue1.rear = -1;
            while (queue2.front != queue2.rear) {
                queue1.enqueue(queue2.dequeue());
            }
            int temp = queue2.dequeue();
            System.out.println("Popped element from stack is " +temp);
            return (temp);
        }
        return -1;
    }

    // Peep

    // Print
    public void print () {
        if (queue2.front == -1 || queue2.front > queue2.rear) {
            System.out.println("The stack is:");
            for (int i = 0; i < queue1.array.length ; i++) {
                System.out.print(" " + queue1.array[i]);
            }
            System.out.println();
        }
        else if (queue1.front == -1 || queue1.front > queue1.rear){
            System.out.println("The stack is:");
            for (int i = 0; i < queue2.array.length ; i++) {
                System.out.print(" " + queue2.array[i]);
            }
            System.out.println();
        }
    }
}
public class StackWithQueues {
    public static void main (String args[]) {
        TwoQueues stack = new TwoQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
    }
}
