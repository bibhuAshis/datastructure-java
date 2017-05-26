package testPackage.BST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bajmd on 25/05/17.
 */
public class KthSmallest {
    public static void main(String args[]) {
        Queue<Integer> queue= new LinkedList<Integer>();
        BSTNode root = new BSTNode(1);
        BinarySearchTree tree = new BinarySearchTree();
        tree.createBST(root);
        int k = 1;
        KthSmallest smallest = new KthSmallest();
        smallest.inOrder(root, queue);
        System.out.println(smallest.findKthSmallest(queue, k));
    }

    public void inOrder(BSTNode root, Queue<Integer> queue) {
        if (root != null) {
            inOrder(root.getleft(), queue);
            queue.add(root.getData());
            inOrder(root.getRight(), queue);
        }
    }

    public int findKthSmallest(Queue<Integer> queue, int k) {
        int result = 0;
        while(!queue.isEmpty() && k>0) {
            result = queue.poll();
            k--;
        }
        return result;
    }
}
