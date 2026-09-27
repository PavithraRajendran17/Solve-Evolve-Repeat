class Solution {
    public int arrangeCoins(int n) {
        long row = 0;
        while (row + 1 <= n) {
            row++;
            n -= row;
        }
        return (int) row;
    }
}