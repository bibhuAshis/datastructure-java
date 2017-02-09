package testPackage.stack;

/**
 * Created by bajmd on 26/12/16.
 * Problem Statement: How to design a stack such that getting minimum should be O(1)?
 */

// Min Keeper Class
class MinKeeper {
    Stack inputStack = new Stack(5);
    Stack minStack = new Stack(5);
    int getMin(String InputString) {
        for (int i=0; i<InputString.length(); i++) {
            if (inputStack.getTop() == -1 && minStack.getTop() == -1){
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
        System.out.println("Min Element is " + min.getMin("453"));
    }

}
