package testPackage.FooBar.gearing_up_for_destruction;

/**
 * Created by bajmd on 29/04/17.
 */
public class Pegs_Alt {

    int[] answer (int[] pegs) {
        int first_peg = pegs[0];
        int sign = -1, coef_denom;
        int [] invalid_answer = {-1,-1};
        int [] valid_answer = new int[2];

        for(int i=0; i<pegs.length; i++) {
            first_peg += 2 * pegs[i] * sign;
            sign *= -1;
        }

        first_peg += pegs[pegs.length-1] * sign;
        first_peg *= 2;

        if (pegs.length %2 == 0)
            coef_denom = 3;
        else
            coef_denom = 1;

        if(first_peg%coef_denom == 0) {
            first_peg /= coef_denom;
            coef_denom = 1;
        }

        double ratio = ((double)first_peg) / ((double)coef_denom);

        for(int i = 0; i < pegs.length - 2; i++) {
            int radius = pegs[i+1] - pegs[i];
            if(ratio < 0 || ratio > (radius-1)) {
                return invalid_answer;
            }
            ratio = radius - ratio;
        }
        valid_answer[0] = first_peg;
        valid_answer[1] = coef_denom;

        return valid_answer;
    }

    public static void main (String args[]) {
        int[] pegs = {2};
        Pegs_Alt result = new Pegs_Alt();
        result.answer(pegs);
    }
}
