/**
 * Created by mallikad on 1/1/17.
 */
// Stack Class
class DupRemStack{
    int Array[] = new int[15];
    int top = -1;

    // Push
    public void push(int data) {
        top++;
        if(top >= Array.length)
            top--;
        else{
            System.out.println("Pushed element is " +data );
            Array[top] = data;
        }
    }

    // Pop
    public void pop() {
        if (top >= 0) {
            System.out.println("Popped element is " + Array[top]);
            Array[top--] = 0;
        }
    }

    // Peep
    public int peep() {
        if(top < 0)
            return 0;
        else
            return (Array[top]);
    }

    // Print
    public void print() {
        for (int i=0; i<Array.length; i++) {
            System.out.print(" " +Array[i]);
        }
        System.out.println(" ");
    }
}

// Duplicate Removing Class
class RemoveDuplicate {
    DupRemStack stack = new DupRemStack();
    public  void remDup(int inputStack[]) {
        int i=0;
        while (i < inputStack.length) {
            if (stack.top == -1) {
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
