package algorithm.level1oneWayRecursion;

public class DoubleFactorial {
    /**
     * @param n: the given number
     * @return:  the double factorial of the number
     */
    // tail recursion
    public long doubleFactorial(int n) {
        return doubleFactorial(n, 1);
    }

    private long doubleFactorial(int n, long result) {
        if (n <= 2) {
            return n * result;
        }
        return doubleFactorial(n - 2, result * n);
    }
}
