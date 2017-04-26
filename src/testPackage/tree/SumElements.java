package testPackage.tree;

/**
 * Created by bajmd on 25/04/17.
 */
public class SumElements {
    int findSum (TreeNode root) {
        int sum = 0;
        if (root == null)
            return 0;
        else
            return (sum + root.getData() + findSum(root.getleft()) + findSum(root.getRight()));
    }
    void findSumAlt(TreeNode root) {
        int sum = 0;
        TreeQueue queue = new TreeQueue(10);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.dequeue();
            sum = sum + temp.getData();
            if (temp.getleft() != null)
                queue.enqueue(temp.getleft());
            if (temp.getRight() != null)
                queue.enqueue(temp.getRight());
        }
        System.out.println("Sum of all elements is - " +sum);
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        SumElements sum = new SumElements();
        int result = sum.findSum(root);
        System.out.println("Sum of all elements is : " +result);
        sum.findSumAlt(root);
    }
}
