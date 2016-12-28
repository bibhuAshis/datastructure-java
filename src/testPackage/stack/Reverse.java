package testPackage.stack;

/**
 * Created by bajmd on 12/28/2016.
 * Given a stack, how to reverse the contents of stacks using only stack operations?
 */

// Reverse Stack Class
class ReverseStack {
    int array[] = new int[5];
    int top =-1;

    // Push
    void push(int data) {
        top++;
        if (top >= array.length) {
            top--;
        }
        else {
            array[top] = data;
            System.out.println("Pushed element to stack is " + data);
        }
    }

    // Pop
    int pop() {
        if (top < 0) {
            return 0;
        }
        else {
            System.out.println("Popped element from stack is " +array[top]);
            return (array[top--]);
        }
    }

    // Print Stack
    void print() {
        for (int i=0; i<array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println(" ");
    }
}

// Reversing Logic
class StackReverser {
    ReverseStack stack = new ReverseStack();
    ReverseStack reversedStack = new ReverseStack();
    int reverse(int input[]) {
        for (int i=0; i<input.length; i++) {
            stack.push(input[i]);
        }
        System.out.println("The stack is ");
        stack.print();
        while (stack.top != -1 ) {
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
