class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n * (n + 1) / 2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[index++] = sum;
            }
        }

        Arrays.sort(sums);

        long result = 0;
        int mod = 1000000007;

        for (int i = left - 1; i < right; i++) {
            result = (result + sums[i]) % mod;
        }

        return (int) result;
    }
}