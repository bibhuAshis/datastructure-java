package testPackage.general;
import java.util.*;

/**
 * Created by bajmd on 26/12/16.
 */

public class PairFinder {
	
	public static void main (String args[]) {
		PairFinder pairFinder = new PairFinder();
		pairFinder.findPair();
	}
	void findPair() {
		int array[] = {4,2,3,1,5};
		int sum =5;
		HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		for (int i=0; i<5; i++) {
			if (myMap.containsKey(sum-array[i])) {
				System.out.println(String.valueOf(sum-array[i]) + "," + myMap.get(sum-array[i]));
			}
			else {
				myMap.put(array[i], sum-array[i]);
			}
		}
		
	}

}
