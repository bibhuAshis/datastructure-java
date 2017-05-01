package testPackage.FooBar.fuel_injection_perfection;

import java.math.BigInteger;

/**
 * Created by bajmd on 30/04/17.
 */
public class Fuel {
    public static int answer(String n) {
        // Your code goes here.
        BigInteger number;
        int steps = 0;
        try {
            number = new BigInteger(n);
        } catch (NumberFormatException ex) {
            return 0;
        }
        if (number.compareTo(BigInteger.ONE) <= 0 ) return 0;
        while (number.compareTo(BigInteger.ONE) > 0) {
            if (number.equals(BigInteger.valueOf(3))) {
                number = number.subtract(BigInteger.ONE);
                steps++;
            }
            else if (number.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                if (number.add(BigInteger.ONE).mod(BigInteger.valueOf(4)).equals(BigInteger.ZERO)) {
                    number = number.add(BigInteger.ONE);
                }
                else {
                    number = number.subtract(BigInteger.ONE);
                }
                steps++;
            }
            else {
                number = number.divide(BigInteger.valueOf(2));
                steps++;
            }
        }
        return steps;
    }

    public static void main (String args[]) {
        String inputstring = "15";

        Fuel solve = new Fuel();
        System.out.println(solve.answer(inputstring));
    }
}
