package testPackage.stack;

/**
 * Created by bajmd on 20/12/16.
 * Problem Statement: Write array implementation of integer stack ADT.
 */

public class Stack {
	public int array[];
	protected int top, size;

	// Constructor
	public Stack(int n) {
		size = n;
		array = new int[size];
		top = -1;
	}

	// Top Getter
	public int getTop() {
		return this.top;
	}

	// Top Setter
	public void setTop(int top) {
		this.top = top;
	}
	
	// Push
	public void push(int data) {
		top++;
		if (top >= array.length) {
			System.out.println("Stack is full");
			top--;
		}
		else {
			array[top] = data;
			System.out.println("Pushed element to stack is " + array[top]);
		}
	}
	
	// Pop	
	public int pop() {
		if (top < 0) {
			return 0;
		}
		else {
			System.out.println("Popped element from stack is " + array[top]);
			int temp = array[top];
			array[top--] = 0;
			return (temp);
		}
	}
	
	// Peek
	public int peek() {
		if (top < 0) {
			return 0;
		}
		else {
			return (array[top]);
		}
	}

	// Print
	public void print() {
		System.out.println("The stack is:");
		for (int i=0; i<array.length; i++) {
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}

	// Is Empty
	public boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	public static void main (String args[]) {
		Stack stack = new Stack(5);
		stack.peek();
		stack.push(1);
		stack.peek();
		stack.push(2);
		stack.peek();
		stack.push(3);
		stack.peek();
		stack.push(4);
		stack.peek();
		stack.push(5);
		stack.peek();
		stack.print();
		stack.push(6); // Pushing to Full Stack
		stack.pop();
		stack.peek();
		stack.pop();
		stack.peek();
		stack.pop();
		stack.peek();
		stack.pop();
		stack.peek();
		stack.pop();
		stack.peek();
		stack.print();
		stack.pop(); // Popping from Empty Stack
	}
}
