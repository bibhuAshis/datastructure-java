package testPackage.searching;

/**
 * Created by bajmd on 03/05/17.
 */
public class BitonicSearch {
    public static void main (String args[]) {
        BitonicSearch search = new BitonicSearch();
        int[] inputArray = {2, 3, 5, 4, 1};
        int element = 1;
        int pivot = search.findPivot(inputArray, 0, inputArray.length-1);
        boolean result = search.searchElement(inputArray, pivot, 0, inputArray.length-1, element);
        System.out.println(result);
    }

    public int findPivot(int[] arr, int low, int high) {
        if (low <= high) {
            int mid = (high+low) / 2;
            if (mid-1 < 0 || mid+1 > arr.length-1)
                return mid;
            else if ((arr[mid-1] < arr[mid]) && (arr[mid+1] < arr[mid]))
                return mid;
            else if ((arr[mid-1] < arr[mid]) && (arr[mid+1] > arr[mid]))
                return findPivot(arr, mid+1, high);
            else
                return findPivot(arr, low, mid-1);
        }
        return -1;
    }

    public boolean searchElement(int[] arr, int p, int l, int h, int element)  {
        if (p<0 || p>arr.length-1)
            return false;
        else if (arr[p] == element)
            return true;
        else
            return (binSearch1(l, p-1, arr, element) || binSearch2(p+1, h, arr, element));
    }

    public boolean binSearch1(int low, int high, int[] arr, int element) {
        if (low <= high ) {
            int mid = (low+high) / 2;
            if (arr[mid] == element)
                return true;
            else if(element < arr[mid])
                return (binSearch1(low, mid-1, arr, element));
            else
                return (binSearch1(mid+1, high, arr, element));
        }
        return false;
    }

    public boolean binSearch2(int low, int high, int[] arr, int element) {
        if (low <= high ) {
            int mid = (low+high) / 2;
            if (arr[mid] == element)
                return true;
            else if(element > arr[mid])
                return (binSearch2(low, mid-1, arr, element));
            else
                return (binSearch2(mid+1, high, arr, element));
        }
        return false;
    }
}
