package testPackage.general;
import java.util.*;

/**
 * Created by bajmd on 09/12/18.
 */
public class AmazonRoute {
    private int rows;
    private int cols;
    private int minDistance = Integer.MAX_VALUE;

    int removeObstacle (int numRows, int numColumns, List<List<Integer>> lot) {
        if (lot == null || numRows == 0 || numColumns == 0) {
            return -1;
        }

        this.rows = numRows;
        this.cols = numColumns;

        findShortestPath(0,0,lot,0);

        return minDistance == Integer.MAX_VALUE? -1 : minDistance;
    }

    public void findShortestPath (int i, int j, List<List<Integer>> lot, int steps) {
        if (i<0 || j<0 || i>=rows || j>=cols) {
            return;
        }
        int cur = lot.get(i).get(j);

        if (cur == 9) {
            minDistance = Math.min(minDistance, steps);
            return;
        }

        if (cur != -1)
            return;

        lot.get(i).set(j, cur+2);
        findShortestPath(i+1, j, lot, steps+1);
        findShortestPath(i, j+1, lot, steps+1);
        findShortestPath(i-1, j, lot, steps+1);
        findShortestPath(i, j-1, lot, steps+1);
        lot.get(i).set(j, cur-2);
    }
}
