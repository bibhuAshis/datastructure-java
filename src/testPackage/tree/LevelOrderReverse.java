package testPackage.tree;

import testPackage.stack.Stack;

/**
 * Created by bajmd on 12/04/17.
 */
public class LevelOrderReverse {
    void levelOrderReverse (TreeNode root) {
        TreeNode temp = root;
        TreeQueue queue = new TreeQueue(10);
        Stack stack = new Stack(10);
        while (temp != null) {
            stack.push(temp.getData());
            if (temp.right != null)
                queue.enqueue(temp.getRight());
            if (temp.left != null)
                queue.enqueue(temp.getleft());
            temp = queue.dequeue();
        }
        while (!stack.isEmpty())
            stack.pop();
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        LevelOrderReverse reverse = new LevelOrderReverse();
        reverse.levelOrderReverse(root);
    }
}
