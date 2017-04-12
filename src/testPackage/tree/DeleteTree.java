package testPackage.tree;

/**
 * Created by bajmd on 12/04/17.
 */
public class DeleteTree {
    TreeNode deleteTree(TreeNode root) {
        if (root != null) {
            deleteTree(root.left);
            deleteTree(root.right);
            root = null;
        }
        return root;
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);
        tree.inOrder(root);

        DeleteTree delete = new DeleteTree();
        TreeNode deleted_root = delete.deleteTree(root);
        tree.inOrder(deleted_root);
    }
}
