package testPackage.tree;

/**
 * Created by bajmd on 09/04/17.
 */
public class TreeQueue {
    public TreeNode array[];
    private int front, rear, size;

    // Constructor
    public TreeQueue(int n) {
        size = n;
        array = new TreeNode[size];
        front = 0;
        rear = -1;
    }

    // Front Getter
    public int getFront() {
        return this.front;
    }

    // Rear Getter
    public int getRear() {
        return this.rear;
    }

    // Front Setter
    public void setFront(int front) {
        this.front = front;
    }

    // Rear Setter
    public void setRear(int rear) {
        this.rear = rear;
    }

    // Enqueue
    public void enqueue(TreeNode root) {
        if (rear == -1 || (front >= 0 && rear < array.length-1) || rear < front) {
            rear++;
            array[rear] = root;
        }
        else if (front > 0 && rear == array.length-1) {
            rear = 0;
            array[rear] = root;
        }
    }

    // Dequeue
    public TreeNode dequeue() {
        if (rear == -1 || array[front] == null) {
            return null;
        }
        else if (front == array.length-1 && rear < array.length-1) {
            TreeNode temp = array[front];
            array[front] = null;
            front = 0;
            return temp;
        }
        else {
            TreeNode temp = array[front];
            array[front++] = null;
            return temp;
        }
    }

    // Queue Size
    public int size() {
        if (rear == -1 && front == 0)
            return 0;
        else if (rear < front)
            return ((array.length) - (Math.abs(rear - front) + 1));
        else
            return ((rear - front) + 1);
    }

    // Is Empty
    public boolean isEmpty() {
        if (rear == -1 || array[front] == null) {
            return true;
        }
        else
            return false;
    }

    public static void main(String args []) {
        TreeQueue queue = new TreeQueue(5);
    }
}
