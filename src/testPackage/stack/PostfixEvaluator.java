package testPackage.stack;

/**
 * Created by bajmd on 22/12/16.
 * Problem Statement: Discuss postfix evaluation using stack.
 */

// Postfix Evaluation Class
class Evaluator {
    Stack stack = new Stack();
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
                result = 1/(stack.pop() / stack.pop());
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
        System.out.println("The result of postfix evaluation is " +eval.evaluate("123*+5-"));
    }
}
