package testPackage.general;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bajmd on 13/07/17.
 */
public class TechGig {
	public static int divideAndRule(int[] input1) {
		// Write code here
		Arrays.sort(input1);
		int length = input1.length;
		int sum1 = 0, sum2 = 0;
		for(int i = 0, j = 1; i < length && j < length;) {
			sum1 += input1[i];
			sum2 += input1[j];
			i += 2;
			j += 2;
		}
		if(sum1 == sum2) {
			return 1;
		}
		else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int output = 0;
		int ip1_size = 0;
		ip1_size = Integer.parseInt(in.nextLine().trim());
		int[] ip1 = new int[ip1_size];
		int ip1_item;
		for(int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {
			ip1_item = Integer.parseInt(in.nextLine().trim());
			ip1[ip1_i] = ip1_item;
		}
		output = divideAndRule(ip1);
		System.out.println(String.valueOf(output));

		in.close();
	}
}
