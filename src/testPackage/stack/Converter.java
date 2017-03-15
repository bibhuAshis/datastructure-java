package testPackage.stack;

/**
 * Created by bajmd on 22/12/16.
 * Problem Statement: Discuss infix to postfix conversion algorithm using stack.
 */

// Infix to Postfix class
class InfixToPostfix {
    CharStack postfixConverter = new CharStack(5);
    String postfixOutput = " ";
    String convertToPostfix(String infixInput) {
        for (int i=0; i<infixInput.length(); i++) {
            if (infixInput.charAt(i) == '(')
                postfixConverter.push(infixInput.charAt(i));
            else if (infixInput.charAt(i) == '+' || infixInput.charAt(i) == '-'){
                while (!(postfixConverter.peek() == '(' || postfixConverter.top == -1))
                    postfixOutput = postfixOutput + postfixConverter.pop();
                postfixConverter.push(infixInput.charAt(i));
            }
            else if ((infixInput.charAt(i) == '*' || infixInput.charAt(i) == '/') && (!(postfixConverter.peek() == '*' || postfixConverter.peek() == '/'))){
                while (!(postfixConverter.peek() == '(' || postfixConverter.peek() == '+' || postfixConverter.peek() == '-' || postfixConverter.top == -1))
                    postfixOutput = postfixOutput + postfixConverter.pop();
                postfixConverter.push(infixInput.charAt(i));
            }
            else if (infixInput.charAt(i) == ')'){
                while (postfixConverter.peek() != '(')
                    postfixOutput = postfixOutput + postfixConverter.pop();
                postfixConverter.pop();
            }
            else
                postfixOutput = postfixOutput + infixInput.charAt(i);
        }
        while (postfixConverter.top != -1)
            postfixOutput = postfixOutput + postfixConverter.pop();
        return postfixOutput;
    }
}

// Main class
public class Converter {

    public static void main (String args[]) {
        InfixToPostfix intoPost = new InfixToPostfix();
        System.out.println(intoPost.convertToPostfix("A*B*(C+D)"));
    }
}
