package testPackage.sorting;

/**
 * Created by bajmd on 03/05/17.
 */
public class MergeSort {

    void mergeSort(int[]arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    void merge(int[] arr, int l, int m, int h) {
        // Create 2 temp arrays
        int size1 = m-l+1;
        int size2 = h-m;
        int[] temp1 = new int[size1];
        int[] temp2 = new int[size2];

        // Copy the values of the subarrays to temp arrays
        for(int i=0; i<size1; i++)
            temp1[i] = arr[l+i];
        for (int j=0; j<size2; j++)
            temp2[j] = arr[m+1+j];

        // Merge the temp array values to array
        int i=0, j=0, k=l;

        while (i<size1 && j<size2) {
            if (temp1[i] < temp2[j]) {
                arr[k] = temp1[i];
                i++;
            }
            else {
                arr[k] = temp2[j];
                j++;
            }
            k++;
        }
        while (i<size1) {
            arr[k] = temp1[i];
            i++;
            k++;
        }
        while (j<size2) {
            arr[k] = temp2[j];
            j++;
            k++;
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main (String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
