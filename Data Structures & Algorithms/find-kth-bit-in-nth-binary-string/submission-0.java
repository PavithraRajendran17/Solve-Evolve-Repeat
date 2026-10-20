class Solution {
    public String findKthBit(int n, int k) {
        if (n == 1) {
            return "0";
        }

        int mid = 1 << (n - 1);

        if (k == mid) {
            return "1";
        }

        if (k < mid) {
            return findKthBit(n - 1, k);
        }

        String bit = findKthBit(n - 1, (1 << n) - k);
        return bit.equals("0") ? "1" : "0";
    }
}