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
        /*if (root == null)
            return true;
        else {
            int leftHeight = findHeight(root.getleft());
            int rightHeight = findHeight(root.getRight());
            if (Math.abs(leftHeight - rightHeight) > 1)
                return false;
            else
                return (true && checkBalance(root.getleft()) && checkBalance(root.getRight()));
        }*/
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

    int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        else
            return (1 + Math.max(findHeight(root.getRight()), findHeight(root.getleft())));
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
