package testPackage.stack;

/**
 * Created by bajmd on 26/12/16.
 * Problem Statement: How to design a stack such that getting minimum should be O(1)?
 */
// Input Stack Class
class InputStack {
    int inputArray[] = new int[10];
    int top = -1;

    // Push
    public void push(int data) {
        top++;
        if (top >= inputArray.length) {
            //System.out.println("Stack is full");
            top--;
        } else {
            inputArray[top] = data;
            System.out.println("Pushed element to input stack is " + inputArray[top]);
        }
    }
}

// Min Stack Class
class MinStack {
    int inputArray[] = new int[10];
    int top = -1;

    // Push
    public void push(int data) {
        top++;
        if (top >= inputArray.length) {
            //System.out.println("Stack is full");
            top--;
        } else {
            inputArray[top] = data;
            System.out.println("Pushed element to min stack is " + inputArray[top]);
        }
    }
    // Peep
    public int peep() {
        if (top < 0) {
            //System.out.println("Stack is empty");
            return ' ';
        }
        else {
            System.out.println("Min Element is " + inputArray[top]);
            return inputArray[top];
        }
    }
}

// Min Keeper Class
class MinKeeper {
    InputStack inputStack = new InputStack();
    MinStack minStack = new MinStack();
    int getMin(String InputString) {
        for (int i=0; i<InputString.length(); i++) {
            if (inputStack.top == -1 && minStack.top == -1){
                inputStack.push(Character.getNumericValue(InputString.charAt(i)));
                minStack.push(Character.getNumericValue(InputString.charAt(i)));
            }
            else if(Character.getNumericValue(InputString.charAt(i)) < minStack.peep()){
                inputStack.push(Character.getNumericValue(InputString.charAt(i)));
                minStack.push(Character.getNumericValue(InputString.charAt(i)));
            }
            else{
                inputStack.push(Character.getNumericValue(InputString.charAt(i)));
            }
        }
        return minStack.peep();
    }
}

// Main Class
public class MinFinder {
    public static void main(String args[]) {
        MinKeeper min = new MinKeeper();
        min.getMin("45213");
    }

}
