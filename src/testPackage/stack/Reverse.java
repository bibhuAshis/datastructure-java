package testPackage.stack;

/**
 * Created by bajmd on 12/28/2016.
 * Given a stack, how to reverse the contents of stacks using only stack operations?
 */

// Reverse Stack Class
class ReverseStack {
    int array[] = new int[10];
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

    // Peep
    int peep() {
        if (top < 0) {
            return 0;
        }
        else {
            System.out.println("Top of stack is " + array[top]);
            return array[top];
        }
    }
}

// Reversing Logic
class StackReverser {
    ReverseStack stack = new ReverseStack();
    int reverse(int inputStack[]) {
        for (int i=0; i<inputStack.length; i++) {
            stack.push(inputStack[i]);
        }
        return 0;
    }
}

public class Reverse {
    public static void main (String args []) {

    }
}
