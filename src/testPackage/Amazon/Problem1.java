package testPackage.Amazon;

import java.util.Stack;

/**
 * Created by bajmd on 09/05/17.
 */
public class Problem1 {
    public static void main (String args[]) {
        Problem1 obj = new Problem1();
        System.out.println(obj.findBrackets());
    }

    int findBrackets() {
        Stack<String> stack = new Stack<String>();
        int value = 1;
        stack.push("(");
        if (stack.pop().charAt(0) == '(');
            value = 0;
        return value;
    }
}
