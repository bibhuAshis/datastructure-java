package testPackage.tree;

/**
 * Created by bajmd on 13/04/17.
 */
public class HeightOfTree {
    int findHeight (TreeNode root) {
        if (root == null)
            return 0;
        else
            return (1 + Math.max(findHeight(root.getleft()), findHeight(root.getRight())));
    }

    void findHeightAlt (TreeNode root) {
        TreeQueue queue = new TreeQueue(10);
        queue.enqueue(root);

        int height = 0;

        while (!queue.isEmpty()) {
            int count = queue.size();

            while (count-- != 0) {
                TreeNode temp = queue.dequeue();

                if (temp.getleft() != null)
                    queue.enqueue(temp.left);
                if (temp.getRight() != null)
                    queue.enqueue(temp.right);
            }
            height++;
        }

        System.out.println("Height of tree is " +height);
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        HeightOfTree height = new HeightOfTree();
        height.findHeightAlt(root);
        int treeHeight = height.findHeight(root);
        System.out.println("Height of tree is " +treeHeight);
    }
}
