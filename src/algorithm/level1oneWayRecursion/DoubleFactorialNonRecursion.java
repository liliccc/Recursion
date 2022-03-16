package algorithm.level1oneWayRecursion;

public class DoubleFactorialNonRecursion {
    /**
     * @param n: the given number
     * @return:  the double factorial of the number
     */
    public long doubleFactorial(int n) {
        return doubleFactorial(n, 1);
    }

    private long doubleFactorial(int n, long result) {
        while(true) {
            if (n <= 2) {
                return n * result;
            }
            long nextResult = n * result;
            int nextN = n - 2;
            n = nextN;
            result = nextResult;
        }
    }
}
