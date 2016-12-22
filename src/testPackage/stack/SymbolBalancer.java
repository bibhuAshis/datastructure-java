package testPackage.stack;

public class SymbolBalancer {
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

	public static void main (String args[]) {
		SymbolBalancer symbols = new SymbolBalancer();
		String symbolArray = "((A+B)+[C-D])";
		boolean isBalanced = true;
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
