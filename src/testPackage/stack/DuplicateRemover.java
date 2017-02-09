package testPackage.stack;

/**
 * Created by bajmd on 1/1/17.
 * Problem Statement: Recursively remove all adjacent duplicates.
 */

// Duplicate Removing Class
class RemoveDuplicate {
    Stack stack = new Stack(5);
    public  void remDup(int inputStack[]) {
        int i=0;
        while (i < inputStack.length) {
            if (stack.getTop() == -1) {
                stack.push(inputStack[i]);
                i++;
            }
            else if(inputStack[i] != stack.peep()) {
                stack.push(inputStack[i]);
                i++;
            }
            else {
                while (i < inputStack.length && inputStack[i] == stack.peep()) {
                    i++;
                }
                stack.pop();
            }
        }
        stack.print();
    }
}

// Main Class
public class DuplicateRemover {
    public static void main (String args[]) {
        RemoveDuplicate remDuplicate = new RemoveDuplicate();
        //int inputStack[] = {1,5,6,8,8,8,0,1,1,0,6,5};
        int inputStack[] = {1,9,6,8,8,8,0,1,1,0,6,5};
        remDuplicate.remDup(inputStack);
    }
}
