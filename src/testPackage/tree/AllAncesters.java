package testPackage.tree;

/**
 * Created by bajmd on 26/04/17.
 */
public class AllAncesters {
    boolean printAncesters (TreeNode root, int node) {
        if (root == null)
            return false;
        if (root.getData() == node || printAncesters(root.getleft(), node) || printAncesters(root.getRight(), node)) {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);
        int node = 3;

        AllAncesters ancesters = new AllAncesters();
        ancesters.printAncesters(root, node);
    }
}
