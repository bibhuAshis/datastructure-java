package testPackage.stack;

/**
 * Created by bajmd on 26/12/16.
 * Problem Statement: How to design a stack such that getting minimum should be O(1)?
 */

// Min Keeper Class
class MinKeeper {
    Stack inputStack = new Stack(5);
    Stack minStack = new Stack(5);
    int getMin(int Input[]) {
        for (int i=0; i<Input.length; i++) {
            if (inputStack.getTop() == -1 && minStack.getTop() == -1){
                inputStack.push(Input[i]);
                minStack.push(Input[i]);
            }
            else if(Input[i] < minStack.peek()){
                inputStack.push(Input[i]);
                minStack.push(Input[i]);
            }
            else{
                inputStack.push(Input[i]);
            }
        }
        return minStack.peek();
    }
}

// Main Class
public class MinFinder {
    public static void main(String args[]) {
        MinKeeper min = new MinKeeper();
        int input[] = {4,5,3,1};
        System.out.println("Min Element is " + min.getMin(input));
    }

}
