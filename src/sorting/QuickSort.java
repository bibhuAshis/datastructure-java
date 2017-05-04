package sorting;

import java.util.Random;

/**
 * Created by bajmd on 03/05/17.
 */
public class QuickSort {

    void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    int partition(int arr[], int l, int h) {
        // Select random pivot
        Random rand = new Random();
        int randomIndex = l + rand.nextInt(h - l + 1);
        swap(arr, randomIndex, h);
        int pivotItem = arr[h];

        int i = (l-1); // index of smaller element
        for (int j=l; j<=h-1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivotItem) {
                i++;

                // swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        swap(arr, i+1, h);
        return i+1;
    }

    // swap method
    public static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};

        QuickSort ob = new QuickSort();
        ob.quickSort(arr, 0, arr.length-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
