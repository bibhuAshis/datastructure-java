package testPackage.tree;

/**
 * Created by bajmd on 20/04/17.
 */
public class LevelWithMaxSum {
    void findLevelWithMAxSum (TreeNode root) {
        int sum = 0, level = 0, level_max = 0;
        TreeQueue queue = new TreeQueue(10);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            level++;
            int level_sum = 0;
            while (count-- != 0) {
                TreeNode temp = queue.dequeue();
                level_sum = level_sum + temp.data;

                if (temp.getleft() != null)
                    queue.enqueue(temp.left);
                if (temp.getRight() != null)
                    queue.enqueue(temp.right);
            }
            if (level_sum > sum){
                sum = level_sum;
                level_max = level;
            }
        }
        System.out.println("The level with maximum sum is: " +level_max);
        System.out.println("Maximum sum is: " +sum);
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        LevelWithMaxSum level = new LevelWithMaxSum();
        level.findLevelWithMAxSum(root);
    }
}
