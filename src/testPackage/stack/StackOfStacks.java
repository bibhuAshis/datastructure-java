package testPackage.stack;

/**
 * Created by bajmd on 20/12/16.
 * Problem Statement: A single stack is implemented using 3 stacks of size 2. When we push to outer stack,
 * internally it pushes to first stack. if it is full, it pushes to next stack and so on. During pop from
 * outer stack, it pops from the third stack. If it is empty it pops from second stack and so on. Implement.
 */

//Class Stack
class IStack {
	 int array[];
	 int top, size;

	// Constructor
	public IStack(int n) {
		size = n;
		array = new int[size];
		top = -1;
	}
	 
	 // Stack Push
	 public void push(int data) {
		 top++;
		 if (top >= array.length) {
			 top--;
			 StackOfStacks.stackTop++;
			 if (StackOfStacks.stackTop >= StackOfStacks.stackArray.length) {
				 System.out.println("Stack is Full");
				 StackOfStacks.stackTop--;
				 top = array.length-1;
			 }
			 else {
				 StackOfStacks.stackArray[StackOfStacks.stackTop].push(data);
			 }
		 }
		 else {
			 array[top] = data;
			 System.out.println("Pushed element to stack is " + array[top]);
		 }
	 }
	 
	 // Stack Pop
	 public void pop() {
		 if (top < 0) {
			 top = array.length-1;
			 StackOfStacks.stackTop--;
			 if (StackOfStacks.stackTop < 0) {
				 System.out.println("Stack is Empty");
			 }
			 else {
				 StackOfStacks.stackArray[StackOfStacks.stackTop].pop();
			 }
		 }
		 else {
			 System.out.println("Popped element from stack is " + array[top]);
			 top--;
		 }
	 }
	 
	 // Stack Peek
	 public void peek() {
		 if (top < 0) {
			 StackOfStacks.stackTop--;
			 if (StackOfStacks.stackTop < 0) {
				 System.out.println("Stack is Empty");
			 }
			 else {
				 System.out.println("Top of stack is " + StackOfStacks.stackArray[StackOfStacks.stackTop]);
			 }
		 }
		 else {
			 System.out.println("Top of stack is " + array[top]);
		 }
	 }
}

public class StackOfStacks {
	
	static IStack stackArray[];

	int sosTop, sosSize, isSize;

	// Constructor
	public StackOfStacks(int n, int m) {
		sosSize = n;
		isSize = m;
		stackArray = new IStack[sosSize];
		for (int i=0; i<sosSize; i++)
			stackArray[i] = new IStack(isSize);
		sosTop = -1;
	}
	static int stackTop = 0;

	// Stack of stacks Push
	 public void stackPush(int stackData) {
		 stackArray[stackTop].push(stackData);
	 }
	 
	 // Stack of stacks Pop
	 public void stackPop() {
		 stackArray[stackTop].pop();
	 }
	 
	 // Stack of stacks Peek
	 public void stackPeek() {
		 stackArray[stackTop].peek();
	 }	

	public static void main(String[] args) {
	 	StackOfStacks stack = new StackOfStacks(3, 2);
		stack.stackPush(1);
		stack.stackPush(2);
		stack.stackPush(3);
		stack.stackPush(4);
		stack.stackPush(5);
		stack.stackPush(6);
		stack.stackPush(7);
		stack.stackPop();
		stack.stackPop();
		stack.stackPop();
		stack.stackPop();
		stack.stackPop();
		stack.stackPop();
		stack.stackPop();
	}

}
