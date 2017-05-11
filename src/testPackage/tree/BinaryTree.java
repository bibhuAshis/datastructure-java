package testPackage.tree;

/**
 * Created by bajmd on 06/04/17.
 */
class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode sibling;

    // Constructors
    public TreeNode (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.sibling = null;
    }

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

    public void setSibling(TreeNode sibling) {
        this.sibling = sibling;
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

    public TreeNode getSibling() {
        return this.sibling;
    }
}
public class BinaryTree {
    // Create Tree
    public void createTree (TreeNode root) {
        TreeNode left_child, right_child, left_left_child, left_right_child, right_left_child, right_right_child;

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
    }

    // Create Mirror Tree
    public void createMirrorTree (TreeNode root) {
        TreeNode left_child, right_child, left_left_child, left_right_child, right_left_child, right_right_child;

        left_child = new TreeNode(3, null, null);
        right_child = new TreeNode(2, null, null);
        left_left_child = new TreeNode(7, null, null);
        left_right_child = new TreeNode(6, null, null);
        right_left_child = new TreeNode(5, null, null);
        right_right_child  = new TreeNode(4, null, null);

        root.left = left_child;
        root.right = right_child;
        //left_child.left = left_left_child;
        //left_child.right = left_right_child;
        right_child.left = right_left_child;
        right_child.right = right_right_child;
    }


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
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.dequeue();
            System.out.print(temp.data);
            System.out.print(" ");
            if (temp.left != null)
                queue.enqueue(temp.left);
            if (temp.right != null)
                queue.enqueue(temp.right);
        }
    }

    public static void main (String args[]) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        tree.createTree(root);

        tree.preOrder(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.levelOrder(root);
    }
}
