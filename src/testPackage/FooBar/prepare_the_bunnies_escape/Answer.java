package testPackage.FooBar.prepare_the_bunnies_escape;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

class Node {

    int x, y, saldo;
    int[][] grid;

    public Node(int x, int y, int saldo, int[][] grid){
        this.x = x;
        this.y = y;
        this.saldo = saldo;
        this.grid = grid;
    }

    public Deque<Node> getNeighbours(int rowCount, int columnCount, int saldo) {
        Deque<Node> neighbors = new ArrayDeque<>();

        if(x > 0) {
            boolean wall = (grid[y][x - 1] == 1);
            if(wall) {
                if(saldo > 0)
                    neighbors.addLast(new Node(x - 1, y, saldo - 1, grid));
            } else {
                neighbors.addLast(new Node(x - 1, y, saldo, grid));
            }
        }

        if(x < columnCount - 1) {
            boolean wall = (grid[y][x + 1] == 1);
            if (wall){
                if (saldo > 0)
                    neighbors.addLast(new Node(x + 1, y, saldo - 1, grid));
            } else
                neighbors.addLast(new Node(x + 1, y, saldo, grid));
        }

        if(y > 0) {
            boolean wall = (grid[y - 1][x] == 1);
            if (wall) {
                if (saldo > 0)
                    neighbors.addLast(new Node(x, y - 1, saldo - 1, grid));
            } else
                neighbors.addLast(new Node(x, y - 1, saldo, grid));
        }

        if (y < rowCount - 1) {
            boolean wall = (grid[y + 1][x] == 1);
            if (wall){
                if (saldo > 0)
                    neighbors.addLast(new Node(x, y + 1, saldo - 1, grid));
            } else
                neighbors.addLast(new Node(x, y + 1, saldo, grid));
        }

        return neighbors;
    }
}

public class Answer {

    int rowCount, coulmnCount, saldo;
    int[][] grid;

    public Answer(int rowCount, int coulmnCount, int saldo, int[][] grid) {
        this.rowCount = rowCount;
        this.coulmnCount = coulmnCount;
        this.saldo = saldo;
        this.grid = grid;
    }

    public int get_escape_route_length() {
        Node source = new Node(0, 0, saldo, grid);
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.addLast(source);
        Map<Node, Integer> distanceMap = new HashMap<Node, Integer>();
        distanceMap.put(source, 1);

        while(queue.peek() != null) {
            Node current_node = queue.pollFirst();

            if(current_node.x == (coulmnCount - 1) && current_node.y == rowCount - 1) {
                return distanceMap.get(current_node);
            }

            for(Node child_node : current_node.getNeighbours(rowCount, coulmnCount, saldo)) {
                if(!distanceMap.containsKey(child_node)) {
                    distanceMap.put(child_node, distanceMap.get(current_node) + 1);
                    queue.addLast(child_node);
                }
            }
        }
        return -1;
    }

    public int answer(int[][] maze) {
        Answer router  = new Answer(maze.length, maze[0].length,1,maze);
        return (router.get_escape_route_length());
    }

    public static void main(String args[]){

        int[][] maze1 = {{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
         {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
         {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
         {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
         {0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
         {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        int[][] maze = {{0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}};

        Answer ans = new Answer (maze.length, maze[0].length,1,maze);
        int route_length = ans.answer(maze);
        System.out.println(route_length);
    }
}
