class Solution {
    public int maxFrequency(int[] nums, int k) {
        int original = 0;

        for (int num : nums) {
            if (num == k) {
                original++;
            }
        }

        int ans = original;

        for (int x = 1; x <= 50; x++) {
            if (x == k) continue;

            int cur = 0;
            int best = 0;

            for (int num : nums) {
                if (num == x) {
                    cur++;
                } else if (num == k) {
                    cur--;
                }

                cur = Math.max(cur, 0);
                best = Math.max(best, cur);
            }

            ans = Math.max(ans, original + best);
        }

        return ans;
    }
}