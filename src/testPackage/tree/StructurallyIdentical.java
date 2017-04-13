package testPackage.tree;

/**
 * Created by bajmd on 13/04/17.
 */
public class StructurallyIdentical {
    boolean findIdentical (TreeNode root, TreeNode newroot) {
        if (root == null && newroot == null)
            return true;
        if ((root == null && newroot != null) || (root != null && newroot == null))
            return false;
        return (findIdentical(root.getleft(), newroot.getleft()) && findIdentical(root.getRight(), newroot.getRight()));
    }

    public static void main (String args []) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        TreeNode newroot = new TreeNode(8);
        BinaryTree newtree = new BinaryTree();
        newtree.createTree(newroot);

        StructurallyIdentical nodes = new StructurallyIdentical();
        boolean isIdentical = nodes.findIdentical(root, newroot);
        System.out.println(isIdentical);
    }
}