package testPackage.BST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bajmd on 15/05/17.
 */
public class VerifyBST {
    public static void main(String args[]) {
        BSTNode root = new BSTNode(4);
        BinarySearchTree tree = new BinarySearchTree();
        tree.createBST(root);

        VerifyBST BSTObj = new VerifyBST();
        System.out.println(BSTObj.isBST(root));
    }

    public boolean isBST (BSTNode root) {
        Queue<Integer> queue = new LinkedList<>();
        int a, b;
        if (root == null)
            return true;
        inOrder (root, queue);
        while (!queue.isEmpty()) {
            a = queue.poll();
            if (!queue.isEmpty()) {
                b = queue.poll();
                if (a > b)
                    return false;
            }
        }
        return true;
    }

    public Queue inOrder(BSTNode root, Queue queue) {
        if (root == null)
            return null;
        else {
            inOrder(root.getleft(), queue);
            System.out.println(root.getData());
            queue.add(root.getData());
            inOrder(root.getRight(), queue);
        }
        return queue;
    }
}
