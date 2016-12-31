/**
 * Created by bajmd on 12/31/16.
 */
// Stack Class
class SortingStack{
    int Array[] = new int[5];
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
    public int pop() {
        if(top < 0)
            return ' ';
        else {
            System.out.println("Popped element is " + Array[top]);
            return (Array[top--]);
        }
    }

    // Peep
    public int peep() {
        if(top < 0)
            return ' ';
        else
            return (Array[top]);
    }

    public void print() {
        for (int i=0; i<Array.length; i++) {
            System.out.print(" " +Array[i]);
        }
        System.out.println(" ");
    }
}

// Sorting Class
class AscendingSorter{
    SortingStack sortedStack = new SortingStack();
    public void sortStack(SortingStack inputStack) {
        while (inputStack.top != -1) {
            int temp = inputStack.pop();
        while (sortedStack.top != -1 && temp < sortedStack.peep())
                inputStack.push(sortedStack.pop());
            sortedStack.push(temp);
        }
        sortedStack.print();
    }
}

// Main Class
public class Ascending {
    public static void main(String args[]) {
        SortingStack inputStack = new SortingStack();
        inputStack.push(5);
        inputStack.push(1);
        inputStack.push(3);
        inputStack.push(2);
        inputStack.push(4);
        AscendingSorter sort = new AscendingSorter();
        sort.sortStack(inputStack);

    }
}
