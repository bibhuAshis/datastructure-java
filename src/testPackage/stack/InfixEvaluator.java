package testPackage.stack;

/**
 * Created by bajmd on 12/27/2016.
 * Problem Statement: Discuss infix evaluation using one pass.
 */

// Infix Evaluator Stack
class InfixEvaluatorStack {
    int array[] = new int[10];
    int top = -1;

    // Push
    public void push(char data) {
        top++;
        if (top >= array.length) {
            //System.out.println("Stack is full");
            top--;
        }
        else {
            array[top] = data;
            System.out.println("Pushed element is " + data);
        }
    }

    public void push(int data) {
        top++;
        if (top >= array.length) {
            //System.out.println("Stack is full");
            top--;
        }
        else {
            array[top] = data;
            System.out.println("Pushed element is " + data);
        }
    }

    // Pop
    public int pop() {
        if (top < 0) {
            //System.out.println("Stack is empty");
            return ' ';
        }
        else {
            System.out.println("Popped element is " + array[top]);
            return (array[top--]);
        }
    }

    // Peep
    public int peep() {
        if (top < 0) {
            return ' ';
        }
        else {
            return array[top];
        }
    }
}

// Infix Evaluation Logic
class Eval {
    InfixEvaluatorStack operatorStack = new InfixEvaluatorStack();
    InfixEvaluatorStack operandStack = new InfixEvaluatorStack();
    public int calculate (char symbol, int operand1, int operand2) {
        int result = 0;
        switch (symbol) {
            case '+': {
                result = (operand1 + operand2);
                break;
            }
            case '-': {
                result = -(operand1 - operand2);
                break;
            }
            case '*': {
                result =  operand1 * operand2;
                break;
            }
            case '/': {
                result = 1/(operand1 / operand2);
                break;
            }
        }
        return result;
    }
    public int evalInfix(String inputString) {
        for (int i=0; i< inputString.length(); i++) {
            if ((inputString.charAt(i) == '+' || inputString.charAt(i) == '-' || inputString.charAt(i) == '*' || inputString.charAt(i) == '/') && (operatorStack.top == -1)) {
                operatorStack.push(inputString.charAt(i));
            }
            else if (inputString.charAt(i) == '+' || inputString.charAt(i) == '-') {
                while (operatorStack.peep() == '+' || operatorStack.peep() == '-' || operatorStack.peep() == '*' || operatorStack.peep() == '/') {
                    //calculate(operatorStack.peep(), operandStack.pop(), operandStack.pop());
                    operatorStack.pop();
                }
            }
            /*else if () {

            }*/
            else {
                operandStack.push(inputString.charAt(i));
            }
        }
        return 0;
    }
}

public class InfixEvaluator {
    public static void main (String args []) {
        Eval infixEval = new Eval();
        infixEval.evalInfix("1+2*3-5");
    }
}
