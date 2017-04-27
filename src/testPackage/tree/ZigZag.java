package testPackage.tree;

import testPackage.stack.Stack;

/**
 * Created by bajmd on 26/04/17.
 */
public class ZigZag {
    void zigzagTraversal (TreeNode root) {
        TreeStack stack1 = new TreeStack(10);
        TreeStack stack2 = new TreeStack(10);
        stack1.push(root);
        TreeNode temp;
        if (root == null)
            return;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                temp = stack1.pop();
                System.out.print(temp.data + " ");
                if (temp.right != null)
                    stack2.push(temp.right);
                if (temp.left != null)
                    stack2.push(temp.left);
            }
            while (!stack2.isEmpty()) {
                temp = stack2.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    stack1.push(temp.left);
                if (temp.right != null)
                    stack1.push(temp.right);
            }
        }
    }

    public static void main (String args[]) {
        TreeNode root  = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        ZigZag zigzag = new ZigZag();
        zigzag.zigzagTraversal(root);
    }
}
