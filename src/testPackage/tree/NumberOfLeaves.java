package testPackage.tree;

/**
 * Created by bajmd on 13/04/17.
 */
public class NumberOfLeaves {
    void findLeaves (TreeNode root) {
        TreeQueue queue = new TreeQueue(10);
        queue.enqueue(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.dequeue();
            if (temp.getleft() == null && temp.getRight() == null)
                count++;
            if (temp.left != null)
                queue.enqueue(temp.getleft());
            if (temp.right != null)
                queue.enqueue(temp.getRight());
        }
        System.out.println("Number of leaves is/are " +count);
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        NumberOfLeaves leaves = new NumberOfLeaves();
        leaves.findLeaves(root);
    }
}
