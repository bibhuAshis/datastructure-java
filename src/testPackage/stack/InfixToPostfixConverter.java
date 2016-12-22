package testPackage.stack;

public class InfixToPostfixConverter {
	char infixArray[] = new char[20];
	int top = -1;
	
//Push
	public void push(char data) {
		top++;
		if (top >= infixArray.length) {
			//System.out.println("Stack is full");
			top--;
		}
		else {
			infixArray[top] = data;
			System.out.println("Pushed element is " + infixArray[top]);
		}
		for (int i=0; i<infixArray.length; i++) {
			System.out.print(" " + infixArray[i]);
		}
		System.out.println();
	}
		
// Pop	
	public char pop() {
		if (top < 0) {
			//System.out.println("Stack is empty");
			return ' ';
		}
		else {
			System.out.println("Popped element is " + infixArray[top]);
			return infixArray[top--];
		}
	}	

// Peep	
	public char peep() {
		if (top < 0) {
			//System.out.println("Stack is empty");
			return ' ';
		}
		else {
			System.out.println("Top of the stack is " + infixArray[top]);
			return infixArray[top];
		}
	}
	
	public static void main(String args[]) {
		InfixToPostfixConverter converterStack = new InfixToPostfixConverter();
		String infixInput = "A*B*C*D";
		String postfixOutput = " ";
		for (int i=0; i<infixInput.length(); i++) {
			if (infixInput.charAt(i) == '(')
				converterStack.push(infixInput.charAt(i));
			else if (infixInput.charAt(i) == '+' || infixInput.charAt(i) == '-'){
				while (!(converterStack.peep() == '(' || converterStack.top == -1))
					postfixOutput = postfixOutput + converterStack.pop();	
				converterStack.push(infixInput.charAt(i));
			}
			else if ((infixInput.charAt(i) == '*' || infixInput.charAt(i) == '/') && (!(converterStack.peep() == '*' || converterStack.peep() == '/'))){
				while (!(converterStack.peep() == '(' || converterStack.peep() == '+' || converterStack.peep() == '-' || converterStack.top == -1))
					postfixOutput = postfixOutput + converterStack.pop();
				converterStack.push(infixInput.charAt(i));
			}
			else if (infixInput.charAt(i) == ')'){
				while (converterStack.peep() != '(')
					postfixOutput = postfixOutput + converterStack.pop();
				converterStack.pop();
			}
			else 
				postfixOutput = postfixOutput + infixInput.charAt(i);
		}
		while (converterStack.top != -1)
			postfixOutput = postfixOutput + converterStack.pop();
		System.out.println(postfixOutput);		
	}
}
