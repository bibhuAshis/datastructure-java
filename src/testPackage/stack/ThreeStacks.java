package testPackage.stack;

/**
 * Created by bajmd on 21/12/16.
 * Problem Statement: How to implement 3 stacks in one array.
 */

public class ThreeStacks {
	
	int array[];
	int top1, top2, top3, size;

	// Constructor
	public ThreeStacks(int n) {
		size = n;
		array = new int[size];
		top1 = -3;
		top2 = -2;
		top3 = -1;
	}
	
	// Push
	public void push(int data, int stackno) {
		switch (stackno) {
			case 1: {
				top1+=3;
				if (top1 >= array.length) {
					System.out.println("Stack 1 is Full");
					top1-=3;
					break;
				}
				else {
					array[top1] = data;
					System.out.println("Pushed element to Stack 1 is " + array[top1]);
					break;
				}
			}
			case 2: {
				top2+=3;
				if (top2 >= array.length) {
					System.out.println("Stack 2 is Full");
					top2-=3;
					break;
				}
				else {
					array[top2] = data;
					System.out.println("Pushed element to Stack 2 is " + array[top2]);
					break;
				}
			}
			case 3: {
				top3+=3;
				if (top3 >= array.length) {
					System.out.println("Stack 3 is Full");
					top3-=3;
					break;
				}
				else {
					array[top3] = data;
					System.out.println("Pushed element to Stack 3 is " + array[top3]);
					break;
				}
			}
			default: {
				System.out.println("Only 3 Stacks");
				break;
			}
		}
	}
	
	// Pop
	public int pop(int stackno) {
		switch (stackno) {
			case 1: {
				if (top1 < 0) {
					System.out.println("Stack 1 is Empty");
					break;
				}
				else {
					System.out.println("Popped element from Stack1 is " + array[top1]);
					int temp = array[top1];
					array[top1] = 0;
					top1-=3;
					return temp;
				}
			}
			case 2: {
				if (top2 < 0) {
					System.out.println("Stack 2 is Empty");
					break;
				}
				else {
					System.out.println("Popped element from Stack2 is " + array[top2]);
					int temp = array[top2];
					array[top2] = 0;
					top2-=3;
					return temp;
				}
			}
			case 3: {
				if (top3 < 0) {
					System.out.println("Stack 3 is Empty");
					break;
				}
				else {
					System.out.println("Popped element from Stack3 is " + array[top3]);
					int temp = array[top3];
					array[top3] = 0;
					top3-=3;
					return temp;
				}
			}
			default: {
				System.out.println("Only 3 Stacks");
				break;
			}
		}
		return 0;
	}
	
	// Peek
	public void peek(int stackno) {
		switch (stackno) {
			case 1: {
				if (top1 < 0) {
					System.out.println("Stack 1 is Empty");
					break;
				}
				else {
					System.out.println("Top in Stack1 is " + array[top1]);
					break;
				}
			}
			case 2: {
				if (top2 < 0) {
					System.out.println("Stack 2 is Empty");
					break;
				}
				else {
					System.out.println("Top in Stack2 is " + array[top2]);
					break;
				}
			}
			case 3: {
				if (top3 < 0) {
					System.out.println("Stack 3 is Empty");
					break;
				}
				else {
					System.out.println("Top in Stack3 is " + array[top3]);
					break;
				}
			}
			default: {
				System.out.println("Only 3 Stacks");
				break;
			}
		}
	}

	// Print

	public void print() {
		System.out.println("The stack is: ");
		for (int i=0; i<array.length; i++) {
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}

	public static void main(String args[]) {
		ThreeStacks stack = new ThreeStacks(5);
		stack.push(1, 1);
		stack.peek(1);
		stack.push(2, 2);
		stack.peek(2);
		stack.push(3, 3);
		stack.peek(3);
		stack.push(4, 1);
		stack.peek(1);
		stack.push(5, 2);
		stack.peek(2);
		stack.push(6, 3);
		stack.peek(3);
		stack.print();
		stack.pop(1);
		stack.peek(1);
		stack.pop(2);
		stack.peek(2);
		stack.pop(3);
		stack.peek(3);
		stack.pop(1);
		stack.peek(1);
		stack.pop(2);
		stack.peek(2);
		stack.pop(3);
		stack.peek(3);
		stack.print();
	}

}
