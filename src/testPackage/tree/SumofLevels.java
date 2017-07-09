package testPackage.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bajmd on 09/07/17.
 */
public class SumofLevels {
    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        SumofLevels sum = new SumofLevels();
        sum.listOfSumofLevels(root);
    }

    public LinkedList<Integer> listOfSumofLevels(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null)
            return null;
        else {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int sum = 0;
                int size = queue.size();
                for (int i=0; i<size; i++) {
                    TreeNode tempNode = queue.poll();
                    sum += tempNode.getData();
                    if (tempNode.getleft() != null)
                        queue.offer(tempNode.getleft());
                    if (tempNode.getRight() != null)
                        queue.offer(tempNode.getRight());
                }
                list.add(sum);
            }
        }
        return list;
    }
}
