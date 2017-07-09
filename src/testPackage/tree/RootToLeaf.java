package testPackage.tree;

/**
 * Created by bajmd on 25/04/17.
 */
public class RootToLeaf {
    void rootLeafPaths(TreeNode root, int[] pathArray, int pathLen) {
        if (root == null)
            return;
        pathArray[pathLen] = root.getData();
        pathLen++;
        if (root.getleft() == null && root.getRight()== null)
            printPaths(pathArray, pathLen);
        else {
            rootLeafPaths(root.getleft(), pathArray, pathLen);
            rootLeafPaths(root.getRight(), pathArray, pathLen);
        }
    }

    void printPaths (int[] path, int Len) {
        for (int i=0; i<Len; i++)
            System.out.print(path[i] + " ");
        System.out.println();
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        RootToLeaf printPath = new RootToLeaf();
        int pathArray[] = new int[3];
        printPath.rootLeafPaths(root, pathArray, 0);
    }
}
