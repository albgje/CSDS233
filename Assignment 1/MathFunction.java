/**
 * MathFunction.java
 * This class contains several math functions:
 * - (given) multiply: multiplies 2 by a number (x) x times (2*x^x)
 * - multiplyRecursive: multiplies 2 by a number (x) x times using recursion (2*x^x)
 * - (given) sqrt: finds the square root of a number using binary search
 * - sqrtIterative: finds the square root of a number using iterative binary search
 */
public class MathFunction {

    public static void main(String[] args) {
        System.out.println("MathFunction");
        //System.out.println("exp_method(4) = " + exp_method(4));
        //System.out.println("multiply(4) = " + multiply(4));
        //System.out.println("sqrt(169,0,20): " + sqrt(169, 0, 20));
        //System.out.println("sqrtIterative(169,0,20): " + sqrtIterative(169, 0, 20));
    }

    // Given method
    public static int multiply(int x) {
        int y = 2;
        for (int i = 0; i < x; i++) {
            y *= x;
        }
        return y;
    }

    // Wrapper method for recursive method
    // Takes in one parameter and calls the recursive method
    public static int multiplyRecursive(int x) {
        return 2 * multiplyRecursive(x, x);
    }

    // Recursive method to multiply 2 by a number x times
    private static int multiplyRecursive(int x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        } 
        // Recursive case
        // Multiply x by the result of the next call
        // Decrease n by 1
        else {
            return x * multiplyRecursive(x, n - 1);
        }
    }

    // Given method
    public static int sqrt(int x, int low, int high) {
        if (low > high || x < 0 || low < 0 || high < 0)
            return -1;
        int p = low + (high - low) / 2;
        if (p * p == x)
            return p;
        else if (p * p > x)
            return sqrt(x, low, p - 1);
        else
            return sqrt(x, p + 1, high);
    }

    // Iterative method to find the square root of a number using binary search
    public static int sqrtIterative(int x, int low, int high) {
        // Run condition
        while (!(low > high || x < 0 || low < 0 || high < 0)) {
            // Calculate midpoint
            int p = low + (high - low) / 2;
            // Check if the square of the midpoint is equal to the number
            // If it is, return the midpoint
            // If the square is greater than the number, set the high bound to the midpoint - 1
            // If the square is less than the number, set the low bound to the midpoint + 1
            if (p * p == x)
                return p;
            else if (p * p > x)
                high = p - 1;
            else
                low = p + 1;
        }
        // Return -1 if the number is negative or the bounds are invalid
        return -1;
    }

}