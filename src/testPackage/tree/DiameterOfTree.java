package testPackage.tree;

/**
 * Created by bajmd on 16/04/17.
 */
class Height {
    int h;
}
public class DiameterOfTree {
    int findDiameter (TreeNode root, Height height) {
        int left_Diameter, right_Diameter;
        Height left_Height = new Height();
        Height right_Height = new Height();

        if (root == null) {
            height.h = 0;
            return 0;
        }

        left_Diameter = findDiameter(root.getleft(), left_Height);
        right_Diameter = findDiameter(root.getRight(), right_Height);

        height.h = Math.max(left_Height.h, right_Height.h) + 1;
        return Math.max(left_Height.h + right_Height.h + 1, Math.max(left_Diameter, right_Diameter));
    }
    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);
        int diameter;
        Height height = new Height();

        DiameterOfTree obj = new DiameterOfTree();
        diameter = obj.findDiameter(root, height);
        System.out.println("Diameter of tree is: " +diameter);
    }
}
