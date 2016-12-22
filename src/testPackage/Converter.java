package testPackage;

/**
 * Created by bajmd on 22/12/16.
 */

// Stack class
class ConverterStack {
    char inputArray[] = new char[20];
    int top = -1;

    //Push
    public void push(char data) {
        top++;
        if (top >= inputArray.length) {
            //System.out.println("Stack is full");
            top--;
        }
        else {
            inputArray[top] = data;
            System.out.println("Pushed element is " + inputArray[top]);
        }
        for (int i=0; i<inputArray.length; i++) {
            System.out.print(" " + inputArray[i]);
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
            System.out.println("Popped element is " + inputArray[top]);
            return inputArray[top--];
        }
    }

    // Peep
    public char peep() {
        if (top < 0) {
            //System.out.println("Stack is empty");
            return ' ';
        }
        else {
            System.out.println("Top of the stack is " + inputArray[top]);
            return inputArray[top];
        }
    }
}

// Infix to Postfix class
class InfixToPostfix {
    ConverterStack postfixConverter = new ConverterStack();
    String postfixOutput = " ";
    String convertToPostfix(String infixInput) {
        for (int i=0; i<infixInput.length(); i++) {
            if (infixInput.charAt(i) == '(')
                postfixConverter.push(infixInput.charAt(i));
            else if (infixInput.charAt(i) == '+' || infixInput.charAt(i) == '-'){
                while (!(postfixConverter.peep() == '(' || postfixConverter.top == -1))
                    postfixOutput = postfixOutput + postfixConverter.pop();
                postfixConverter.push(infixInput.charAt(i));
            }
            else if ((infixInput.charAt(i) == '*' || infixInput.charAt(i) == '/') && (!(postfixConverter.peep() == '*' || postfixConverter.peep() == '/'))){
                while (!(postfixConverter.peep() == '(' || postfixConverter.peep() == '+' || postfixConverter.peep() == '-' || postfixConverter.top == -1))
                    postfixOutput = postfixOutput + postfixConverter.pop();
                postfixConverter.push(infixInput.charAt(i));
            }
            else if (infixInput.charAt(i) == ')'){
                while (postfixConverter.peep() != '(')
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
