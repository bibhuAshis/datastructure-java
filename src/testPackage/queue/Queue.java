package testPackage.queue;

/**
 * Created by bajmd on 28/12/16.
 * Problem Statement: Write array implementation of queue ADT.
 */

public class Queue {
	public int array[] = new int[5];
	public int front = -1;
	public int rear = -1;
	
	// Enqueue
	public void enqueue(int data) {
		if (front == -1 && rear == -1) {
			front++;
			rear++;
			array[rear] = data;
			System.out.println("Enqueued element to queue is " +array[rear]);
		}
		else if (front >= 0 && rear < array.length-1) {
			rear++;
			array[rear] = data;
			System.out.println("Enqueued element to queue is " +array[rear]);
		}
		else if (front > 0 && rear == array.length-1) {
			rear = 0;
			array[rear] = data;
			System.out.println("Enqueued element to queue is " +array[rear]);
		}
		else if (rear < front) {
			rear++;
			array[rear] = data;
			System.out.println("Enqueued element to queue is " +array[rear]);
		}
		else if ((front == 0 && rear == array.length-1) || (rear+1 == front)) {
			System.out.println("Queue is full");
		}
	}
	
	// Dequeue
	public int dequeue() {
		if (front == -1 && rear == -1) {
			System.out.println("Queue is Empty");
			return -1;
		}
		else if (array[front] == 0) {
			System.out.println("Queue is Empty");
			return -1;
		}
		else if (front == array.length-1 && rear < array.length-1) {
			System.out.println("Dequeued element from queue is " +array[front]);
			int temp = array[front];
			array[front] = 0;
			front = 0;
			return temp;
		}
		else {
			System.out.println("Dequeued element from queue is " +array[front]);
			int temp = array[front];
			array[front++] = 0;
			return temp;
		}
	}

	// Print
	public void print() {
		System.out.println("The queue is:");
		int i = front;
		int j = 0;
		while (i <= array.length-1) {
			System.out.print(" " + array[i]);
			i++;
		}
		while (j < front) {
			System.out.print(" " + array[j]);
			j++;
		}
		System.out.println();
	}

	public static void main(String args []) {
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.print();
		queue.enqueue(6);
		queue.dequeue();
		queue.enqueue(6);
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.print();
		queue.enqueue(7);
		queue.print();
		queue.enqueue(8);
		queue.print();

	}

}
