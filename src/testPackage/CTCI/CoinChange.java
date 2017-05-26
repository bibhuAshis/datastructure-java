package testPackage.CTCI;

/**
 * Created by bajmd on 24/05/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {
    public static long makeChange(int[] coins, int money) {
        long dp[] = new long[money+1];
        for (int i=1; i<=money; i++)
            dp[i] = Integer.MAX_VALUE-1;
        for (int j=0; j<coins.length; j++) {
            for (int i=1; i<=money; i++) {
                if (i >= coins[j])
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
            }
        }
        return dp[money];
    }

    public static void main(String[] args){
        int n = 6;
        int coins[] = {3,2,4};
        System.out.println(makeChange(coins, n));
    }
}

