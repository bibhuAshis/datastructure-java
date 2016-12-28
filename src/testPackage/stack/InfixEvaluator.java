package testPackage.stack;

/**
 * Created by bajmd on 12/27/2016.
 * Problem Statement: Discuss infix evaluation using one pass.
 */

// Operand Stack
class OperandStack {
    int array[] = new int[5];
    int top = -1;

    // Push
    public void push(int data) {
        top++;
        if (top >= array.length) {
            //System.out.println("Stack is full");
            top--;
        }
        else {
            array[top] = data;
            System.out.println("Pushed element to operand stack is " + array[top]);
        }
    }

    // Pop
    public int pop() {
        if (top < 0) {
            //System.out.println("Stack is empty");
            return ' ';
        }
        else {
            System.out.println("Popped element from operand stack is " + array[top]);
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

// Operator Stack
class OperatorStack {
    char array[] = new char[5];
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
            System.out.println("Pushed element to operator stack is " + array[top]);
        }
    }

    // Pop
    public char pop() {
        if (top < 0) {
            //System.out.println("Stack is empty");
            return ' ';
        }
        else {
            System.out.println("Popped element from operator stack is " + array[top]);
            return (array[top--]);
        }
    }

    // Peep
    public char peep() {
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
    OperandStack operandStack = new OperandStack();
    OperatorStack operatorStack = new OperatorStack();

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
            default: {
                break;
            }
        }
        return result;
    }
    public int evalInfix(String inputString) {
        for (int i=0; i<inputString.length(); i++) {
            if ((inputString.charAt(i) == '+' || inputString.charAt(i) == '-' || inputString.charAt(i) == '*' || inputString.charAt(i) == '/') && (operatorStack.top == -1)) {
                operatorStack.push(inputString.charAt(i));
            }
            else if (inputString.charAt(i) == '+' || inputString.charAt(i) == '-') {
                while (!(operatorStack.top == -1)) {
                    operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                }
                operatorStack.push(inputString.charAt(i));
            }
            else if (inputString.charAt(i) == '*' || inputString.charAt(i) == '/') {
                while (!(operatorStack.peep() == '+' || operatorStack.peep() == '-' || operatorStack.top == -1)) {
                    operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                }
                operatorStack.push(inputString.charAt(i));
            }
            else {
                operandStack.push(Character.getNumericValue(inputString.charAt(i)));
            }
        }
        while (operatorStack.top != -1) {
            operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
        }
        return operandStack.pop();
    }
}

public class InfixEvaluator {
    public static void main (String args []) {
        Eval infixEval = new Eval();
        System.out.println(infixEval.evalInfix("1+2*3-5+1"));
    }
}
