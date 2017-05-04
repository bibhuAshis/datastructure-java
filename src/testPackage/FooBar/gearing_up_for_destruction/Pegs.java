package testPackage.FooBar.gearing_up_for_destruction;

/**
 * Created by bajmd on 29/04/17.
 */
class SolveEquation {

    // Solution
    public static double[][] solve(int[] pegs) {
        int n = pegs.length - 1;
        double mat[][] = new double[n][n];
        double constant[][] = new double[n][1];

        // Build Matrix
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j || j-i == 1)
                    mat[i][j] = 1;
            }
        }

        mat[0][0] = 2;
        mat[n-1][0] = 1;

        for (int i=0; i<n; i++)
            constant[i][0] = pegs[i+1]-pegs[i];

        // Invert Matrix
        double inverted_mat[][] = invert(mat);

        // Multiply inverted_mat and constant
        double result[][] = new double[n][1];
        for (int i=0; i<n; i++) {
            for (int j=0; j<1; j++) {
                for (int k=0; k<n; k++) {
                    result[i][j] = result[i][j] + inverted_mat[i][k] * constant[k][j];
                }
            }
        }
        return result;
    }

    // Invert
    public static double[][] invert(double a[][]) {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        gaussian(a, index);

        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k] -= a[index[j]][i]*b[index[i]][k];

        for (int i=0; i<n; ++i) {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    // Gaussian
    public static void gaussian(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        for (int i=0; i<n; ++i) {
            index[i] = i;
        }

        for (int i=0; i<n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1)
                    c1 = c0;
            }
            c[i] = c1;
        }

        int k=0;
        for (int j=0; j< n-1; ++j) {
            double pi1 = 0;
            for (int i=j; i<n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k=i;
                }
            }
            int tmp = index[j];
            index[j] = index[k];
            index[k] = tmp;
            for (int i=j+1; i<n; ++i) {
                double pj = a[index[i]][j]/a[index[j]][j];
                a[index[i]][j] = pj;
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }
}

public class Pegs {
    int[] answer (int[] pegs) {
        int[] answer = new int[2];
        int[] invalid_answer = {-1, -1};
        if (pegs.length < 2) {
            for (int j=0; j<invalid_answer.length; j++)
                System.out.println(invalid_answer[j]);
            return invalid_answer;
        }

        SolveEquation equation = new SolveEquation();
        double result[][] = equation.solve(pegs);
        Long L = Math.round(result[0][0]);

        if (L <= 0){
            for (int j=0; j<invalid_answer.length; j++)
                System.out.println(invalid_answer[j]);
            return invalid_answer;
        }

        else {
            int i = Integer.valueOf(L.intValue());

            if (pegs.length == 2) {
                if (i < 3) {
                    for (int j=0; j<invalid_answer.length; j++)
                        System.out.println(invalid_answer[j]);
                    return invalid_answer;
                }
                else if (i % 3 == 0) {
                    answer[0] = i/3 *2;
                    answer[1] = 1;
                }
                else {
                    answer[0] = i *2;
                    answer[1] = 3;
                }
            }
            else {
                answer[0] = i * 2;
                answer[1] = 1;
            }
        }

        for (int j=0; j<answer.length; j++)
            System.out.println(answer[j]);
        return answer;
    }

    public static void main (String args[]) {
        int[] pegs = {4,14};
        Pegs result = new Pegs();
        result.answer(pegs);
    }
}
