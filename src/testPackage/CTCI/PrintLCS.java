package testPackage.CTCI;

/**
 * Created by bajmd on 23/05/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrintLCS {
    public void findLCS(int[] X, int[] Y, int m, int n) {
        int L[][] = new int[m+1][n+1];
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        printLCS(L,X,Y,m,n);
    }

    public void printLCS(int[][] L, int[] X, int[] Y, int m, int n) {
        int index = L[m][n];
        int[] lcs = new int[index];
        while (m > 0 && n > 0) {
            if (X[m-1] == Y[n-1]) {
                lcs[index-1] = X[m-1];
                m--; n--; index--;
            }
            else if (L[m-1][n] > L[m][n-1])
                m--;
            else
                n--;
        }
        for (int i=0; i<lcs.length; i++)
            System.out.print(lcs[i] + " ");
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PrintLCS obj = new PrintLCS();
        int X[] = {1,2,3,4,1};
        int Y[] = {3,4,1,2,1,3};
        int m = X.length;
        int n = Y.length;
        obj.findLCS(X,Y,m,n);
    }
}
