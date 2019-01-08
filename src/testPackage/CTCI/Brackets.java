package testPackage.CTCI;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by bajmd on 09/05/17.
 */
public class Brackets {
    private static Scanner in;

	public static boolean isBalanced(String symbolArray) {
        Stack<Character> symbols = new Stack<Character>();
        for (int i=0; i<symbolArray.length(); i++) {
            if (symbolArray.charAt(i) == '[' || symbolArray.charAt(i) == '{' || symbolArray.charAt(i) == '(') {
                symbols.push(symbolArray.charAt(i));
            }
            else {
                if (symbols.isEmpty()){
                    return false;
                }
                else if (symbolArray.charAt(i) == ']' && symbols.pop() != '['){
                    return false;
                }
                else if (symbolArray.charAt(i) == '}' && symbols.pop() != '{'){
                    return false;
                }
                else if (symbolArray.charAt(i) == ')' && symbols.pop() != '('){
                    return false;
                }
            }
        }
        if (symbols.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
