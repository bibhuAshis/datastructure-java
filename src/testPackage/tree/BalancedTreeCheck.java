package testPackage.tree;

/**
 * Created by bajmd on 26/04/17.
 */
public class BalancedTreeCheck {
    boolean checkBalance (TreeNode root) {
        if (root == null)
            return true;
        if (getBalanceFactor(root) >= 0)
            return true;
        else
            return false;
    }

    int getBalanceFactor (TreeNode root) {
        if (root == null)
            return 0;
        int getLeftBalanceFactor = getBalanceFactor (root.getleft());
        if (getLeftBalanceFactor == -1)
            return -1;
        int getRightBalanceFactor = getBalanceFactor (root.getRight());
        if (getRightBalanceFactor == -1)
            return -1;
        int diff = getLeftBalanceFactor - getRightBalanceFactor;
        if (Math.abs(diff) > 1)
            return -1;
        return (1 + Math.max(getLeftBalanceFactor, getRightBalanceFactor));
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        BalancedTreeCheck balanced = new BalancedTreeCheck();
        if (balanced.checkBalance(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
