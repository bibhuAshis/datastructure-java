package testPackage.tree;

/**
 * Created by bajmd on 06/04/17.
 */
class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;

    // Constructor
    public TreeNode (int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getData() {
        return this.data;
    }

    public TreeNode getleft() {
        return this.left;
    }

    public TreeNode getRight() {
        return this.right;
    }
}
public class BinaryTree {
    // PreOrder Traversal
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data);
            System.out.print(" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // InOrder Traversal
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data);
            System.out.print(" ");
            inOrder(root.right);
        }
    }

    // PostOrder Traversal
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data);
            System.out.print(" ");
        }
    }

    // LevelOrder Traversal
    public void levelOrder(TreeNode root) {
        TreeQueue queue = new TreeQueue(10);
        TreeNode temp = root;
        while (temp != null) {
            System.out.print(temp.data);
            System.out.print(" ");
            queue.enqueue(temp.left);
            queue.enqueue(temp.right);
            temp = queue.dequeue();
        }
    }

    public static void main (String args[]) {
        // Create a binary tree
        TreeNode root, left_child, right_child, left_left_child, left_right_child, right_left_child, right_right_child;

        root = new TreeNode(1, null, null);
        left_child = new TreeNode(2, null, null);
        right_child = new TreeNode(3, null, null);
        left_left_child = new TreeNode(4, null, null);
        left_right_child = new TreeNode(5, null, null);
        right_left_child = new TreeNode(6, null, null);
        right_right_child  = new TreeNode(7, null, null);

        root.left = left_child;
        root.right = right_child;
        left_child.left = left_left_child;
        left_child.right = left_right_child;
        right_child.left = right_left_child;
        right_child.right = right_right_child;

        BinaryTree tree = new BinaryTree();
        tree.preOrder(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.levelOrder(root);
    }
}
