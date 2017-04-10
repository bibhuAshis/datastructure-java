package testPackage.tree;

/**
 * Created by bajmd on 09/04/17.
 */
public class InsertElement {
    public TreeNode insert(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
            return root;
        }
        else {
            TreeQueue queue = new TreeQueue(10);
            TreeNode tmp = root;
            queue.enqueue(tmp);
            while (tmp != null) {
                if (tmp.left == null) {
                    tmp.left = node;
                    break;
                }
                else if (tmp.right == null) {
                    tmp.right = node;
                    break;
                }
                queue.enqueue(tmp.left);
                queue.enqueue(tmp.right);
                tmp = queue.dequeue();
            }
            return root;
        }
    }

    public static void main (String args []) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        tree.createTree(root);

        InsertElement element = new InsertElement();
        TreeNode newRoot = element.insert(root, new TreeNode(10));
        tree.levelOrder(newRoot);
    }
}
