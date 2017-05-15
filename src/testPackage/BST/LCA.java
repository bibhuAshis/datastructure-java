package testPackage.BST;

/**
 * Created by bajmd on 15/05/17.
 */
public class LCA {
    public static void main(String args[]) {
        BSTNode root = new BSTNode(4);
        BinarySearchTree tree = new BinarySearchTree();
        tree.createBST(root);

        LCA lcaObj = new LCA();
        System.out.println(lcaObj.findLCA(root, 1, 7));
    }

    public int findLCA (BSTNode root, int num1, int num2) {
        if (root == null)
            return 0;
        if (root.getData() == num1 || root.getData() == num2)
            return root.getData();
        if (Math.max(num1, num2) < root.getData())
            return findLCA(root.getleft(), num1, num2);
        else if (Math.min(num1, num2) > root.getData())
            return findLCA(root.getRight(), num1, num2);
        else
            return root.getData();
    }
}
