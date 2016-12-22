package testPackage.stack;

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
		for (int i=0; i<array.length; i++) {
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}
	
	// Pop	
	public void pop() {
		if (top < 0) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.println("Popped element is " + array[top]);
			array[top] = 0;
			top--;
		}
		for (int i=0; i<array.length; i++) {
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}
	
	// Peep
	public void peep() {
		if (top < 0) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.println("Top of stack " + array[top]);
		}
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
		stack.pop(); // Popping from Empty Stack
	}
}
