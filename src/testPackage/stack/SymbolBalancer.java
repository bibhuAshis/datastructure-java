package testPackage.stack;

/**
 * Created by bajmd on 24/12/16.
 * Problem Statement: Discuss how stacks can be used for checking balancing of symbols?
 */

// Balancing Logic
class Balancer {
	CharStack symbols = new CharStack(5);
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
		String symbolArray = "((A+B)+{}[C-D])";
		balance.checkBalance(symbolArray);
	}
}
