package testPackage.general;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajmd on 30/04/17.
 */
public class Fuel {
    static int answerUtil (BigInteger n, Map<BigInteger, Integer> map, int steps) {
        if (map.containsKey(n)) {
            return (map.get(n)+steps);
        }
        else if (map.containsKey(n.subtract(BigInteger.ONE))) {
            return (1+map.get(n.subtract(BigInteger.ONE))+steps);
        }
        else if (map.containsKey(n.add(BigInteger.ONE))) {
            return (1+map.get(n.add(BigInteger.ONE))+steps);
        }
        else if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            n = n.divide(BigInteger.valueOf(2));
            steps++;
            return (answerUtil(n, map, steps));
        }
        else {
            n = n.subtract(BigInteger.ONE);
            steps++;
            return (answerUtil(n, map, steps));
        }
    }

    static int answer (String n) {
        BigInteger number;
        try {
            number = new BigInteger(n);
        } catch (NumberFormatException ex) {
            return 0;
        }
        int count = 1, steps = 0;
        double power = 1;
        Map<BigInteger, Integer> map = new HashMap<>();
        while (!(BigDecimal.valueOf(Math.pow(2, power)).toBigInteger().compareTo(number) >= 0)) {
            map.put(BigDecimal.valueOf(Math.pow(2, power)).toBigInteger(), count);
            power++;
            count++;
        }
        map.put(BigDecimal.valueOf(Math.pow(2, power)).toBigInteger(), count);

        if (number.equals(BigInteger.ONE)) return 0;
        else return (answerUtil(number, map, steps));
    }

    public static void main (String args[]) {
        String inputstring = "4";

        Fuel solve = new Fuel();
        System.out.println(solve.answer(inputstring));
    }
}
