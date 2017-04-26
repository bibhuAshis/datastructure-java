package testPackage.tree;

/**
 * Created by bajmd on 25/04/17.
 */
public class CreateMirror {
    TreeNode createMirror (TreeNode root) {
        TreeNode newRoot;
        if (root == null)
            return null;
        else {
            createMirror(root.getleft());
            createMirror(root.getRight());
            newRoot = root.getleft();
            root.left = root.getRight();
            root.right = newRoot;
        }
        return root;
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);
        System.out.print("Tree is: ");
        tree.levelOrder(root);
        CreateMirror mirror = new CreateMirror();
        TreeNode newroot = mirror.createMirror(root);
        System.out.print("\nMirrored Tree is: ");
        tree.levelOrder(newroot);
    }
}
