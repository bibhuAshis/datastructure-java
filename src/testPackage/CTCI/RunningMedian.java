package testPackage.CTCI;

/**
 * Created by bajmd on 22/05/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedian {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());

    public void addToHeaps(int element) {
        if (maxHeap.isEmpty() || element < maxHeap.peek())
            maxHeap.offer(element);
        else
            minHeap.offer(element);
    }

    public void balanceHeaps() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize - minHeapSize >= 2)
            minHeap.offer(maxHeap.poll());
        else if (minHeapSize - maxHeapSize >= 2)
            maxHeap.offer(minHeap.poll());
    }

    public double getMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize > minHeapSize)
            return maxHeap.peek();
        else if (minHeapSize > maxHeapSize)
            return minHeap.peek();
        else {
            double median = 0.5*(maxHeap.peek() + minHeap.peek());
            return median;
        }
    }

    public double findMedian(int element) {
        addToHeaps(element);
        balanceHeaps();
        double runningMedian = getMedian();
        return runningMedian;
    }

    public static void main(String[] args) {
        RunningMedian obj = new RunningMedian();
        System.out.println(obj.findMedian(1));
        System.out.println(obj.findMedian(2));
        System.out.println(obj.findMedian(3));
        System.out.println(obj.findMedian(4));
        System.out.println(obj.findMedian(5));
        System.out.println(obj.findMedian(6));
        System.out.println(obj.findMedian(7));
        System.out.println(obj.findMedian(8));
        System.out.println(obj.findMedian(9));
        System.out.println(obj.findMedian(10));
    }
}

