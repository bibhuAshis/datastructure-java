package testPackage.stack;

/**
 * Created by bajmd on 20/12/16.
 */

public class Stack {
	int array[] = new int[5];
	int top = -1;
	
	// Push
	public void push(int data) {
		top++;
		if (top >= array.length) {
			System.out.println("Stack is full");
			top--;
		}
		else {
			array[top] = data;
			System.out.println("Pushed element is " + array[top]);
		}
	}
	
	// Pop	
	public int pop() {
		if (top < 0) {
			return 0;
		}
		else {
			System.out.println("Popped element is " + array[top]);
			int temp = array[top];
			array[top--] = 0;
			return (temp);
		}
	}
	
	// Peep
	public int peep() {
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
	public static void main (String args[]) {
		Stack stack = new Stack();
		stack.peep();
		stack.push(1);
		stack.peep();
		stack.push(2);
		stack.peep();
		stack.push(3);
		stack.peep();
		stack.push(4);
		stack.peep();
		stack.push(5);
		stack.peep();
		stack.print();
		stack.push(6); // Pushing to Full Stack
		stack.pop();
		stack.peep();
		stack.pop();
		stack.peep();
		stack.pop();
		stack.peep();
		stack.pop();
		stack.peep();
		stack.pop();
		stack.peep();
		stack.print();
		stack.pop(); // Popping from Empty Stack
	}
}
