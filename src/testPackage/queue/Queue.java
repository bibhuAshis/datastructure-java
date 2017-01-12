package testPackage.queue;

/**
 * Created by bajmd on 28/12/16.
 * Problem Statement: Write array implementation of queue ADT.
 */

public class Queue {
	int array[] = new int[5];
	int front = -1;
	int rear = -1;
	
	// Enqueue
	public void enqueue(int data) {
		if (rear == array.length-1) {
			System.out.println("Queue is full");
		}
		else if (front == -1 && rear == -1) {
			front++;
			rear++;
			array[rear] = data;
			System.out.println("Enqueued element to queue is " +array[rear]);
		}
		else {
			rear++;
			array[rear] = data;
			System.out.println("Enqueued element to queue is " +array[rear]);
		}
	}
	
	// Dequeue
	public int dequeue() {
		if (front == -1 && rear == -1) {
			System.out.println("Queue is Empty");
			return -1;
		}
		else if (front > rear) {
			System.out.println("Queue is Empty");
			front = -1;
			rear = -1;
			return -1;
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
		for (int i=0; i<array.length; i++) {
			System.out.print(" " + array[i]);
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
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.enqueue(1);
		queue.print();
	}

}
