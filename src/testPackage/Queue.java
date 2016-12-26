package testPackage;

/**
 * Created by bajmd on 28/12/16.
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
			System.out.println(String.valueOf(array[rear]));
		}
		else {
			rear++;
			array[rear] = data;
			System.out.println(String.valueOf(array[rear]));
		}
	}
	
	// Dequeue
	public int dequeue() {
		if (front == -1 || front == array.length) {
			System.out.println("Queue is Empty");
			return -1;
		}
		else {
			int data = array[front];
			System.out.println(String.valueOf(data));
			front++;
			return data;
		}
	}
	public static void main(String args []) {
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}

}
