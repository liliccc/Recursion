package algorithm.oneWayRecursion;

public class FastPower {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if (n == 0) {
            return 1 % b;
        }
        int x = fastPower(a, b, n / 2);
        int y = n % 2 != 0 ? (int) (1L * x * a % b) : x;
        return (int) (1L * x * y % b);
    }
}
