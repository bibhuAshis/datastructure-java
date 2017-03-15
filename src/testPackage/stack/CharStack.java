package testPackage.stack;

/**
 * Created by bajmd on 20/12/16.
 * Problem Statement: Write array implementation of character stack ADT.
 */

public class CharStack {
    char array[];
    int top, size;

    // Constructor
    public CharStack(int n) {
        size = n;
        array = new char[size];
        top = -1;
    }

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

    // Peek
    public char peek() {
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
        CharStack stack = new CharStack(5);
        stack.peek();
        stack.push('[');
        stack.peek();
        stack.push('{');
        stack.peek();
        stack.push('(');
        stack.peek();
        stack.push(')');
        stack.peek();
        stack.push('}');
        stack.peek();
        stack.print();
        stack.push(']'); // Pushing to Full Stack
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.print();
        stack.pop(); // Popping from Empty Stack
    }
}
