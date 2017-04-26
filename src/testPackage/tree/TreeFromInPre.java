package testPackage.tree;

/**
 * Created by bajmd on 26/04/17.
 */
public class TreeFromInPre {
    TreeNode costructTree (int[] inorder, int[] preorder) {
        if (inorder.length == 0 || inorder.length != preorder.length)
            return null;
        return buildTree (inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
    }

    TreeNode buildTree (int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int offset = inStart;
        while (inorder[offset] != root.getData())
            offset++;
        root.left = buildTree(inorder, inStart, offset-1, preorder, preStart+1, preStart+offset-inStart);
        root.right = buildTree(inorder, offset+1, inEnd, preorder, preStart+offset-inStart+1, preEnd);
        return root;
    }

    public static void main (String args[]) {
        int[] inorder = {6,4,7,2,8,5,9,1,3};
        int[] preorder = {1,2,4,6,7,5,8,9,3};
        TreeFromInPre tree = new TreeFromInPre();
        TreeNode root = tree.costructTree(inorder, preorder);
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
}
