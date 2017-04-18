package testPackage.tree;

/**
 * Created by bajmd on 09/04/17.
 */
public class SearchElement {
    // Recursive
    public boolean searchElement(TreeNode root, int value) {
        if (root != null) {
            if (root.data == value)
                return true;
            else
                return (searchElement(root.left, value) || searchElement(root.right, value));
        }
        else
            return false;
    }

    // Iterative
    public boolean searchElementAlt (TreeNode root, int value) {
        TreeQueue queue = new TreeQueue(10);
        queue.enqueue(root);
        boolean found = false;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.dequeue();
            if (temp.data == value) {
                found = true;
                break;
            }
            if (temp.left != null)
                queue.enqueue(temp.left);
            if (temp.right != null)
                queue.enqueue(temp.right);
        }
        return found;
    }

    public static void main (String args[]) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        tree.createTree(root);

        SearchElement element = new SearchElement();
        boolean exists = element.searchElement(root, 3);
        boolean exists1 = element.searchElementAlt(root, 15);
        System.out.println(exists);
        System.out.println(exists1);
    }
}
