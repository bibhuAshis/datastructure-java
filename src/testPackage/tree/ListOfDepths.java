package testPackage.tree;

import java.util.LinkedList;

/**
 * Created by bajmd on 13/04/17.
 */
public class ListOfDepths {
    LinkedList<LinkedList> createLists (TreeNode root) {
        TreeQueue queue = new TreeQueue(10);
        queue.enqueue(root);
        LinkedList<LinkedList> listOfList = new LinkedList<>();

        while (!queue.isEmpty()) {
            int count = queue.size();
            LinkedList<Integer> list= new LinkedList<Integer>();
            while (count-- != 0) {
                TreeNode temp = queue.dequeue();
                list.add(temp.getData());

                if (temp.getleft() != null)
                    queue.enqueue(temp.left);
                if (temp.getRight() != null)
                    queue.enqueue(temp.right);
            }
            listOfList.add(list);
        }
        return listOfList;
    }

    public static void main (String args[]) {
        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree();
        tree.createTree(root);

        ListOfDepths lists = new ListOfDepths();
        lists.createLists(root);
    }
}
