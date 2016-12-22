package testPackage;

/**
 * Created by bajmd on 22/12/16.
 */
// Stack Class
class EvaluatorStack {
    int inputArray[] = new int[20];
    int top = -1;

    //Push
    public void push(int data) {
        top++;
        if (top >= inputArray.length) {
            //System.out.println("Stack is full");
            top--;
        }
        else {
            inputArray[top] = data;
            System.out.println("Pushed element is " + inputArray[top]);
        }
    }

    // Pop
    public int pop() {
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
    public int peep() {
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

// Postfix Evaluation Class
class Evaluator {
    EvaluatorStack stack = new EvaluatorStack();
    int result = 0;
    int evaluate (String PostfixInput) {
        for (int i=0; i<PostfixInput.length(); i++) {
            if (PostfixInput.charAt(i) == '+') {
                result = stack.pop() + stack.pop();
                stack.push(result);
            }
            else if (PostfixInput.charAt(i) == '-') {
                result = -(stack.pop() - stack.pop());
                stack.push(result);
            }
            else if (PostfixInput.charAt(i) == '*') {
                result = stack.pop() * stack.pop();
                stack.push(result);
            }
            else if (PostfixInput.charAt(i) == '/') {
                result = stack.pop() / stack.pop();
                stack.push(result);
            }
            else {
                int i2 = Character.getNumericValue(PostfixInput.charAt(i));
                stack.push(i2);
            }
        }
        return stack.pop();
    }
}

public class PostfixEvaluator {
    public static void main (String args[]) {
        Evaluator eval = new Evaluator();
        System.out.println(eval.evaluate("123*+5-"));
    }
}
