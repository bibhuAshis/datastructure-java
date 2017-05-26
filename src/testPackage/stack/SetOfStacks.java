package testPackage.stack;

/**
 * Created by bajmd on 20/12/16.
 * Problem Statement: A single stack is implemented using 3 stacks of size 2. When we push to outer stack,
 * internally it pushes to first stack. if it is full, it pushes to next stack and so on. During pop from
 * outer stack, it pops from the third stack. If it is empty it pops from second stack and so on. Implement.
 */

//Class Stack
class IStack {
	 int iStack[];
	 int isTop, size;

	public IStack() {
		//isTop = -1;
	}

	public IStack(int m) {
		isTop = -1;
		size = m;
		iStack = new int[size];
	}
}

public class SetOfStacks extends IStack {

	IStack setofStacks[];
	int sosTop, sosSize, isSize;

	// Constructor
	public SetOfStacks(int n, int m) {
		sosSize = n;
		isSize = m;
		sosTop = 0;
		setofStacks = new IStack[sosSize];
		for (int i=0; i<sosSize; i++)
			setofStacks[i] = new IStack(isSize);
	}

	// Set of stacks Push
	 public void push(int data) {
		 isTop++;
		 if (isTop >= isSize) {
			 sosTop++;
			 if (sosTop >= setofStacks.length) {
				 System.out.println("Stack is Full");
				 sosTop--;
				 isTop--;
			 }
			 else {
			 	isTop = -1;
			 	push(data);
			 }
		 }
		 else {
			 setofStacks[sosTop].iStack[isTop] = data;
			 System.out.println("Pushed element to stack is " + data);
		 }
	 }

	 // Set of stacks Pop
	 public void pop() {
		 if (isTop < 0) {
			 isTop = isSize-1;
			 sosTop--;
			 if (sosTop < 0) {
				 System.out.println("Stack is Empty");
			 }
			 else {
				 pop();
			 }
		 }
		 else {
			 System.out.println("Popped element from stack is " + setofStacks[sosTop].iStack[isTop]);
			 isTop--;
		 }
	 }
	public static void main(String[] args) {
	 	SetOfStacks stack = new SetOfStacks(3, 2);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
	}

}
