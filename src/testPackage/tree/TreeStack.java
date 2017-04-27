package testPackage.tree;

import testPackage.stack.Stack;

/**
 * Created by bajmd on 26/04/17.
 */
public class TreeStack {
    public TreeNode array[];
    protected int top, size;

    // Constructor
    public TreeStack(int n) {
        size = n;
        array = new TreeNode[size];
        top = -1;
    }

    // Top Getter
    public int getTop() {
        return this.top;
    }

    // Top Setter
    public void setTop(int top) {
        this.top = top;
    }

    // Push
    public void push(TreeNode node) {
        top++;
        if (top >= array.length) {
            //System.out.println("Stack is full");
            top--;
        }
        else {
            array[top] = node;
            //System.out.println("Pushed element to stack is " + array[top].getData());
        }
    }

    // Pop
    public TreeNode pop() {
        if (top < 0) {
            return null;
        }
        else {
            //System.out.println("Popped element from stack is " + array[top].getData());
            TreeNode temp = array[top];
            array[top--] = null;
            return (temp);
        }
    }

    // Peek
    public TreeNode peek() {
        if (top < 0) {
            return null;
        }
        else {
            return (array[top]);
        }
    }

    // Print
    public void print() {
        System.out.println("The stack is:");
        for (int i=0; i<array.length; i++) {
            System.out.print(" " + array[i].getData());
        }
        System.out.println();
    }

    // Is Empty
    public boolean isEmpty() {
        if (top == -1)
            return true;
        else
            return false;
    }

    public static void main (String args[]) {
        TreeStack stack = new TreeStack(5);
    }
}
