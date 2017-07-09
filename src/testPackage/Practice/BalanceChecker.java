package testPackage.Practice;

import java.util.Stack;

/**
 * Created by bajmd on 08/07/17.
 */
public class BalanceChecker {
    public static void main (String args []) {
        BalanceChecker checker = new BalanceChecker();
        System.out.println(checker.isBalanced("(){{}}"));
    }

    public boolean isBalanced(String inputString) {
        int length = inputString.length();

        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<length; i++) {
            Character ch = inputString.charAt(i);
            //boolean isBalanced = true;

            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            }
            else {
                if (ch == '}' && stack.pop()!= '{') {
                    return false;
                }
                if (ch == ')' && stack.pop()!= '(') {
                    return false;
                }
                if (ch == ']' && stack.pop()!= '[') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty())
            return false;
        else
            return true;
    }
}
