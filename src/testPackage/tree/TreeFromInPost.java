package testPackage.tree;

/**
 * Created by bajmd on 26/04/17.
 */
public class TreeFromInPost {
    TreeNode constructTree (int[] inorder, int[] postorder) {
        if (inorder.length == 0 || inorder.length != postorder.length)
            return null;
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    TreeNode buildTree (int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int offset = inStart;
        while (inorder[offset] != root.getData())
            offset++;
        root.left = buildTree(inorder, inStart, offset-1, postorder, postStart, postStart+offset-inStart-1);
        root.right = buildTree(inorder, offset+1, inEnd, postorder, postStart+offset-inStart, postEnd-1);
        return root;
    }

    public static void main (String args[]) {
        int[] inOrder = {6,4,7,2,8,5,9,1,3};
        int[] postOrder = {6,7,4,8,9,5,2,3,1};
        TreeFromInPost tree = new TreeFromInPost();
        TreeNode root = tree.constructTree(inOrder, postOrder);

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
