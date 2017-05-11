package testPackage.searching;

import java.util.*;

/**
 * Created by bajmd on 09/05/17.
 */
class Pair {
    int first, second;
    public Pair(int f, int s) {
        first = f;
        second = s;
    }
}

public class TwoPairsWithEqualSum {
    public static void main (String args[]) {
        TwoPairsWithEqualSum obj = new TwoPairsWithEqualSum();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(4);
        input.add(7);
        input.add(1);
        input.add(2);
        input.add(9);
        input.add(8);
        ArrayList<Integer> result = obj.equal(input);
        for (int i: result)
            System.out.println(i);
    }


    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        Map<Integer, Pair> map = new HashMap<Integer, Pair>();
        ArrayList<Integer> resultarr = new ArrayList<Integer>();
        int size = a.size();

        for (int i=0; i<size; i++) {
            for (int j=i+1; j<size; j++) {
                int sum = a.get(i) + a.get(j);
                if (!map.containsKey(sum))
                    map.put(sum, new Pair(i,j));
                else {
                    Pair result = map.get(sum);
                    if (i != result.first && i != result.second && j != result.first && j != result.second) {
                        if (resultarr.size() == 0) {
                            resultarr.add (result.first);
                            resultarr.add (result.second);
                            resultarr.add (i);
                            resultarr.add (j);
                        }
                        else if (result.first <= resultarr.get(0) && result.second < resultarr.get(1)){
                            resultarr.set(0, result.first);
                            resultarr.set(1, result.second);
                            resultarr.set(2, i);
                            resultarr.set(3, j);
                        }
                    }
                }
            }
        }
        return resultarr;
    }
}
