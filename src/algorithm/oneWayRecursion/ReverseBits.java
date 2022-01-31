package algorithm.oneWayRecursion;

public class ReverseBits {
    /**
     * @param n: an integer
     * @return: return an integer
     */
    public long reverseBits(long n) {
        return reverseBits(n, 32, 0);
    }

    private long reverseBits(long n, int pos, long result) {
        if (pos == 1) {
            return result + n;
        }
        long last = n & 1;
        result += last << (pos -1);
        return reverseBits(n >> 1, pos - 1, result);
    }
}
