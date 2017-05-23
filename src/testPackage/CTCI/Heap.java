package testPackage.CTCI;

/**
 * Created by bajmd on 19/05/17.
 */

public class Heap {
    int size = 0;

    private int getParentIndex (int childIndex) {
        return (childIndex-1)/2;
    }

    private boolean hasParent (int index) {
        return (getParentIndex(index) >= 0);
    }

    private int parent (int index, int[] minHeap) {
        return minHeap[getParentIndex(index)];
    }

    private void swap (int index1, int index2, int[] minHeap) {
        int temp = minHeap[index1];
        minHeap[index1] = minHeap[index2];
        minHeap[index2] = temp;
    }

    private void heapifyUp (int[] minHeap) {
        int index = size-1;
        while (hasParent(index) && parent(index, minHeap) > minHeap[index]) {
            swap(getParentIndex(index), index, minHeap);
            index = getParentIndex(index);
        }
    }

    private int[] addtoHeap (int element, int capacity) {
        int[] minHeap = new int[capacity];
        minHeap[size] = element;
        size++;
        heapifyUp(minHeap);
        return minHeap;
    }

    private double findMedian (int[] minHeap) {
        double median = 0;
        if(size %2 != 0) {
            median = minHeap[size/2];
            return median;
        }
        else {
            median = 0.5*(minHeap[size/2]+minHeap[(size/2)-1]);
            return median;
        }
    }

    public static void main(String[] args) {
        Heap obj = new Heap();
        //Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        int[] a = {1,2,3};//new int[n];
        for(int a_i=0; a_i < 3; a_i++){
            //a[a_i] = in.nextInt();
            int[] heap = obj.addtoHeap(a[a_i], 3);
            System.out.println(obj.findMedian(heap));
        }
    }
}
