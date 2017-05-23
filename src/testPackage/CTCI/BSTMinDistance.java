package testPackage.CTCI;

/**
 * Created by bajmd on 09/05/17.
 */
 
class BSTNode {
    public int data;
    public BSTNode left;
    public BSTNode right;
}

public class BSTMinDistance {

    // Construct
    public BSTNode constructTree(int[] array, int size) {
        BSTNode root = new BSTNode();
        root.data = array[0];
        root.left = null;
        root.right = null;
        for(int i = 1; i< size; i++) {
            populateTree(root, array[i]);
        }
        return root;
    }

    // Populate
    private void populateTree(BSTNode root, int i) {
        if(i < root.data) {
            if (root.left == null) {
                BSTNode node = new BSTNode();
                node.data = i;
                node.left = null;
                node.right = null;
                root.left = node;
            } else {
                populateTree(root.left, i);
            }
        } else {
            if (root.right == null) {
                BSTNode node = new BSTNode();
                node.data = i;
                node.left = null;
                node.right = null;
                root.right = node;
            } else {
                populateTree(root.right, i);
            }
        }
    }

    // Find distance between two nodes
    private int findDistance(BSTNode treeHead, int i, int j) {
        BSTNode commonNode = findCommonNode(treeHead, i, j);
        int leftDistance = getDistanceFromCommon(commonNode, i < j ? i : j);
        if (leftDistance == -1) {
            return -1;
        }
        int rightDistance = getDistanceFromCommon(commonNode, i > j ? i : j);
        if (rightDistance == -1) {
            return -1;
        }
        return rightDistance + leftDistance;
    }

    // Find the common ancestor between two nodes
    private BSTNode findCommonNode(BSTNode treeHead, int i, int j) {
        if (treeHead == null)
            return treeHead;
        if (treeHead.data == i || treeHead.data == j)
            return treeHead;
        if (Math.max(i, j) < treeHead.data)
            return findCommonNode(treeHead.left, i, j);
        else if (Math.min(i,j) > treeHead.data)
            return findCommonNode(treeHead.right, i, j);
        else
            return treeHead;
    }

    // Get distance from common node
    private int getDistanceFromCommon(BSTNode root, int i) {
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

    public static void main(String args[]) {
        BSTMinDistance t = new BSTMinDistance();
        int[] array = {5,3,6,1,4,2};
        BSTNode treeHead = t.constructTree(array , array.length);

        int distance = t.findDistance(treeHead, 2, 20);
        System.out.println("Distance : " + distance);

    }
}
