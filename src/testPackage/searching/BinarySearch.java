package testPackage.searching;

/**
 * Created by bajmd on 03/05/17.
 */
public class BinarySearch {
    public int binarySearch(int low, int high, int[] array, int data) {
        while (low <= high) {
            int mid = (low+high)/2;
            if (array[mid] == data)
                return mid;
            else if (array[mid] < data)
                return binarySearch(mid+1, high, array, data);
            else if (array[mid] > data)
                return binarySearch(low, mid-1, array, data);
        }
        return -1;
    }

    public static void main (String args[]) {
        int[] inputArray = {1,2,3,4,5};
        int toSearch = 6;
        int low = 0, high = inputArray.length-1;
        BinarySearch search = new BinarySearch();
        System.out.println("The position of "+toSearch+" is "+search.binarySearch(low, high, inputArray, toSearch));
    }
}
