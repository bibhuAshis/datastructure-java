package testPackage.searching;

/**
 * Created by bajmd on 05/05/17.
 */
public class FindNonRepeated {
    public static void main (String args[]) {
        FindNonRepeated find = new FindNonRepeated();
        int[] inputArray = {1,1,2,3,3,4,4};
        System.out.println(find.findNonRepeated(inputArray));
    }

    int findNonRepeated(int[] arr) {
        int num = 0;
        for (int i : arr)
            num = num ^ i;
        return num;
    }
}
