package testPackage.tree;

/**
 * Created by bajmd on 13/04/17.
 */
public class HeightOfTree {
    int findHeight (TreeNode root) {
        int heightLeft = 0, heightRight = 0, height =0;
        if (root != null) {
            heightLeft = findHeight(root.getleft());
            heightRight = findHeight(root.getRight());
            if (heightLeft >= heightRight)
                height = heightLeft + 1;
            else
                height = heightRight + 1;
        }
        return height;
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        HeightOfTree height = new HeightOfTree();
        int treeHeight = height.findHeight(root);
        System.out.println("Height of tree is " +treeHeight);
    }
}
