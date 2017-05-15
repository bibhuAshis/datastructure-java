package testPackage.tree;

/**
 * Created by bajmd on 16/04/17.
 */

public class DiameterOfTree {
    int findDiameter (TreeNode root) {
        int left_Diameter, right_Diameter, left_Height, right_Height;

        if (root == null) {
            return 0;
        }
        else {
            left_Height = findHeight(root.getleft());
            right_Height = findHeight(root.getRight());
            left_Diameter = findDiameter(root.getleft());
            right_Diameter = findDiameter(root.getRight());
            return Math.max(left_Height + right_Height + 1, Math.max(left_Diameter, right_Diameter));
        }
    }

    int findHeight (TreeNode root) {
        if (root == null)
            return 0;
        else
            return (1 + Math.max(findHeight(root.getleft()), findHeight(root.getRight())));
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        DiameterOfTree obj = new DiameterOfTree();
        System.out.println("Diameter of tree is: " +obj.findDiameter(root));
    }
}
