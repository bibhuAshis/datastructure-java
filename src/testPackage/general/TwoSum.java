package testPackage.general;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajmd on 27/04/17.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                break;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] nums = {3,2,4};
        int target = 6;
        TwoSum sum = new TwoSum();
        int[]result = sum.twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
