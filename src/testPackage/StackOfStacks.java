package testPackage;

//Class Stack
class IStack {
	 int array[] = new int[2];
	 int top = -1;
	 
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
	 
	 // Stack Peep
	 public void peep() {
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
	
	static IStack stackArray[] = new IStack[] {new IStack(), new IStack(), new IStack()};
	static int stackTop = 0;
		
	
	// Stack Push
	 public void stackPush(int stackData) {
		 stackArray[stackTop].push(stackData);
	 }
	 
	 // Stack Pop
	 public void stackPop() {
		 stackArray[stackTop].pop();
	 }
	 
	 // Stack Peep
	 public void stackPeep() {
		 stackArray[stackTop].peep();
	 }	

	public static void main(String[] args) {
		
		StackOfStacks stack = new StackOfStacks();
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
