package algorithm.oneWayRecursion;

public class FastPowerRecursion {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        int result = 1 % b;
        while (n != 0) {
            if (n % 2 == 1) {
                result = (int) (1L * result * a % b);
            }
            a = (int)(1L * a * a % b);
            n /= 2;
        }
        return result;
    }
}
