package testPackage.tree;

/**
 * Created by bajmd on 09/04/17.
 */
public class SearchElement {
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

    public boolean searchElementAlt (TreeNode root, int value) {
        TreeNode temp = root;
        TreeQueue queue = new TreeQueue(10);
        queue.enqueue(temp);
        boolean found = false;
        while (temp != null) {
            if (temp.data == value)
                found = true;
            if (temp.left != null)
                queue.enqueue(temp.left);
            if (temp.right != null)
                queue.enqueue(temp.right);
            temp = queue.dequeue();
        }
        return found;
    }

    public static void main (String args[]) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        tree.createTree(root);

        SearchElement element = new SearchElement();
        boolean exists = element.searchElement(root, 3);
        boolean exists1 = element.searchElementAlt(root, 3);
        System.out.println(exists);
        System.out.println(exists1);
    }
}
