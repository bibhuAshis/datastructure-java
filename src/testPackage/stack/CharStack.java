package testPackage.stack;

/**
 * Created by bajmd on 20/12/16.
 */

public class CharStack {
    char array[] = new char[5];
    int top = -1;

    // Push
    public void push(char data) {
        top++;
        if (top >= array.length) {
            System.out.println("Stack is full");
            top--;
        }
        else {
            array[top] = data;
            System.out.println("Pushed element is " + array[top]);
        }
    }

    // Pop
    public char pop() {
        if (top < 0) {
            return ' ';
        }
        else {
            System.out.println("Popped element is " + array[top]);
            char temp = array[top];
            array[top--] = 0;
            return (temp);
        }
    }

    // Peep
    public char peep() {
        if (top < 0) {
            return ' ';
        }
        else {
            return (array[top]);
        }
    }

    // Print
    public void print() {
        System.out.println("The stack is:");
        for (int i=0; i<array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }
    public static void main (String args[]) {
        CharStack stack = new CharStack();
        stack.peep();
        stack.push('[');
        stack.peep();
        stack.push('{');
        stack.peep();
        stack.push('(');
        stack.peep();
        stack.push(')');
        stack.peep();
        stack.push('}');
        stack.peep();
        stack.print();
        stack.push(']'); // Pushing to Full Stack
        stack.pop();
        stack.peep();
        stack.pop();
        stack.peep();
        stack.pop();
        stack.peep();
        stack.pop();
        stack.peep();
        stack.pop();
        stack.peep();
        stack.print();
        stack.pop(); // Popping from Empty Stack
    }
}
