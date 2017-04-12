package testPackage.tree;

/**
 * Created by bajmd on 09/04/17.
 */
public class InsertElement {
    // Iterative
    public TreeNode insert(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
            return root;
        }
        else {
            TreeQueue queue = new TreeQueue(10);
            TreeNode temp = root;
            queue.enqueue(temp);
            while (temp != null) {
                if (temp.left == null) {
                    temp.left = node;
                    break;
                }
                else if (temp.right == null) {
                    temp.right = node;
                    break;
                }
                if (temp.left != null)
                    queue.enqueue(temp.left);
                if (temp.right != null)
                    queue.enqueue(temp.right);
                temp = queue.dequeue();
            }
            return root;
        }
    }

    // Recursive
    public TreeNode insertAlt(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
        }
        else {
            if (root.left == null)
                root.left = node;
            else
                insertAlt(root.right, node);
        }
        return root;
    }

    public static void main (String args []) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        tree.createTree(root);

        InsertElement element = new InsertElement();
        TreeNode newRootAlt = element.insertAlt(root, new TreeNode(10));
        tree.levelOrder(newRootAlt);
        TreeNode newRoot = element.insert(root, new TreeNode(10));
        tree.levelOrder(newRoot);
    }
}
