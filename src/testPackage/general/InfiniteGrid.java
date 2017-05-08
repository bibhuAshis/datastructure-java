package testPackage.general;
import java.util.*;

/**
 * Created by bajmd on 05/05/17.
 */
public class InfiniteGrid {
    public static void main(String args[]) {
        InfiniteGrid grid = new InfiniteGrid();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);

        System.out.println(grid.flip("111"));
    }

    public ArrayList<Integer> flip(String A) {
        int size = A.length();
        int sum=0, current_sum = 0, max_sum = Integer.MIN_VALUE;
        int ans1 = Integer.MAX_VALUE, ans2 = Integer.MAX_VALUE, l = 0;
        int[] array = new int[size];
        for (int i=0; i<size; i++) {
            if(A.charAt(i) == '1')
                array[i] = -1;
            else
                array[i] = 1;
        }
        for (int i=0; i<size; i++) {
            current_sum += array[i];
            if (current_sum < 0) {
                current_sum = 0;
                l = i+1;
            }
            if (current_sum > max_sum) {
                max_sum = current_sum;
                ans1 = l;
                ans2 = i;
            }
        }
        ArrayList<Integer> result = new ArrayList();
        if (ans1+1 >= size)
            return result;
        else {
            result.add(ans1+1);
            result.add(ans2+1);
            return result;
        }
    }
}
