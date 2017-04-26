package testPackage.tree;

/**
 * Created by bajmd on 26/04/17.
 */
public class FirstCommonAncester {
    int commonAncester (TreeNode root, int node1, int node2) {
        if (root == null)
            return 0;
        if (root.getData() == node1 || root.getData() == node2)
            return root.data;
        int left = commonAncester(root.left, node1, node2);
        int right = commonAncester(root.right, node1, node2);
        if (left != 0 && right != 0)
            return root.getData();
        else {
            if (left != 0)
                return left;
            else
                return right;
        }
    }

    public static void main (String args[]) {
        TreeNode root  = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);
        int node1 = 3;
        int node2 = 7;

        FirstCommonAncester ancester = new FirstCommonAncester();
        int result = ancester.commonAncester(root, node1, node2);
        System.out.println("Common ancester node is: " +result);
    }
}
