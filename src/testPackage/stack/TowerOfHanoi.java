package testPackage.stack;
import java.lang.*;

/**
 * Created by bajmd on 15/03/17.
 * Problem Statement: Write a program‘‘me to move all disks from 1st disk to 3rd disk in a Tower of Hanoi problem.
 */
class TowerOfHanoiSolver{

    private void iterativeSolEven (Stack A, Stack B, Stack C, double diskno) {

        double loop = countLoops(diskno);
        for(int i = 0; i < loop;) {

            if(i++ < loop) {
                swapDisks(A, B);
            } else {
                break;
            }

            if(i++ < loop) {
                swapDisks(A, C);
            } else {
                break;
            }

            if(i++ < loop) {
                swapDisks(B, C);
            } else {
                break;
            }
        }
    }

    private void iterativeSolOdd (Stack A, Stack B, Stack C, double diskno) {

        double loop = countLoops(diskno);
        for(int i = 0; i < loop;) {

            if(i++ < loop) {
                swapDisks(A, C);
            } else {
                break;
            }

            if(i++ < loop) {
                swapDisks(A, B);
            } else {
                break;
            }

            if(i++ < loop) {
                swapDisks(B, C);
            } else {
                break;
            }
        }
    }

    private double countLoops(double diskno) {
        return Math.pow(2, diskno) - 1;
    }

    private void swapDisks (Stack X, Stack Y) {
        if ((X.peek() != 0 && X.peek() < Y.peek()) || Y.top < 0)
            Y.push(X.pop());
        else
            X.push(Y.pop());
    }

    public void solveTowerOfHanoi (Stack A, Stack B, Stack C, double diskno) {
        if (diskno % 2 == 0) {
            iterativeSolEven(A, B, C, diskno);
        }
        else {
            iterativeSolOdd(A, B, C, diskno);
        }
    }
}
public class TowerOfHanoi {
    public static void main (String args[]) {
        double diskno = 5;
        Stack A = new Stack((int)diskno);
        Stack B = new Stack((int)diskno);
        Stack C = new Stack((int)diskno);

        A.push(5);
        A.push(4);
        A.push(3);
        A.push(2);
        A.push(1);
        A.print();

        TowerOfHanoiSolver solver = new TowerOfHanoiSolver();
        solver.solveTowerOfHanoi(A, B, C, diskno);
        A.print();
        C.print();
        System.out.println(C.getTop());
    }
}
