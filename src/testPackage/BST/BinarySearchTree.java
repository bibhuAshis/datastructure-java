package testPackage.BST;

/**
 * Created by bajmd on 06/04/17.
 */
class BSTNode{
    public int data;
    public BSTNode left;
    public BSTNode right;
    public BSTNode sibling;

    // Constructors
    public BSTNode (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.sibling = null;
    }

    public BSTNode (int data, BSTNode left, BSTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public void setSibling(BSTNode sibling) {
        this.sibling = sibling;
    }

    public int getData() {
        return this.data;
    }

    public BSTNode getleft() {
        return this.left;
    }

    public BSTNode getRight() {
        return this.right;
    }

    public BSTNode getSibling() {
        return this.sibling;
    }
}
public class BinarySearchTree {
    // Create Tree
    public void createBST (BSTNode root) {
        BSTNode left_child, right_child, left_left_child, left_right_child, right_left_child, right_right_child;

        left_child = new BSTNode(2, null, null);
        right_child = new BSTNode(6, null, null);
        left_left_child = new BSTNode(1, null, null);
        left_right_child = new BSTNode(3, null, null);
        right_left_child = new BSTNode(5, null, null);
        right_right_child  = new BSTNode(7, null, null);

        root.left = left_child;
        root.right = right_child;
        left_child.left = left_left_child;
        left_child.right = left_right_child;
        right_child.left = right_left_child;
        right_child.right = right_right_child;
    }

    // PreOrder Traversal
    public void preOrderBST(BSTNode root) {
        if (root != null) {
            System.out.print(root.data);
            System.out.print(" ");
            preOrderBST(root.left);
            preOrderBST(root.right);
        }
    }

    // InOrder Traversal
    public void inOrderBST(BSTNode root) {
        if (root != null) {
            inOrderBST(root.left);
            System.out.print(root.data);
            System.out.print(" ");
            inOrderBST(root.right);
        }
    }

    // PostOrder Traversal
    public void postOrderBST(BSTNode root) {
        if (root != null) {
            postOrderBST(root.left);
            postOrderBST(root.right);
            System.out.print(root.data);
            System.out.print(" ");
        }
    }

    public static void main (String args[]) {
        BinarySearchTree tree = new BinarySearchTree();
        BSTNode root = new BSTNode(4);
        tree.createBST(root);

        tree.preOrderBST(root);
        System.out.println();
        tree.inOrderBST(root);
        System.out.println();
        tree.postOrderBST(root);
        System.out.println();
    }
}
