package testPackage.stack;

/**
 * Created by bajmd on 24/12/16.
 * Problem Statement: Discuss how stacks can be used for checking balancing of symbols?
 */

// Stack
class SymbolBalancerStack {
	char array[] = new char[6];
	int top = -1;

	//Push
	public void push(char data) {
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
	public char pop() {
		if (top < 0) {
			System.out.println("Stack is empty");
			return ' ';
		}
		else {
			System.out.println("Popped element is " + array[top]);
			return array[top--];
		}
	}
}

// Balancing Logic
class Balancer {
	SymbolBalancerStack symbols = new SymbolBalancerStack();
	boolean isBalanced = true;
	public void checkBalance (String symbolArray) {
		for (int i=0; i<symbolArray.length(); i++) {
			if (symbolArray.charAt(i) == '[' || symbolArray.charAt(i) == '{' || symbolArray.charAt(i) == '(') {
				symbols.push(symbolArray.charAt(i));
			}
			else {
				if (symbolArray.charAt(i) == ']' && symbols.pop() != '['){
					isBalanced = false;
					break;
				}
				else if (symbolArray.charAt(i) == '}' && symbols.pop() != '{'){
					isBalanced = false;
					break;
				}
				else if (symbolArray.charAt(i) == ')' && symbols.pop() != '('){
					isBalanced = false;
					break;
				}
				else if (symbolArray.charAt(i) != '[' || symbolArray.charAt(i) != '{' || symbolArray.charAt(i) != '(' || symbolArray.charAt(i) != ']' || symbolArray.charAt(i) != '}' || symbolArray.charAt(i) != ')')
					continue;
				else
					continue;
			}
		}
		if (isBalanced)
			System.out.println("String is Balanced");
		else
			System.out.println("String is Unbalanced");
	}
}

public class SymbolBalancer {
	public static void main (String args[]) {
		Balancer balance = new Balancer();
		String symbolArray = "((A+B)+[C-D])";
		balance.checkBalance(symbolArray);
	}
}
