package testPackage.tree;

import testPackage.stack.Stack;

/**
 * Created by bajmd on 13/04/17.
 */
public class DeepestNode {
    void findDeepestNode (TreeNode root) {
        TreeQueue queue = new TreeQueue(10);
        Stack stack = new Stack(10);
        TreeNode temp = root;

        while (temp != null) {
            stack.push(temp.getData());
            if (temp.left != null)
                queue.enqueue(temp.getleft());
            if (temp.right != null)
                queue.enqueue(temp.getRight());
            temp = queue.dequeue();
        }
        System.out.println("Deepest node is " +stack.peek());
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        DeepestNode node = new DeepestNode();
        node.findDeepestNode(root);
    }
}
