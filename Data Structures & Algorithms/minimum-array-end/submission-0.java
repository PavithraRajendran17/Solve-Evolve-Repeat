class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long num = n - 1;
        int bitPos = 0;
        while (num > 0) {
            if ((ans & (1L << bitPos)) == 0) {
                if ((num & 1) == 1) {
                    ans |= (1L << bitPos);
                }

                num >>= 1;
            }
            bitPos++;
        }
        return ans;
    }
}