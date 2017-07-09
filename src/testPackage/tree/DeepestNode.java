package testPackage.tree;

import testPackage.stack.Stack;

/**
 * Created by bajmd on 13/04/17.
 */
public class DeepestNode {
    void findDeepestNode (TreeNode root) {
        TreeQueue queue = new TreeQueue(10);
        queue.enqueue(root);
        int deep = 0;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.dequeue();
            deep = temp.getData();
            if (temp.left != null)
                queue.enqueue(temp.getleft());
            if (temp.right != null)
                queue.enqueue(temp.getRight());
        }
        System.out.println("Deepest node is " +deep);
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        DeepestNode node = new DeepestNode();
        node.findDeepestNode(root);
    }
}
