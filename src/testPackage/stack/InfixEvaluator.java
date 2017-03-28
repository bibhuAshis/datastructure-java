package testPackage.stack;

/**
 * Created by bajmd on 12/27/2016.
 * Problem Statement: Discuss infix evaluation using one pass.
 */

// Infix Evaluation Logic
class Eval {
    Stack operandStack = new Stack(5);
    CharStack operatorStack = new CharStack(5);

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
            if ((inputString.charAt(i) == '+' || inputString.charAt(i) == '-' || inputString.charAt(i) == '*' || inputString.charAt(i) == '/') && (operatorStack.isEmpty())) {
                operatorStack.push(inputString.charAt(i));
            }
            else if (inputString.charAt(i) == '+' || inputString.charAt(i) == '-') {
                while (!(operatorStack.isEmpty())) {
                    operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                }
                operatorStack.push(inputString.charAt(i));
            }
            else if (inputString.charAt(i) == '*' || inputString.charAt(i) == '/') {
                while (!(operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.isEmpty())) {
                    operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                }
                operatorStack.push(inputString.charAt(i));
            }
            else {
                operandStack.push(Character.getNumericValue(inputString.charAt(i)));
            }
        }
        while (!operatorStack.isEmpty()) {
            operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
        }
        return operandStack.pop();
    }
}

public class InfixEvaluator {
    public static void main (String args []) {
        Eval infixEval = new Eval();
        System.out.println("The result of infix evaluation is " + infixEval.evalInfix("1+2*3-5+1"));
    }
}
