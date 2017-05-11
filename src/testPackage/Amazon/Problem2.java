package testPackage.Amazon;

/**
 * Created by bajmd on 09/05/17.
 */
class BSTNode {
    public int data;
    public BSTNode left;
    public BSTNode right;
}

public class Problem2 {

    // Construct
    public BSTNode constructTree(int[] array, int size) {
        BSTNode treeHead = new BSTNode();
        treeHead.data = array[0];
        treeHead.left = null;
        treeHead.right = null;
        for(int i = 1; i< size; i++) {
            populateTree(treeHead, array[i]);
        }
        return treeHead;
    }

    // Populate
    private void populateTree(BSTNode treeHead, int i) {
        if(i < treeHead.data) {
            if (treeHead.left == null) {
                BSTNode node = new BSTNode();
                node.data = i;
                node.left = null;
                node.right = null;
                treeHead.left = node;
            } else {
                populateTree(treeHead.left, i);
            }
        } else {
            if (treeHead.right == null) {
                BSTNode node = new BSTNode();
                node.data = i;
                node.left = null;
                node.right = null;
                treeHead.right = node;
            } else {
                populateTree(treeHead.right, i);
            }
        }
    }

    // Find distance between two nodes
    private int findDistance(BSTNode treeHead, int i, int j) {
        BSTNode root = findCommonNodes(treeHead, i, j);
        int leftDistance = getDistanceFromRoot(root, i < j ? i : j);
        if (leftDistance == -1) {
            return -1;
        }
        int rightDistance = getDistanceFromRoot(root, i > j ? i : j);
        if (rightDistance == -1) {
            return -1;
        }
        return rightDistance + leftDistance;
    }

    // Get distance from common node
    private int getDistanceFromRoot(BSTNode root, int i) {
        int distance = 0;
        int data = -1;
        while (root != null) {
            if (root.data == i) {
                data = root.data;
                break;
            }
            distance++;
            if (i < root.data)
                root = root.left;
            else if (i > root.data)
                root = root.right;
        }
        if (data == i)
            return distance;
        else
            return -1;
    }

    // Find the common ancester between two nodes
    private BSTNode findCommonNodes(BSTNode treeHead, int i, int j) {
        if (treeHead == null)
            return treeHead;
        if (treeHead.data == i || treeHead.data == j)
            return treeHead;
        if (Math.max(i, j) < treeHead.data)
            return findCommonNodes(treeHead.left, i, j);
        else if (Math.min(i,j) > treeHead.data)
            return findCommonNodes(treeHead.right, i, j);
        else
            return treeHead;
    }

    public static void main(String args[]) {
        Problem2 t = new Problem2();
        int[] array = {5,3,6,1,4,2};
        BSTNode treeHead = t.constructTree(array , array.length);

        int distance = t.findDistance(treeHead, 2, 20);
        System.out.println("Distance : " + distance);

    }
}
