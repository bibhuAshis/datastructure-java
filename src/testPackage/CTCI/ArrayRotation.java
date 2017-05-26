package testPackage.CTCI;

import java.util.Objects;

import static org.junit.Assert.assertArrayEquals;

//import static

/**
 * Created by bajmd on 17/05/17.
 */
public class ArrayRotation {
    /**
     * <br>
     * Create a rotate method that returns a given array with the elements inside the array rotated n spaces.
     * If n is greater than 0 it should rotate the array to the right.
     * If n is less than 0 it should rotate the array to the left.
     * If n is 0, then it should return the array unchanged.
     * Finally the rotation shouldn't be limited by the indices available in the array.
     * Meaning that if we exceed the indices of the array it keeps rotating.
     * <br>
     * Examples:
     * <pre>
     *     Object[] data = new Object[]{1, 2, 3, 4, 5};
     *     rotate(data, 1)    =>    {5, 1, 2, 3, 4}
     *     rotate(data, 2)    =>    {4, 5, 1, 2, 3}
     *     rotate(data, 3)    =>    {3, 4, 5, 1, 2}
     *     rotate(data, 4)    =>    {2, 3, 4, 5, 1}
     *     rotate(data, 5)    =>    {1, 2, 3, 4, 5}
     *     rotate(data, 0)    =>    {1, 2, 3, 4, 5}
     *     rotate(data, -1)    =>    {2, 3, 4, 5, 1}
     *     rotate(data, -2)    =>    {3, 4, 5, 1, 2}
     *     rotate(data, -3)    =>    {4, 5, 1, 2, 3}
     *     rotate(data, -4)    =>    {5, 1, 2, 3, 4}
     *     rotate(data, -5)    =>    {1, 2, 3, 4, 5}
     * </pre>
     * Example where the number of rotations exceeds the number of elements in the array:
     * <pre>
     *     Object[] data = new Object[]{1, 2, 3, 4, 5}
     *     rotate(data, 7)        =>    {4, 5, 1, 2, 3}
     *     rotate(data, 11)       =>    {5, 1, 2, 3, 4}
     *     rotate(data, 12478)    =>    {3, 4, 5, 1, 2}
     * </pre>
     */

    public static Object[] rightRotation(Object[] data, int n, Object[] output, int size) {
        for (int i=0; i < n; i++)
            output[i] = data[size-n+i];
        for (int i=n, j=0; i< size; i++, j++)
            output[i] = data[j];
        return output;
    }

    public static Object[] leftRotation(Object[] data, int n, Object[] output, int size) {
        for (int i=0; i < size-n; i++)
            output[i] = data[n+i];
        for (int i=size-n, j=0; i< size; i++, j++)
            output[i] = data[j];
        return output;
    }

    public static Object[] rotate(Object[] data, int n) {
        int size = data.length;
        if (n == 0 || Math.abs(n) == size ) {
            return data;
        }
        else{
            Object[] output = new Object[size];

            if (n > 0 && n < size)
                rightRotation(data, n, output, size);

            else if (n < 0 && Math.abs(n) < size)
                leftRotation(data, Math.abs(n), output, size);

            else if (n > 0 && n > size) {
                int k = n/size;
                n -= (k*size);
                rightRotation(data, n, output, size);
            }

            else if (n < 0 && Math.abs(n) > size) {
                int k = Math.abs(n) / size;
                n = Math.abs(n) - (k * size);
                leftRotation(data, n, output, size);
            }

            return output;
        }
    }

    public static void main(String args[]) {
        //ArrayRotation obj = new ArrayRotation();
        //obj.rotate(new Object[] {1,2,3,4,5} ,11);

        // rotate 1 to the right
        assertArrayEquals(new Object[] { 5, 1, 2, 3, 4 },
                ArrayRotation.rotate(new Object[] { 1, 2, 3, 4, 5 }, 1));

        // rotate 2 to the right
        assertArrayEquals(new Object[] { 4, 5, 1, 2, 3 },
                ArrayRotation.rotate(new Object[] { 1, 2, 3, 4, 5 }, 2));

        // rotate 3 to the right
        assertArrayEquals(new Object[] { 3, 4, 5, 1, 2 },
                ArrayRotation.rotate(new Object[] { 1, 2, 3, 4, 5 }, 3));

        // rotate 4 to the right
        assertArrayEquals(new Object[] { 2, 3, 4, 5, 1 },
                ArrayRotation.rotate(new Object[] { 1, 2, 3, 4, 5 }, 4));

        // rotate 5 to the right
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 },
                ArrayRotation.rotate(new Object[] { 1, 2, 3, 4, 5 }, 5));

        // rotate 6 to the right
        assertArrayEquals(new Object[] { 5, 1, 2, 3, 4 },
                ArrayRotation.rotate(new Object[] { 1, 2, 3, 4, 5 }, 6));

        // rotate 1 to the left
        assertArrayEquals(new Object[] { 2, 3, 4, 5, 1 },
                ArrayRotation.rotate(new Object[] { 1, 2, 3, 4, 5 }, -1));

        // rotate 3 to the left
        assertArrayEquals(new Object[] { 4, 5, 1, 2, 3 },
                ArrayRotation.rotate(new Object[] { 1, 2, 3, 4, 5 }, -3));

        // rotate 5 to the left
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 },
                ArrayRotation.rotate(new Object[] { 1, 2, 3, 4, 5 }, -5));

        // rotate 6 to the left
        assertArrayEquals(new Object[] { 2, 3, 4, 5, 1 },
                ArrayRotation.rotate(new Object[] { 1, 2, 3, 4, 5 }, -6));

        System.out.println("Success!");
    }
}
