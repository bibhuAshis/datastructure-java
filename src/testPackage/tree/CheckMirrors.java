package testPackage.tree;

/**
 * Created by bajmd on 26/04/17.
 */
public class CheckMirrors {
    boolean checkMirrors (TreeNode root, TreeNode newroot) {
        if (root == null && newroot == null)
            return true;
        if (root.getData() != newroot.getData())
            return false;
        else
            return (checkMirrors(root.getleft(), newroot.getRight()) && checkMirrors(root.getRight(), newroot.getleft()));
    }

    public static void main (String args[]) {
        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(1);
        tree.createTree(root);

        TreeNode newroot = new TreeNode(1);
        tree.createMirrorTree(newroot);

        CheckMirrors mirror = new CheckMirrors();
        Boolean result = mirror.checkMirrors(root, newroot);
        if (result)
            System.out.println("The trees are mirrors");
        else
            System.out.println("The trees are not mirrors");
    }
}
