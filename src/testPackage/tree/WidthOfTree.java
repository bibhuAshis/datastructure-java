package testPackage.tree;

/**
 * Created by bajmd on 16/04/17.
 */
public class WidthOfTree {
    int findWidth (TreeNode root) {
        int result = 0;
        if (root == null)
            return 0;

        TreeQueue queue = new TreeQueue(10);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            result = Math.max(count, result);

            while (count-- != 0) {
                TreeNode temp = queue.dequeue();

                if (temp.getleft() != null)
                    queue.enqueue(temp.left);
                if (temp.getRight() != null)
                    queue.enqueue(temp.right);
            }
        }
        return result;
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        WidthOfTree obj = new WidthOfTree();
        int width = obj.findWidth(root);
        System.out.println("The width of the tree is: " +width);
    }
}
