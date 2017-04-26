package testPackage.tree;

/**
 * Created by bajmd on 25/04/17.
 */
public class PathWithSum {
    boolean rootLeafPaths(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.getleft() == null && root.getRight() == null && root.getData() == sum)
            return true;
        else {
            return (rootLeafPaths(root.left, sum-root.getData()) ||
            rootLeafPaths(root.right, sum-root.getData()));
        }
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);
        int sum = 10;

        PathWithSum sumPath = new PathWithSum();
        boolean result = sumPath.rootLeafPaths(root, sum);
        if (result)
            System.out.println("There exists a path with given sum");
        else
            System.out.println("There doesn't exist a path with given sum");
    }
}
