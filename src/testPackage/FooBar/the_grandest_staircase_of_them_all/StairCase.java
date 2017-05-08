package testPackage.FooBar.the_grandest_staircase_of_them_all;
import java.util.Arrays;

/**
 * Created by bajmd on 07/05/17.
 */
public class StairCase {
    public static void main(String args[]) {
        StairCase steps = new StairCase();
        int n = 200;
        System.out.println(steps.answer(n));
    }

    public static int answer(int n) {

    // Your code goes here.

        int MAX_BRICK = 200;

        int[][] matrix = new int[MAX_BRICK+1][MAX_BRICK+1];
        for (int current_bricks = 1; current_bricks < MAX_BRICK+1 ; current_bricks++) {
            for (int next_bricks = 1; next_bricks <= current_bricks; next_bricks++) {
                if ((current_bricks == 1 && next_bricks == 1) || (current_bricks == 2 && next_bricks == 2))
                    matrix[current_bricks][next_bricks] = 1;
                else if (current_bricks - next_bricks == 0)
                    matrix[current_bricks][next_bricks] = 1 + matrix[current_bricks][next_bricks - 1];
                else if (current_bricks - next_bricks < next_bricks)
                    matrix[current_bricks][next_bricks] = matrix[current_bricks - next_bricks][current_bricks - next_bricks] + matrix[current_bricks][next_bricks - 1];
                else if (current_bricks - next_bricks == next_bricks)
                    matrix[current_bricks][next_bricks] = matrix[next_bricks][next_bricks - 1] + matrix[current_bricks][next_bricks - 1];
                else if (current_bricks - next_bricks > next_bricks)
                    matrix[current_bricks][next_bricks] = matrix[current_bricks - next_bricks][next_bricks - 1] + matrix[current_bricks][next_bricks - 1];
            }
        }
        return matrix[n][n] - 1;
    }
}
