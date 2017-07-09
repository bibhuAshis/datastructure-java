package testPackage.tree;

/**
 * Created by bajmd on 26/04/17.
 */
public class BalancedTreeCheck {
    //boolean
    int checkBalance (TreeNode root) {
        int MaxDepth = findMaxDepth (root);
        int MinDepth = findMinDepth (root);
        return (MaxDepth - MinDepth);
    }

    int findMaxDepth (TreeNode root) {
        if (root == null)
            return 0;
        else
            return (1 + Math.max(findMaxDepth(root.getleft()), findMaxDepth(root.getRight())));
    }

    int findMinDepth (TreeNode root) {
        if (root == null)
            return 0;
        else
            return (1 + Math.min(findMinDepth(root.getleft()), findMinDepth(root.getRight())));
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        BalancedTreeCheck balanced = new BalancedTreeCheck();
        //System.out.println(balanced.checkBalance(root));
        int result = balanced.checkBalance(root);
        if (result <= 1)
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
