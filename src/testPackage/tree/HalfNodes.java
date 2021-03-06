package testPackage.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bajmd on 13/04/17.
 */
public class HalfNodes {
    void halfNodes (TreeNode root) {
        //TreeQueue queue = new TreeQueue(10);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if ((temp.getleft() != null && temp.getRight() == null) || (temp.getleft() == null && temp.getRight() != null))
                count++;
            if (temp.left != null)
                queue.offer(temp.getleft());
            if (temp.right != null)
                queue.offer(temp.getRight());
        }
        System.out.println("Number of half nodes is/are " +count);
    }

    public static void main (String args []) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        HalfNodes nodes = new HalfNodes();
        nodes.halfNodes(root);
    }
}
