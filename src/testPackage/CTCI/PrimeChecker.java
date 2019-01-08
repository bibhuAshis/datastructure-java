package testPackage.CTCI;

import java.util.Scanner;

/**
 * Created by bajmd on 19/05/17.
 */
public class PrimeChecker {
    private static Scanner in;

	private void isPrime(int n) {
        for (int i=2; i<=n/2; i++) {
            int temp = n%i;
            if (temp == 0) {
                System.out.println("Not prime");
                break;
            }
        }
        System.out.println("Prime");
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        PrimeChecker obj = new PrimeChecker();
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            obj.isPrime(n);
        }
    }
}
