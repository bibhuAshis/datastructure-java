package testPackage.string;
import testPackage.stack.*;

/**
 * Created by bajmd on 29/04/17.
 */
public class RemoveDuplicate {
    public  String remDup(String string) {
        CharStack stack = new CharStack(5);
        int i=0;
        while (i < string.length()) {
            if (stack.isEmpty()) {
                stack.push(string.charAt(i));
                i++;
            }
            else if(string.charAt(i) != stack.peek()) {
                stack.push(string.charAt(i));
                i++;
            }
            else {
                while (i < string.length() && string.charAt(i) == stack.peek()) {
                    i++;
                }
                stack.pop();
            }
        }
        StringBuilder result_string = new StringBuilder();
        while (!stack.isEmpty())
            result_string.append(stack.pop());
        StringReverse reverser = new StringReverse();

        return reverser.reverse(result_string.toString());
    }

    public static void main(String args[]) {
        RemoveDuplicate remDuplicate = new RemoveDuplicate();
        String string = "ABCCBCBA";
        String result_string = remDuplicate.remDup(string);
        System.out.println(result_string);
        }
}
