package algorithm.oneWayRecursion;

public class ReverseBitsNonRecursion {
    /**
     * @param n: an integer
     * @return: return an integer
     */
    public long reverseBits(long n) {
        return reverseBits(n, 32, 0);
    }

    private long reverseBits(long n, int pos, long result) {
        while (true) {
            if (pos == 1) {
                return result + n;
            }
            long last = n & 1;
            long nextN = n >> 1;
            int nextPos = pos - 1;
            // error before: long nextResult = result + last << (nextPos);
            long nextResult = result + (last << (nextPos));
            n = nextN;
            pos = nextPos;
            result = nextResult;
        }
    }
}
