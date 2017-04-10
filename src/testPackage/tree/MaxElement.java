package testPackage.tree;

/**
 * Created by bajmd on 09/04/17.
 */
public class MaxElement {
    public int findMax(TreeNode root) {
        int Max = 0;
        if (root != null) {
            int Max_Left = findMax(root.left);
            int Max_Right = findMax(root.right);

            if (Max_Left >= Max_Right)
                Max = Max_Left;
            else
                Max = Max_Right;
            if (root.data > Max)
                Max = root.data;
        }
        return Max;
    }

    public int findMaxAlt(TreeNode root) {
        TreeQueue queue = new TreeQueue(10);
        TreeNode temp = root;
        int Max = 0;
        while (temp != null) {
            if (temp.data > Max)
                Max = temp.data;
            if (temp.left != null)
                queue.enqueue(temp.left);
            if (temp.right != null)
                queue.enqueue(temp.right);
            temp = queue.dequeue();
        }
        return Max;
    }

    public static void main (String args[]) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        tree.createTree(root);

        MaxElement element = new MaxElement();
        int MaxOfTree = element.findMax(root);
        int MaxOfTreeAlt = element.findMaxAlt(root);
        System.out.println("Max element of tree is: "+MaxOfTree);
        System.out.println("Max element of tree is: "+MaxOfTreeAlt);
    }
}
