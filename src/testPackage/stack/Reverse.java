package testPackage.stack;

/**
 * Created by bajmd on 12/28/2016.
 * Given a stack, how to reverse the contents of stacks using only stack operations?
 */

// Reversing Logic
class StackReverser {
    Stack stack = new Stack();
    Stack reversedStack = new Stack();
    int reverse(int input[]) {
        for (int i=0; i<input.length; i++) {
            stack.push(input[i]);
        }
        System.out.println("The stack is ");
        stack.print();
        while (stack.getTop() != -1 ) {
            reversedStack.push(stack.pop());
        }
        System.out.println("The reversed stack is ");
        reversedStack.print();
        return 0;
    }
}

public class Reverse {
    public static void main (String args []) {
        StackReverser reverser = new StackReverser();
        int input[] = {1,2,3,4,5};
        reverser.reverse(input);
    }
}
