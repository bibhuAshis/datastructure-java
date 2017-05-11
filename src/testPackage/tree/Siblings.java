package testPackage.tree;

/**
 * Created by bajmd on 10/05/17.
 */
public class Siblings {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);
        Siblings siblings = new Siblings();
        siblings.setSiblings(root);
        siblings.printSiblings(root);
    }

    public void setSiblings(TreeNode root) {
        if (root == null)
            return;
        if (root.getleft() != null)
            root.getleft().setSibling(root.getRight());
        if (root.getRight() != null) {
            if (root.getSibling() != null)
                root.getRight().setSibling(root.getSibling().getleft());
            else
                root.getRight().setSibling(null);
        }
        setSiblings(root.getleft());
        setSiblings(root.getRight());
    }

    public void printSiblings(TreeNode root) {
        if (root == null)
            return;
        if (root.getleft() != null)
            if (root.getleft().getSibling() != null)
                System.out.println(root.getleft().getData() + "->" +root.getleft().getSibling().getData());
        if (root.getRight() != null)
            if (root.getRight().getSibling() != null)
                System.out.println(root.getRight().getData() + "->" +root.getRight().getSibling().getData());
        printSiblings(root.getleft());
        printSiblings(root.getRight());
    }
}
