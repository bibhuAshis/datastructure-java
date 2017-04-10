package testPackage.tree;

/**
 * Created by bajmd on 09/04/17.
 */
public class SizeOfTree {
    public void treeSize (TreeNode root) {
        TreeQueue queue = new TreeQueue(10);
        TreeNode temp = root;
        int count = 0;
        while (temp != null) {
            if (temp.left != null)
                queue.enqueue(temp.left);
            if (temp.right != null)
                queue.enqueue(temp.right);
            temp = queue.dequeue();
            count++;
        }
        System.out.println("Size of the tree is " +count);
    }

    public int treeSizeAlt (TreeNode root) {
        int count = 0;
        if (root != null) {
            int count_left = treeSizeAlt(root.left);
            int count_right = treeSizeAlt(root.right);
            count = count_left + count_right + 1;
        }
        return count;
    }

    public static void main (String args[]) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        tree.createTree(root);

        SizeOfTree size = new SizeOfTree();
        size.treeSize(root);
        int treesize = size.treeSizeAlt(root);
        System.out.println("Size of the tree is " +treesize);
    }
}
